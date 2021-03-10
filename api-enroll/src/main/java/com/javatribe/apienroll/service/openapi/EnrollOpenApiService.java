package com.javatribe.apienroll.service.openapi;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.dto.EnrollNoticeDTO;
import com.javatribe.apienroll.dto.TestNoticeDTO;
import com.javatribe.apienroll.entity.TestNotice;

import java.util.List;
import java.util.Map;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/1 22:03
 * @description
 */
public interface EnrollOpenApiService {
    Response<List<TestNotice>> getLastNTestNameOnDirection(Integer n, Integer directionCode);

    Response<List<List<EnrollNoticeDTO>>> getEnrollNoticeGroupByYear(Integer n);

    Response<Map<String, TestNoticeDTO>> getTestNoticeOnDirection(Integer directionCode);

}
