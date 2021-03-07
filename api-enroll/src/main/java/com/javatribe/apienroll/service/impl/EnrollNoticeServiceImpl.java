package com.javatribe.apienroll.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.dto.EnrollNoticeDTO;
import com.javatribe.apienroll.mapper.EnrollNoticeMapperPlus;
import com.javatribe.apienroll.service.EnrollNoticeService;
import com.javatribe.apienroll.utils.JSONTools;
import com.javatribe.apienroll.utils.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/2 22:21
 * @description
 */
@Service
public class EnrollNoticeServiceImpl implements EnrollNoticeService {
    private static final Logger logger = LoggerFactory.getLogger(EnrollNoticeServiceImpl.class);

    @Resource
    private EnrollNoticeMapperPlus enrollTestMapperPlus;
    @Override
    public Response<List<EnrollNoticeDTO>> getEnrollNoticeAndDocxUrlOnDirection(Integer directionCode) {
        if (NumberUtil.isInValidNum(directionCode)) {
            logger.info("参数不合法。");
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        List<EnrollNoticeDTO> dtoList = enrollTestMapperPlus.getEnrollNoticeAndDocxUrlOnDirection(directionCode);
        if (dtoList.isEmpty()) {
            return Response.success(null);
        }
        dtoList.stream().forEach(x -> {
            x.setDocxUrls(JSONTools.toList(new JSONArray(x.getContentFileUrl()), String.class));
            x.setContentFileUrl("");
        });
        return Response.success(dtoList);
    }
}
