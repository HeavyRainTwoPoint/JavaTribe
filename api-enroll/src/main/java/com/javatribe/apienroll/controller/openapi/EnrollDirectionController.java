package com.javatribe.apienroll.controller.openapi;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.service.EnrollDirectionService;
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
@RequestMapping("/javatribe/enroll/openapi/enroll_direction")
public class EnrollDirectionController {

    @Resource
    private EnrollDirectionService enrollDirectionService;

    public Response<List<EnrollDirection>> getLastNItemsOnPerDirection(@RequestParam("last_n") Integer n) {
        return enrollDirectionService.getLastNItemsOnPerDirection(n);
    }
}
