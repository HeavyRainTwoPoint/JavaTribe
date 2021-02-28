package com.javatribe.apienroll.service.impl;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.dao.EnrollTestMapper;
import com.javatribe.apienroll.entity.EnrollTest;
import com.javatribe.apienroll.entity.EnrollTestQTO;
import com.javatribe.apienroll.service.EnrollTestAdminService;
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
 * @date 2021/2/28 10:48
 * @description
 */
@Service
public class EnrollTestAdminServiceImpl implements EnrollTestAdminService {

    private static final Logger logger = LoggerFactory.getLogger(EnrollTestAdminServiceImpl.class);

    @Resource
    private EnrollTestMapper enrollTestMapper;

    @Override
    public Response<List<EnrollTest>> query(EnrollTestQTO qto) {
        qto.createCriteria().andDeleteMarkEqualTo(0);
        Response<List<EnrollTest>> res = new Response<>();
        res.setData(enrollTestMapper.selectByExample(qto));
        res.setTotalCount(enrollTestMapper.countByExample(qto));
        return res;
    }

    @Override
    public Response<Integer> add(EnrollTest enrollTest) {
        if (ObjectUtil.isNull(enrollTest)) {
            logger.info("参数不合法->{}",enrollTest);
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        return new Response<>(enrollTestMapper.insertSelective(enrollTest));
    }

    @Override
    public Response<Integer> update(EnrollTest enrollTest) {
        if (NumberUtil.isInValidNum(enrollTest.getId())) {
            logger.info("参数不合法 -> {}",enrollTest.getId());
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        enrollTest.setGmtModified(new Date());
        return new Response<Integer>(enrollTestMapper.updateByPrimaryKey(enrollTest));
    }

    @Override
    public Response<Integer> delete(EnrollTestQTO qto) {
        EnrollTest notice = new EnrollTest();
        notice.setDeleteMark(1);
        return new Response<>(enrollTestMapper.updateByExampleSelective(notice,qto));
    }


    @Override
    public Response<Integer> deleteById(EnrollTest enrollTest) {
        if (NumberUtil.isInValidNum(enrollTest.getId())) {
            logger.info("参数不合法 -> {}",enrollTest.getId());
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        enrollTest.setDeleteMark(1);
        return new Response<Integer>(enrollTestMapper.updateByPrimaryKeySelective(enrollTest));
    }



}
