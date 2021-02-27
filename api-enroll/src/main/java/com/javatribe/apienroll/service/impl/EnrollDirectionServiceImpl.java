package com.javatribe.apienroll.service.impl;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.dao.EnrollDirectionMapper;
import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.entity.EnrollDirectionQTO;
import com.javatribe.apienroll.service.EnrollDirectionService;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 22:07
 * @description
 */
@Service
public class EnrollDirectionServiceImpl implements EnrollDirectionService {
    private static final Logger logger = LoggerFactory.getLogger(EnrollNoticeAdminServiceImpl.class);    @Resource
    private EnrollDirectionMapper enrollDirectionMapper;

    @Override
    public Response<List<EnrollDirection>> query(EnrollDirectionQTO qto) {
        qto.createCriteria().andDeleteMarkEqualTo(0);
        return new Response<>(enrollDirectionMapper.selectByExample(qto));
    }

    @Override
    public Response<Integer> add(EnrollDirection enrollDirection) {
        if (ObjectUtil.isNull(enrollDirection)) {
            logger.info("参数不合法->{}",enrollDirection);
        }
        return new Response<>(enrollDirectionMapper.insertSelective(enrollDirection));
    }
}
