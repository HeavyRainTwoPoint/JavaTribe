package com.javatribe.apienroll.service.impl;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.mapper.EnrollDirectionMapperPlus;
import com.javatribe.apienroll.service.EnrollDirectionService;
import com.javatribe.apienroll.utils.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/1 22:05
 * @description
 */
@Service
public class EnrollDirectionServiceImpl implements EnrollDirectionService {
    private static final Logger logger = LoggerFactory.getLogger(EnrollDirectionServiceImpl.class);

    @Resource
    private EnrollDirectionMapperPlus enrollDirectionMapperPlus;
    @Override
    public Response<List<EnrollDirection>> getLastNItemsOnPerDirection(Integer n) {
        if (NumberUtil.isInValidNum(n)) {
            logger.error("参数不合法");
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        return Response.success(enrollDirectionMapperPlus.getLastNItemsOnPerDirection(n));
    }
}
