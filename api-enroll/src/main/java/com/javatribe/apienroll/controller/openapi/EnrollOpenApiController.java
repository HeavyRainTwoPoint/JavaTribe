package com.javatribe.apienroll.controller.openapi;

import com.javatribe.apicommon.annotation.ApiAuthentication;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.dto.EnrollNoticeDTO;
import com.javatribe.apienroll.dto.TestNoticeDTO;
import com.javatribe.apienroll.entity.TestNotice;
import com.javatribe.apienroll.service.openapi.EnrollOpenApiService;
import com.javatribe.apienroll.utils.NumberUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/1 22:31
 * @description
 */
@RestController
@RequestMapping("/javatribe/enroll/openapi")
public class EnrollOpenApiController {

    @Resource
    private EnrollOpenApiService enrollOpenApiService;

    /**
     * 获取每个方向最新的考核通知标题
     * @param n 默认为4
     * @return
     */
//    @ApiAuthentication
    @GetMapping("/test_name")
    @ApiAuthentication
    public Response<List<TestNotice>> getLastNTestNameOnDirection(@RequestParam(value = "last_n",required = false) Integer n, @RequestParam("direction_code") Integer directionCode) {
        if (NumberUtil.isInValidNum(n)) {
            n = 4;
        }
        System.out.println(directionCode);
        return enrollOpenApiService.getLastNTestNameOnDirection(n,directionCode);
    }

    /**
     * 获取近几年的招新通知
     * @param n
     * @return
     */
    @GetMapping("/enroll_notice")
    @ApiAuthentication
    public Response<List<List<EnrollNoticeDTO>>>  getEnrollNoticeGroupByYear(@RequestParam(value = "last_n",required = false) Integer n) {
        return enrollOpenApiService.getEnrollNoticeGroupByYear(n);
    }

    /**
     * 根据方向代号获取考核通知的数据
     * @param directionCode
     * @return
     */
    @GetMapping("/test_notice")
    @ApiAuthentication
    public Response<List<TestNoticeDTO>> getTestNoticeOnDirectionCode(@RequestParam(value = "direction_code") Integer directionCode) {
        return enrollOpenApiService.getTestNoticeOnDirection(directionCode);
    }


}
