package com.javatribe.apienroll.service.admin.impl;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.dao.EnrollDirectionMapper;
import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.entity.EnrollDirectionQTO;
import com.javatribe.apienroll.entity.EnrollNotice;
import com.javatribe.apienroll.entity.EnrollNoticeQTO;
import com.javatribe.apienroll.service.admin.EnrollDirectionAdminService;
import com.javatribe.apienroll.utils.NumberUtil;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 22:07
 * @description
 */
@Service
public class EnrollDirectionAdminServiceImpl implements EnrollDirectionAdminService {
    private static final Logger logger = LoggerFactory.getLogger(EnrollDirectionAdminServiceImpl.class);
    @Resource
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
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        return new Response<>(enrollDirectionMapper.insertSelective(enrollDirection));
    }

    @Override
    public Response<Integer> deleteById(EnrollDirection enrollDirection) {
        if (NumberUtil.isInValidNum(enrollDirection.getId())) {
            logger.info("参数不合法 -> {}",enrollDirection.getId());
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        enrollDirection.setDeleteMark(1);
        return new Response<Integer>(enrollDirectionMapper.updateByPrimaryKeySelective(enrollDirection));

    }



    @Override
    public Response update(EnrollDirection enrollDirection) {
        if (NumberUtil.isInValidNum(enrollDirection.getId())) {
            logger.info("参数不合法 -> {}",enrollDirection.getId());
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        enrollDirection.setGmtModified(new Date());
        return new Response<Integer>(enrollDirectionMapper.updateByPrimaryKey(enrollDirection));

    }






}
