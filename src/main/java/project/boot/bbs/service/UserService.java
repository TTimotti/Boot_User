package project.boot.bbs.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import project.boot.bbs.dto.SignUpDTO;
import project.boot.bbs.entity.UserEntity;
import project.boot.bbs.mapper.UserMapper;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    
    public void insertUser(SignUpDTO dto) {
    		String encodedPassword = passwordEncoder.encode(dto.getPassword());    	
    		userMapper.insertUser(UserEntity.builder().userId(dto.getUserId()).userName(dto.getUserName()).password(encodedPassword).build());
    }

	@Override
	public UserDetails loadUserByUsername(String userId) {
		try {			
			return userMapper.selectUserByUserId(userId);
		} catch (Exception e) {
			throw new UsernameNotFoundException("없는 USER");
		}		
	}

}
