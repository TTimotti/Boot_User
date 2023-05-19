package project.boot.bbs.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.boot.bbs.entity.UserEntity;

@Getter
@ToString
@AllArgsConstructor
public class SignInDTO {
	private String userId;
	private String password;
}
