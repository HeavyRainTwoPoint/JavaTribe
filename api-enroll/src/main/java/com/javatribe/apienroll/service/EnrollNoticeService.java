package com.javatribe.apienroll.service;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.dto.EnrollNoticeDTO;

import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/2 22:08
 * @description
 */
public interface EnrollNoticeService {
    Response<List<EnrollNoticeDTO>> getEnrollNoticeAndDocxUrlOnDirection(Integer directionCode);
}
