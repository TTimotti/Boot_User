package project.boot.bbs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class UserEntity {
	private String userId;
	private String userName;
	private String password;
}
