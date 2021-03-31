package com.javatribe.apienroll.controller.adminapi;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.entity.EnrollDirectionQTO;
import com.javatribe.apienroll.service.admin.EnrollDirectionAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 11:31
 * @description  对部落各个方向的操作
 */
@RestController
@RequestMapping("/javatribe/enroll/admin/enroll_direction")
public class EnrollDirectionAdminController {

    @Resource
    private EnrollDirectionAdminService enrollDirectionAdminService;

    // 添加
    @PostMapping("/add")
    public Response<Integer> add(@RequestBody EnrollDirection enrollDirection) {
        return enrollDirectionAdminService.add(enrollDirection);
    }


    @GetMapping("/query_list")
    public Response<List<EnrollDirection>> query() {
        EnrollDirectionQTO qto = new EnrollDirectionQTO();
        return enrollDirectionAdminService.query(qto);
    }
}
