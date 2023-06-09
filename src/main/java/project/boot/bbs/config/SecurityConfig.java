package project.boot.bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
			.csrf(csrf -> csrf.disable())
			.cors(cors -> cors.disable())
			.authorizeHttpRequests(request -> 
	            request
	                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
	                .requestMatchers("/", "/assets/**", "/user/signIn", "/user/signUp", "/css/**", "/js/**", "/images/**", "/post/**").permitAll()
	                .anyRequest().authenticated()
            )
            .formLogin(login -> 
            		login
            			.loginPage("/user/signIn")		 // 커스텀 로그인 페이지 지정            			
		            .loginProcessingUrl("/login")		 // submit 받을 URL
		            .usernameParameter("userId")		 // username를 대체할 이름 설정
//		            .passwordParameter("password")	 // password를 대체할 이름 설정 | 기본값 = password
		            .defaultSuccessUrl("/", true) 	 // 성공시 이동할 URL
		            .failureUrl("/user/signIn?ERR")
		            .permitAll()
            )
            .logout(logout ->
            		logout
            			.logoutUrl("/logout")
            			.logoutSuccessUrl("/")
            		);

        return http.build();
    }
    
    //passwordEncoder
    @Bean
    BCryptPasswordEncoder encodePassword() {    	
        return new BCryptPasswordEncoder();
    }
}