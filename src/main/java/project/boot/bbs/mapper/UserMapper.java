package project.boot.bbs.mapper;

import org.apache.ibatis.annotations.Select;

import project.boot.bbs.entity.UserEntity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Select("select sysdate from dual")
    public String getTime();
    
    public UserEntity selectUserByUserId();
    public int insertUser(UserEntity entity);
}