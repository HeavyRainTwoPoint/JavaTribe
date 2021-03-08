package com.javatribe.apienroll.service.openapi.impl;

import cn.hutool.json.JSONArray;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.dto.EnrollNoticeDTO;
import com.javatribe.apienroll.dto.TestNoticeDTO;
import com.javatribe.apienroll.entity.TestNotice;
import com.javatribe.apienroll.mapper.EnrollOpenApiMapper;
import com.javatribe.apienroll.service.openapi.EnrollOpenApiService;
import com.javatribe.apienroll.utils.BeanCopyUtil;
import com.javatribe.apienroll.utils.JSONTools;
import com.javatribe.apienroll.utils.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public Response<List<TestNotice>> getLastNTestNameOnPerDirection(Integer n) {
        if (NumberUtil.isInValidNum(n)) {
            logger.error("参数不合法");
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        return Response.success(enrollOpenApiMapper.getLastNTestNameOnPerDirection(n));
    }

    @Override
    public Response<Map<Integer,List<EnrollNoticeDTO>>> getEnrollNoticeGroupByYear(Integer n) {
        List<EnrollNoticeDTO> dtoList = enrollOpenApiMapper.getEnrollNoticeLastNYears(n);
        if (dtoList.isEmpty()) {
            logger.info("无结果命中");
            return new Response<>();
        }
        Map<Integer,List<EnrollNoticeDTO>> resData = new HashMap<>();
        dtoList.forEach(x -> {
            if (resData.containsKey(x.getYear())) {
                resData.get(x.getYear()).add(x);
            } else {
                List<EnrollNoticeDTO> list = new ArrayList<>();
                list.add(x);
                resData.put(x.getYear(),list);
            }
        });
        return Response.success(resData);
    }

    @Override
    public Response<Map<String, TestNoticeDTO>> getTestNoticeOnDirection(Integer directionCode) {
        if (NumberUtil.isInValidNum(directionCode)) {
            logger.error("参数不合法");
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        Map<String, TestNoticeDTO> resData = new HashMap<>();
        List<TestNotice> list = enrollOpenApiMapper.getTestNoticeOnDirection(directionCode);

        list.forEach(x -> {
            TestNoticeDTO dto = new TestNoticeDTO();
            dto.setTestName(x.getTestName());
            dto.setId(x.getId());
            dto.setTestDirection(x.getTestDirection());
            dto.setDeleteMark(x.getDeleteMark());
            dto.setGmtCreated(x.getGmtCreated());
            dto.setNoticeFileList(JSONTools.toList(new JSONArray(x.getNoticeFile()),String.class));
            resData.put(x.getTestName(),dto);
        });

        return Response.success(resData);
    }
}
