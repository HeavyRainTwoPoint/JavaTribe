//package com.javatribe.apienroll.service.admin.impl;
//
//import cn.hutool.json.JSONArray;
//import com.javatribe.apicommon.dto.Response;
//import com.javatribe.apicommon.dto.ResponseStatus;
//import com.javatribe.apienroll.dto.EnrollNoticeDTO;
//import com.javatribe.apienroll.utils.JSONTools;
//import com.javatribe.apienroll.utils.NumberUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * @author Liang.Yong.hui
// * @date 2021/3/3 22:00
// * @description
// */
//@Service
//public class TestNoticeServiceImpl implements TestNoticeService {
//    private static final Logger logger = LoggerFactory.getLogger(TestNoticeServiceImpl.class);
//
//    @Resource
//    private TestNoticeMapperPlus testNoticeMapperPlus;
//
//    @Override
//    public Response<List<EnrollNoticeDTO>> getTestNoticeAndDocxUrlOnDirection(Integer directionCode) {
//        if (NumberUtil.isInValidNum(directionCode)) {
//            logger.info("参数不合法。");
//            return Response.fail(ResponseStatus.PARAMS_ERROR);
//        }
//        List<EnrollNoticeDTO> dtoList = testNoticeMapperPlus.getTestNoticeAndDocxUrlOnDirection(directionCode);
//        if (dtoList.isEmpty()) {
//            return Response.success(null);
//        }
//        dtoList.stream().forEach(x -> {
//            x.setDocxUrls(JSONTools.toList(new JSONArray(x.getContentFileUrl()), String.class));
//            x.setContentFileUrl("");
//        });
//        return Response.success(dtoList);
//    }
//
//
//}
