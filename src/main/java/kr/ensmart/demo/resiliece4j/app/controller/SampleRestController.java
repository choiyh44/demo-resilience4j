package kr.ensmart.demo.resiliece4j.app.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import kr.ensmart.demo.resiliece4j.app.dto.SampleDto;
import kr.ensmart.demo.resiliece4j.app.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/samples")
public class SampleRestController {
	@Autowired
	private SampleService sampleService;
	
	@GetMapping("/{id}")
	@RateLimiter(name = "createDevice")
	public SampleDto getSample(@PathVariable Long id) throws InterruptedException {
		return sampleService.getSample(id);
	}

}
