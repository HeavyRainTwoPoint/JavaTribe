package com.javatribe.apienroll.dao;

import com.javatribe.apienroll.entity.TestNotice;
import com.javatribe.apienroll.entity.TestNoticeQTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestNoticeMapper {
    long countByExample(TestNoticeQTO example);

    int deleteByExample(TestNoticeQTO example);

    int deleteByPrimaryKey(Long id);

    int insert(TestNotice record);

    int insertSelective(TestNotice record);

    List<TestNotice> selectByExample(TestNoticeQTO example);

    TestNotice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestNotice record, @Param("example") TestNoticeQTO example);

    int updateByExample(@Param("record") TestNotice record, @Param("example") TestNoticeQTO example);

    int updateByPrimaryKeySelective(TestNotice record);

    int updateByPrimaryKey(TestNotice record);
}