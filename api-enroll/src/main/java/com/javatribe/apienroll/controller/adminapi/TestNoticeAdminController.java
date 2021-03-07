package com.javatribe.apienroll.controller.adminapi;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.entity.EnrollTest;
import com.javatribe.apienroll.entity.EnrollTestQTO;
import com.javatribe.apienroll.entity.TestNotice;
import com.javatribe.apienroll.entity.TestNoticeQTO;
import com.javatribe.apienroll.service.EnrollTestAdminService;
import com.javatribe.apienroll.service.TestNoticeAdminService;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 11:31
 * @description  考核通知
 */
@RestController
@RequestMapping("/javatribe/enroll/admin/test_notice")
public class TestNoticeAdminController {
    @Resource
    private TestNoticeAdminService testNoticeAdminService;

    // 添加
    @PostMapping("/add")
    public Response<Integer> add(TestNotice testNotice) {
        return testNoticeAdminService.add(testNotice);
    }

    // 根据id删除
    @GetMapping("/delete_by_id")
    public Response<Integer> deleteById(Long id) {
        TestNotice testNotice = new TestNotice();
        testNotice.setId(id);
        return testNoticeAdminService.deleteById(testNotice);
    }

    // 根据id批量删除（,分割）
    @GetMapping("/delete")
    public Response<Integer> delete(@RequestParam("ids") String ids) {
        TestNoticeQTO qto = new TestNoticeQTO();
        qto.createCriteria().andIdIn(
                Arrays.stream(ids.trim().split(",")).map(Long::valueOf).collect(Collectors.toList())
        );
        return testNoticeAdminService.delete(qto);
    }

    @GetMapping("/query_list")
    public Response<List<TestNotice>> query(TestNotice testNotice) {
        if (ObjectUtil.isNull(testNotice)) return Response.fail(ResponseStatus.PARAMS_ERROR);
        TestNoticeQTO qto = new TestNoticeQTO();
        // 根据方向查询
        qto.createCriteria()
                .andDeleteMarkEqualTo(0)
                .andTestDirectionEqualTo(testNotice.getTestDirection());
        return testNoticeAdminService.query(qto);
    }

    @PostMapping("/update")
    public Response update(TestNotice testNotice) {
        return testNoticeAdminService.update(testNotice);
    }

}
