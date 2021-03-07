package com.javatribe.apienroll.service.common.impl;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.entity.FileManager;
import com.javatribe.apienroll.entity.FileManagerQTO;
import com.javatribe.apienroll.manager.FileCommandManager;
import com.javatribe.apienroll.service.common.FileManagerCommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 17:25
 * @description
 */
@Service
public class FileManagerCommonServiceImpl implements FileManagerCommonService {

    private static final Logger logger = LoggerFactory.getLogger(FileManagerCommonServiceImpl.class);

    @Resource
    private FileCommandManager fileCommandManager;


    @Override
    public Response<List<FileManager>> query(FileManagerQTO qto) {
        return null;
    }

    @Override
    public Response<Integer> add(FileManager fileManager) {
        return null;
    }

    @Override
    public Response<Integer> update(FileManager fileManager) {
        return null;
    }

    @Override
    public Response<Integer> delete(FileManagerQTO qto) {
        return null;
    }

    @Override
    public Response<Integer> deleteById(FileManager fileManager) {
        return null;
    }



//    @Override
//    public Response<List<FileManager>> query(FileManagerQTO qto) {
//        qto.createCriteria().andDeleteMarkEqualTo(0);
//        Response<List<EnrollTest>> res = new Response<>();
//        res.setData(enrollTestMapper.selectByExample(qto));
//        res.setTotalCount(enrollTestMapper.countByExample(qto));
//        return res;
//    }
//
//    @Override
//    public Response<Integer> add(EnrollTest enrollTest) {
//        if (ObjectUtil.isNull(enrollTest)) {
//            logger.info("参数不合法->{}",enrollTest);
//        }
//        return new Response<>(enrollTestMapper.insertSelective(enrollTest));
//    }
//
//    @Override
//    public Response<Integer> update(EnrollTest enrollTest) {
//        Response<Integer> res = new Response<>();
//        if (NumberUtil.isInValidNum(enrollTest.getId())) {
//            logger.info("参数不合法 -> {}",enrollTest.getId());
//            return res;
//        }
//        enrollTest.setGmtModified(new Date());
//        return new Response<Integer>(enrollTestMapper.updateByPrimaryKey(enrollTest));
//    }
//
//    @Override
//    public Response<Integer> delete(EnrollTestQTO qto) {
//        EnrollTest notice = new EnrollTest();
//        notice.setDeleteMark(1);
//        return new Response<>(enrollTestMapper.updateByExampleSelective(notice,qto));
//    }
//
//
//    @Override
//    public Response<Integer> deleteById(EnrollTest enrollTest) {
//        Response<Integer> res = new Response<>();
//        if (NumberUtil.isInValidNum(enrollTest.getId())) {
//            logger.info("参数不合法 -> {}",enrollTest.getId());
//            return res;
//        }
//        enrollTest.setDeleteMark(1);
//        return new Response<Integer>(enrollTestMapper.updateByPrimaryKeySelective(enrollTest));
//    }


}
