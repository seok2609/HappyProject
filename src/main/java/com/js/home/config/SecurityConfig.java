package com.js.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		
		return web -> web
					.ignoring()	//여기부터 보안에서 무시하세요~
					.antMatchers("/images/**")
					.antMatchers("/css/**")
					.antMatchers("/js/**")
					.antMatchers("/favicon/**")
					.antMatchers("/resources/**")
					.antMatchers("/file/**");
		

	}

	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity
					.cors()
					.and()
					.csrf()
					.disable()
				.authorizeRequests()	//인가 요청
					.antMatchers("/login").permitAll()
					.antMatchers("/logout").permitAll()
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/manager").hasRole("MANAGER")
					.antMatchers("/notice/list").permitAll()
					.antMatchers("/notice/**").hasRole("MEMBER")
					.anyRequest().permitAll()
					.and()
				.formLogin()				// 로그인 폼 인증 설정
				.loginPage("/member/login")	// Spring Security에서 만든 로그인을 쓰지않고 개발자가 만든 로그인 폼 사용
				.passwordParameter("pw")
				.usernameParameter("id")
				.defaultSuccessUrl("/")		//인증에 성공하면 인덱스로 ~
				.failureUrl("/member/login")	//인증에 실패하면 로그인창으로
					.permitAll()
					.and()
				.logout()
				.permitAll();
		
		return httpSecurity.build();
	}
	
	
	@Bean
	//평문 PASSWORD를 암호화로 시켜주는 객체 생성
	public PasswordEncoder getEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
}
