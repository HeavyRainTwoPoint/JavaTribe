package com.javatribe.apicompetition.util;

import com.javatribe.apicompetition.pojo.dto.CompetitionIntroductionDTO;
import com.javatribe.apicompetition.pojo.dto.CompetitionYearDTO;
import com.javatribe.apicompetition.pojo.dto.StyleShowDTO;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.CompetitionYear;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * 属性拷贝
 * @Author lyr
 * @create 2021/3/7 13:03
 */
@Mapper(componentModel = "spring")
public interface BeanMapperUtils {
    /**
     * 比赛
     * @param competitionIntroductionDTO
     * @return
     */
    @Mappings({
            @Mapping(source = "competitionId",target = "competitionId"),
            @Mapping(source = "competitionName",target = "competitionName"),
            @Mapping(source = "showContent",target = "showContent"),
            @Mapping(source = "signUp",target = "signUp"),

    })
    CompetitionIntroduction from(CompetitionIntroductionDTO competitionIntroductionDTO) ;


    /**
     * @param styleShowDTO 部落风采展示
     * @return
     */
    @Mappings({
            @Mapping(source = "showId",target = "showId"),
            @Mapping(source = "competitionId",target = "competitionId"),
            @Mapping(source = "showStatus",target = "showStatus"),
            @Mapping(source = "showOrder",target = "showOrder"),
            @Mapping(source = "imgs",target = "imgs"),
            @Mapping(source = "projectName",target = "projectName"),
            @Mapping(source = "teamName",target = "teamName"),
            @Mapping(source = "teamMembers",target = "teamMembers"),
            @Mapping(source = "theYear",target = "theYear"),
            @Mapping(source = "yearId",target = "yearId"),
            @Mapping(source = "teamBeginTime",target = "teamBeginTime"),
            @Mapping(source = "teamEndTime",target = "teamEndTime"),

    })
    StyleShow from(StyleShowDTO styleShowDTO);

    //
    // /**
    //  * 数据库 对象批量转给 前端
    //  * @return
    //  */
    // List<StyleShowDTO> styleShowEntity2DTO(List<StyleShow> list);

    @Mappings({
            @Mapping(source = "yearId",target = "yearId"),
            @Mapping(source = "theYear",target = "theYear"),
            @Mapping(source = "deleteStatus",target = "deleteStatus"),
            @Mapping(source = "activeStatus",target = "activeStatus"),
            @Mapping(source = "gmtCreate",target = "gmtCreate"),
            @Mapping(source = "gmtModified",target = "gmtModified"),
            @Mapping(source = "yearStartTime",target = "yearStartTime"),
            @Mapping(source = "yearEndTime",target = "yearEndTime"),
            @Mapping(source = "competitionId",target = "competitionId"),
            @Mapping(source = "showOrder",target = "showOrder"),

    })
    CompetitionYear  from(CompetitionYearDTO dto);
}
