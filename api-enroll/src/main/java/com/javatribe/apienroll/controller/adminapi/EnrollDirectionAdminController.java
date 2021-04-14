package com.javatribe.apienroll.controller.adminapi;

import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.ApiAuthentication;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.entity.EnrollDirectionQTO;
import com.javatribe.apienroll.entity.EnrollNotice;
import com.javatribe.apienroll.entity.EnrollNoticeQTO;
import com.javatribe.apienroll.service.admin.EnrollDirectionAdminService;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    @AdminAuthentication
    public Response<Integer> add(@RequestBody EnrollDirection enrollDirection) {
        return enrollDirectionAdminService.add(enrollDirection);
    }


    @GetMapping("/query_list")
    @ApiAuthentication
    public Response<List<EnrollDirection>> query() {
        EnrollDirectionQTO qto = new EnrollDirectionQTO();
        return enrollDirectionAdminService.query(qto);
    }

    // 根据id删除
    @GetMapping("/delete_by_id")
    @AdminAuthentication
    public Response<Integer> deleteById(Long id) {
        EnrollDirection enrollNotice = new EnrollDirection();
        enrollNotice.setId(id);
        return enrollDirectionAdminService.deleteById(enrollNotice);
    }



    @PostMapping("/update")
    @AdminAuthentication
    public Response update(@RequestBody EnrollDirection enrollDirection) {
        return enrollDirectionAdminService.update(enrollDirection);
    }
}
