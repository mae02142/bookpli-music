package com.project.bookpli_music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookpliMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookpliMusicApplication.class, args);
	}

}
