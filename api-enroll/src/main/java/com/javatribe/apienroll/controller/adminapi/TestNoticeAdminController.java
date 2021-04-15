package com.javatribe.apienroll.controller.adminapi;

import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.dto.FileDataDTO;
import com.javatribe.apienroll.entity.TestNotice;
import com.javatribe.apienroll.entity.TestNoticeQTO;
import com.javatribe.apienroll.service.admin.TestNoticeAdminService;
import com.javatribe.apienroll.utils.NumberUtil;
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
    @AdminAuthentication
    public Response<Integer> add(@RequestBody TestNotice testNotice) {
        return testNoticeAdminService.add(testNotice);
    }

    // 根据id删除
    @GetMapping("/delete_by_id")
    @AdminAuthentication
    public Response<Integer> deleteById(Long id) {
        TestNotice testNotice = new TestNotice();
        testNotice.setId(id);
        return testNoticeAdminService.deleteById(testNotice);
    }

    // 根据id批量删除（,分割）
    @GetMapping("/delete")
    @AdminAuthentication
    public Response<Integer> delete(@RequestParam("ids") String ids) {
        TestNoticeQTO qto = new TestNoticeQTO();
        qto.createCriteria().andIdIn(
                Arrays.stream(ids.trim().split(",")).map(Long::valueOf).collect(Collectors.toList())
        );
        return testNoticeAdminService.delete(qto);
    }

    @GetMapping("/query_list")
    @TokenFreeAnnotation
    public Response<List<TestNotice>> query(@RequestParam("direction_code") Integer directionCode) {
        if (ObjectUtil.isNull(directionCode)) directionCode = 1;
        TestNoticeQTO qto = new TestNoticeQTO();
        // 根据方向查询
        qto.createCriteria()
                .andDeleteMarkEqualTo(0)
                .andTestDirectionEqualTo(directionCode);
        return testNoticeAdminService.query(qto);
    }

    @PostMapping("/update")
    @AdminAuthentication
    public Response update(@RequestBody TestNotice testNotice) {
        return testNoticeAdminService.update(testNotice);
    }


    @GetMapping("/file_data")
    @AdminAuthentication
    public Response<FileDataDTO> getFileDataByTestNoticeId(@RequestParam("id") Long id) {
        if (NumberUtil.isInValidNum(id)) return Response.fail(ResponseStatus.PARAMS_ERROR);
        TestNoticeQTO qto = new TestNoticeQTO();
        qto.createCriteria().andDeleteMarkEqualTo(0).andIdEqualTo(id);
        return Response.success(testNoticeAdminService.getFileData(qto));
    }

}
