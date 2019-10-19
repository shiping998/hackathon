package com.cmb.XiaoCHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class XiaoCHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaoCHelperApplication.class, args);
	}

}
