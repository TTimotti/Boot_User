package project.boot.bbs.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {

    @Select("select sysdate from dual")
    public String getTime();
}