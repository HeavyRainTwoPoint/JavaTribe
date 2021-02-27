package com.javatribe.apienroll.dao;

import com.javatribe.apienroll.entity.EnrollNotice;
import com.javatribe.apienroll.entity.EnrollNoticeQTO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
public interface EnrollNoticeMapper {
    long countByExample(EnrollNoticeQTO example);

    int deleteByExample(EnrollNoticeQTO example);

    int deleteByPrimaryKey(Long id);

    int insert(EnrollNotice record);

    int insertSelective(EnrollNotice record);

    List<EnrollNotice> selectByExample(EnrollNoticeQTO example);

    EnrollNotice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EnrollNotice record, @Param("example") EnrollNoticeQTO example);

    int updateByExample(@Param("record") EnrollNotice record, @Param("example") EnrollNoticeQTO example);

    int updateByPrimaryKeySelective(EnrollNotice record);

    int updateByPrimaryKey(EnrollNotice record);
}