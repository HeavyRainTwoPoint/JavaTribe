package com.javatribe.apienroll.service.admin.impl;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.dao.EnrollNoticeMapper;
import com.javatribe.apienroll.entity.EnrollNotice;
import com.javatribe.apienroll.entity.EnrollNoticeQTO;
import com.javatribe.apienroll.service.admin.EnrollNoticeAdminService;
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
 * @date 2021/2/27 13:36
 * @description
 */
@Service
public class EnrollNoticeAdminServiceImpl implements EnrollNoticeAdminService {

    private static final Logger logger = LoggerFactory.getLogger(EnrollNoticeAdminServiceImpl.class);

    @Resource
    private EnrollNoticeMapper enrollNoticeMapper;



    @Override
    public Response<List<EnrollNotice>> query(EnrollNoticeQTO qto) {
        qto.createCriteria().andDeleteMarkEqualTo(0);
        Response<List<EnrollNotice>> res = new Response<>();
        res.setData(enrollNoticeMapper.selectByExample(qto));
        res.setTotalCount(enrollNoticeMapper.countByExample(qto));
        return res;
    }

    @Override
    public Response<Integer> add(EnrollNotice enrollNotice) {
        if (ObjectUtil.isNull(enrollNotice)) {
            logger.info("参数不合法->{}",enrollNotice);
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        return new Response<>(enrollNoticeMapper.insertSelective(enrollNotice));
    }

    @Override
    public Response<Integer> update(EnrollNotice enrollNotice) {
        if (NumberUtil.isInValidNum(enrollNotice.getId())) {
            logger.info("参数不合法 -> {}",enrollNotice.getId());
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        enrollNotice.setGmtModified(new Date());
        return new Response<Integer>(enrollNoticeMapper.updateByPrimaryKeySelective(enrollNotice));
    }

    @Override
    public Response<Integer> delete(EnrollNoticeQTO qto) {
        EnrollNotice notice = new EnrollNotice();
        notice.setDeleteMark(1);
        return new Response<>(enrollNoticeMapper.updateByExampleSelective(notice,qto));
    }


    @Override
    public Response<Integer> deleteById(EnrollNotice enrollNotice) {
        if (NumberUtil.isInValidNum(enrollNotice.getId())) {
            logger.info("参数不合法 -> {}",enrollNotice.getId());
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        enrollNotice.setDeleteMark(1);
        return new Response<Integer>(enrollNoticeMapper.updateByPrimaryKeySelective(enrollNotice));
    }


}
