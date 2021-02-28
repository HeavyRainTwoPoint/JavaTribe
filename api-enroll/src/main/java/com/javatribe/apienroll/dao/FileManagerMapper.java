package com.javatribe.apienroll.dao;

import com.javatribe.apienroll.entity.FileManager;
import com.javatribe.apienroll.entity.FileManagerQTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileManagerMapper {
    long countByExample(FileManagerQTO example);

    int deleteByExample(FileManagerQTO example);

    int deleteByPrimaryKey(Long id);

    int insert(FileManager record);

    int insertSelective(FileManager record);

    List<FileManager> selectByExample(FileManagerQTO example);

    FileManager selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileManager record, @Param("example") FileManagerQTO example);

    int updateByExample(@Param("record") FileManager record, @Param("example") FileManagerQTO example);

    int updateByPrimaryKeySelective(FileManager record);

    int updateByPrimaryKey(FileManager record);
}