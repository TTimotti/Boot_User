package project.boot.bbs.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import project.boot.bbs.dto.SignUpDTO;
import project.boot.bbs.entity.UserEntity;
import project.boot.bbs.mapper.UserMapper;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    
    public int insertUser(SignUpDTO dto) {
    		String encodedPassword = passwordEncoder.encode(dto.getPassword());
    	
    		return userMapper.insertUser(UserEntity.builder().userId(dto.getUserId()).userName(dto.getUserName()).password(encodedPassword).build());
    }
    
}
