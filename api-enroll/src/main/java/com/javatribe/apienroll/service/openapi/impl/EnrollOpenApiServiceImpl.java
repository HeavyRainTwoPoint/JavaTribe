package com.javatribe.apienroll.service.openapi.impl;

import cn.hutool.json.JSONArray;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.dao.FileManagerMapper;
import com.javatribe.apienroll.dto.EnrollNoticeDTO;
import com.javatribe.apienroll.dto.TestNoticeDTO;
import com.javatribe.apienroll.entity.FileManager;
import com.javatribe.apienroll.entity.FileManagerQTO;
import com.javatribe.apienroll.entity.TestNotice;
import com.javatribe.apienroll.mapper.EnrollOpenApiMapper;
import com.javatribe.apienroll.service.openapi.EnrollOpenApiService;
import com.javatribe.apienroll.utils.JSONTools;
import com.javatribe.apienroll.utils.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/1 22:05
 * @description
 */
@Service
public class EnrollOpenApiServiceImpl implements EnrollOpenApiService {
    private static final Logger logger = LoggerFactory.getLogger(EnrollOpenApiServiceImpl.class);

    @Resource
    private EnrollOpenApiMapper enrollOpenApiMapper;

    @Resource
    private FileManagerMapper fileManagerMapper;

    @Override
    public Response<List<TestNotice>> getLastNTestNameOnDirection(Integer n, Integer directionCode) {
        if (NumberUtil.isInValidNum(n) || NumberUtil.isInValidNum(directionCode)) {
            logger.error("参数不合法");
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        List<TestNotice> testNoticeTitles = enrollOpenApiMapper.getLastNTestNameOnDirection(n, directionCode);
        Collections.reverse(testNoticeTitles);
        return Response.success(testNoticeTitles);
    }

    @Override
    public Response<List<List<EnrollNoticeDTO>>> getEnrollNoticeGroupByYear(Integer n) {
        List<EnrollNoticeDTO> dtoList = enrollOpenApiMapper.getEnrollNoticeLastNYears(n);
        if (dtoList.isEmpty()) {
            logger.info("无结果命中");
            return new Response<>();
        }
        List<List<EnrollNoticeDTO>> res = new ArrayList<>();
        Map<Integer, List<EnrollNoticeDTO>> resData = new HashMap<>();
        dtoList.forEach(x -> {
            if (resData.containsKey(x.getYear())) {
                resData.get(x.getYear()).add(x);
            } else {
                List<EnrollNoticeDTO> list = new ArrayList<>();
                list.add(x);
                resData.put(x.getYear(), list);
            }
        });
        resData.forEach((k, v) -> {
            res.add(v);
        });

        return Response.success(res);
    }

    @Override
    public Response<List<TestNoticeDTO>> getTestNoticeOnDirection(Integer directionCode) {
        if (NumberUtil.isInValidNum(directionCode)) {
            logger.error("参数不合法");
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        List<TestNoticeDTO> resData = new ArrayList<>();
        List<TestNotice> list = enrollOpenApiMapper.getTestNoticeOnDirection(directionCode);

        list.forEach(x -> {
            TestNoticeDTO dto = new TestNoticeDTO();
            dto.setTestName(x.getTestName());
            dto.setId(x.getId());
            dto.setTestDirection(x.getTestDirection());
            dto.setDeleteMark(x.getDeleteMark());
            dto.setGmtCreated(x.getGmtCreated());
            List<String> urls = JSONTools.toList(new JSONArray(x.getNoticeFile()), String.class);
            if (!urls.isEmpty()) {
                FileManagerQTO qto = new FileManagerQTO();
                qto.createCriteria().andFileUrlIn(urls).andDeleteMarkEqualTo(0);
                List<FileManager> fileManagers = fileManagerMapper.selectByExample(qto);
                dto.setNoticeFileList(fileManagers);
            }
            resData.add(dto);
        });

        return Response.success(resData);
    }
}
