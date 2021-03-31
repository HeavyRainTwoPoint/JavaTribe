package com.javatribe.apienroll.controller.adminapi;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.entity.EnrollTest;
import com.javatribe.apienroll.entity.EnrollTestQTO;
import com.javatribe.apienroll.service.admin.EnrollTestAdminService;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 11:31
 * @description  对已提交的考核的操作
 */
@RestController
@RequestMapping("/javatribe/enroll/admin/enroll_test")
public class EnrollTestAdminController {
    @Resource
    private EnrollTestAdminService enrollTestAdminService;

    // 添加
    @PostMapping("/add")
    public Response<Integer> add(@RequestBody EnrollTest enrollTest) {
        return enrollTestAdminService.add(enrollTest);
    }

    // 根据id删除
    @GetMapping("/delete_by_id")
    public Response<Integer> deleteById(Long id) {
        EnrollTest enrollTest = new EnrollTest();
        enrollTest.setId(id);
        return enrollTestAdminService.deleteById(enrollTest);
    }

    // 根据id批量删除（,分割）
    @GetMapping("/delete")
    public Response<Integer> delete(@RequestParam("ids") String ids) {
        EnrollTestQTO qto = new EnrollTestQTO();
        qto.createCriteria().andIdIn(
                Arrays.stream(ids.trim().split(",")).map(Long::valueOf).collect(Collectors.toList())
        );
        return enrollTestAdminService.delete(qto);
    }

    @GetMapping("/query_list")
    public Response<List<EnrollTest>> query(@RequestBody EnrollTest enrollTest) {
        if (ObjectUtil.isNull(enrollTest))  return Response.fail(ResponseStatus.PARAMS_ERROR);

        EnrollTestQTO qto = new EnrollTestQTO();
        // 根据方向查询
        qto.createCriteria()
                .andDeleteMarkEqualTo(0)
                .andDirectionCodeEqualTo(enrollTest.getDirectionCode());
        return enrollTestAdminService.query(qto);
    }

    @PostMapping("/update")
    public Response update(@RequestBody EnrollTest enrollTest) {
        return enrollTestAdminService.update(enrollTest);
    }





}
