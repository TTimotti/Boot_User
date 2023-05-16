package project.boot.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"project.boot.bbs.mapper"})
@SpringBootApplication
public class BootBbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBbsApplication.class, args);
	}

}
