package kr.ensmart.demo.resiliece4j.app.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SampleService {

	public SampleDto getSample(Long id) throws InterruptedException {
		log.info("SampleService executed.");
		Thread.sleep(1000L);
		return SampleDto.builder()
				.id(id)
				.name("testname")
				.description("test description").build();
	}
}
