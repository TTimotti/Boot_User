package project.boot.bbs.dto;


import lombok.Getter;
import lombok.ToString;
import project.boot.bbs.entity.UserEntity;

@Getter
@ToString
public class SignUpDTO {
	private String userId;
	private String userName;
	private String password;
	
	public UserEntity toEntity() {		
		
		return UserEntity.builder().userId(userId).userName(userName).password(password).build();
	}
}
