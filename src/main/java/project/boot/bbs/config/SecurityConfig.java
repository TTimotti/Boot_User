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
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authorizeHttpRequests(request -> 
	            request
	                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
	                .anyRequest().authenticated()
            )
            .formLogin(login -> 
            		login
		            .loginPage("/user/signIn")						// [A] 커스텀 로그인 페이지 지정
		            .loginProcessingUrl("/login-process")				// [B] submit 받을 URL
		            .usernameParameter("userId")						// [C] submit할 ID
		            .passwordParameter("password")					// [D] submit할 비밀번호
		            .defaultSuccessUrl("/view/dashboard", true) 		// [F] 성공시 이동할 URL
		            .permitAll()
            )
            .logout(withDefaults());

        return http.build();
    }
}