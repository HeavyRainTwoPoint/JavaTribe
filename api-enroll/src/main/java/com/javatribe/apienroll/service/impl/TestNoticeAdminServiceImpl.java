package com.javatribe.apienroll.service.impl;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.dao.EnrollNoticeMapper;
import com.javatribe.apienroll.dao.TestNoticeMapper;
import com.javatribe.apienroll.entity.EnrollNotice;
import com.javatribe.apienroll.entity.EnrollNoticeQTO;
import com.javatribe.apienroll.entity.TestNotice;
import com.javatribe.apienroll.entity.TestNoticeQTO;
import com.javatribe.apienroll.service.EnrollNoticeAdminService;
import com.javatribe.apienroll.service.TestNoticeAdminService;
import com.javatribe.apienroll.utils.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 13:36
 * @description
 */
@Service
public class TestNoticeAdminServiceImpl implements TestNoticeAdminService {
    private static final Logger logger = LoggerFactory.getLogger(TestNoticeAdminServiceImpl.class);    @Resource
    private TestNoticeMapper testNoticeMapper;

    @Override
    public Response<List<TestNotice>> query(TestNoticeQTO qto) {
        Response<List<TestNotice>> res = new Response<>();
        qto.createCriteria().andDeleteMarkEqualTo(0);
        res.setData(testNoticeMapper.selectByExample(qto));
        res.setTotalCount(testNoticeMapper.countByExample(qto));
        return res;
    }

    @Override
    public Response<Integer> add(TestNotice testNotice) {
        return new Response<>(testNoticeMapper.insertSelective(testNotice));
    }

    @Override
    public Response<Integer> update(TestNotice testNotice) {
        Response<Integer> res = new Response<>();
        if (NumberUtil.isInValidNum(testNotice.getId())) {
            logger.info("参数不合法 -> {}",testNotice.getId());
            return res;
        }
        return new Response<Integer>(testNoticeMapper.updateByPrimaryKey(testNotice));
    }

    @Override
    public Response<Integer> delete(TestNoticeQTO qto) {
        TestNotice notice = new TestNotice();
        notice.setDeleteMark(1);
        return new Response<>(testNoticeMapper.updateByExampleSelective(notice,qto));
    }


    @Override
    public Response<Integer> deleteById(TestNotice testNotice) {
        Response<Integer> res = new Response<>();
        if (NumberUtil.isInValidNum(testNotice.getId())) {
            logger.info("参数不合法 -> {}",testNotice.getId());
            return res;
        }
        testNotice.setDeleteMark(1);
        return new Response<Integer>(testNoticeMapper.updateByPrimaryKeySelective(testNotice
        ));
    }



}
