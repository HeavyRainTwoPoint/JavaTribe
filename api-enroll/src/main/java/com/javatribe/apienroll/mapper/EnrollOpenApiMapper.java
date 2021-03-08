package com.javatribe.apienroll.mapper;

import com.javatribe.apienroll.dto.EnrollNoticeDTO;
import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.entity.EnrollDirectionQTO;
import com.javatribe.apienroll.entity.TestNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnrollOpenApiMapper {
    List<TestNotice> getLastNTestNameOnPerDirection(@Param("n") Integer n);

    List<EnrollNoticeDTO> getEnrollNoticeLastNYears(@Param("n")Integer n);

    List<TestNotice> getTestNoticeOnDirection(@Param("direction_code")Integer directionCode);
}