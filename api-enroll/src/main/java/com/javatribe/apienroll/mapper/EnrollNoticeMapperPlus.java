package com.javatribe.apienroll.mapper;

import com.javatribe.apienroll.dto.EnrollNoticeDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/2 22:27
 * @description
 */
public interface EnrollNoticeMapperPlus {
    List<EnrollNoticeDTO> getEnrollNoticeAndDocxUrlOnDirection(@Param("direction_code") Integer directionCode);
}
