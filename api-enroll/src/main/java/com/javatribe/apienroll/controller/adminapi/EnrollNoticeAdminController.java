package com.javatribe.apienroll.controller.adminapi;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.entity.*;
import com.javatribe.apienroll.service.EnrollNoticeAdminService;
import com.javatribe.apienroll.service.EnrollTestAdminService;
import com.javatribe.apienroll.service.TestNoticeAdminService;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.QueryEval;
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
    public Response<Integer> add(EnrollNotice enrollNotice) {
        return enrollNoticeAdminService.add(enrollNotice);
    }

    // 根据id删除
    @GetMapping("/delete_by_id")
    public Response<Integer> deleteById(Long id) {
        EnrollNotice enrollNotice = new EnrollNotice();
        enrollNotice.setId(id);
        return enrollNoticeAdminService.deleteById(enrollNotice);
    }

    // 根据id批量删除（,分割）
    @GetMapping("/delete")
    public Response<Integer> delete(@RequestParam("ids") String ids) {
        EnrollNoticeQTO qto = new EnrollNoticeQTO();
        qto.createCriteria().andIdIn(
                Arrays.stream(ids.trim().split(",")).map(Long::valueOf).collect(Collectors.toList())
        );
        return enrollNoticeAdminService.delete(qto);
    }

    @GetMapping("/query_list")
    public Response<List<EnrollNotice>> query(EnrollNotice enrollNotice) {
        if (ObjectUtil.isNull(enrollNotice)) return Response.fail(ResponseStatus.PARAMS_ERROR);
        EnrollNoticeQTO qto = new EnrollNoticeQTO();
        return enrollNoticeAdminService.query(qto);
    }

    @PostMapping("/update")
    public Response update(EnrollNotice enrollNotice) {
        return enrollNoticeAdminService.update(enrollNotice);
    }

}
