package project.boot.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
			.csrf(csrf -> csrf.disable())
			.cors(cors -> cors.disable())
			.authorizeHttpRequests(request -> 
	            request
	                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
	                .requestMatchers("/status", "/assets/**", "/user/siginIn", "/user/signUp", "/css/**", "/js/**", "/images/**").permitAll()
	                .anyRequest().authenticated()
            )
            .formLogin(login -> 
            		login
//            			.loginPage("/user/signIn")						// [A] 커스텀 로그인 페이지 지정
            			.loginPage("/")
		            .loginProcessingUrl("/login-process")				// [B] submit 받을 URL
		            .usernameParameter("userId")						// [C] username를 대체할 이름 설정
//		            .passwordParameter("password")					// [D] password를 대체할 이름 설정 | 기본값 = password
		            .defaultSuccessUrl("/view/dashboard", true) 		// [F] 성공시 이동할 URL
		            .permitAll()
            )
            .logout(withDefaults());

        return http.build();
    }
}