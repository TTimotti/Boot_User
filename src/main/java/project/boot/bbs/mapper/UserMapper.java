package project.boot.bbs.mapper;

import org.apache.ibatis.annotations.Mapper;

import project.boot.bbs.entity.UserEntity;

@Mapper
public interface UserMapper {   
    public int insertUser(UserEntity entity);
    
    public UserEntity selectUserByUserId(String userId);
}