package com.javatribe.apienroll.controller.adminapi;

import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.entity.*;
import com.javatribe.apienroll.service.admin.EnrollNoticeAdminService;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 11:31
 * @description  招新通知
 */
@RestController
@RequestMapping("/javatribe/enroll/admin/enroll_notice")
public class EnrollNoticeAdminController {
    @Resource
    private EnrollNoticeAdminService enrollNoticeAdminService;

    // 添加
    @PostMapping("/add")
    @AdminAuthentication
    public Response<Integer> add(@RequestBody EnrollNotice enrollNotice) {
        System.out.println(enrollNotice.getContent());
        System.out.println(enrollNotice.getTitle());
        System.out.println(enrollNotice.getDirectionCode());

        return enrollNoticeAdminService.add(enrollNotice);
    }

    // 根据id删除
    @GetMapping("/delete_by_id")
    @AdminAuthentication
    public Response<Integer> deleteById(Long id) {
        EnrollNotice enrollNotice = new EnrollNotice();
        enrollNotice.setId(id);
        return enrollNoticeAdminService.deleteById(enrollNotice);
    }

    // 根据id批量删除（,分割）
    @GetMapping("/delete")
    @AdminAuthentication
    public Response<Integer> delete(@RequestParam("ids") String ids) {
        EnrollNoticeQTO qto = new EnrollNoticeQTO();
        qto.createCriteria().andIdIn(
                Arrays.stream(ids.trim().split(",")).map(Long::valueOf).collect(Collectors.toList())
        );
        return enrollNoticeAdminService.delete(qto);
    }

    @GetMapping("/query_list")
    @AdminAuthentication
    public Response<List<EnrollNotice>> query() {
        EnrollNoticeQTO qto = new EnrollNoticeQTO();
        qto.createCriteria().andDeleteMarkEqualTo(0);
        return enrollNoticeAdminService.query(qto);
    }

    @PostMapping("/update")
    @AdminAuthentication
    public Response update(@RequestBody EnrollNotice enrollNotice) {
        return enrollNoticeAdminService.update(enrollNotice);
    }

}
