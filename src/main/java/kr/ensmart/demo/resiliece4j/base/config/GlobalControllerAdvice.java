package kr.ensmart.demo.resiliece4j.base.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(annotations=RestController.class)
@Slf4j
public class GlobalControllerAdvice {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
    public Object handleException(Exception e, HttpServletRequest request) {
		log.error("GlobalControllerAdvice: handleException");
		log.error("", e);
		Map<String, Object> response = new HashMap<>();
		response.put("code", "9999");
		response.put("message", "INTERNAL_SERVER_ERROR");
		//response.put("exception", e);
		return response;
    }

	@ExceptionHandler(RequestNotPermitted.class)
	@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
	@ResponseBody
    public Object handleTooManyRequestsException(Exception e, HttpServletRequest request) {
		log.error("GlobalControllerAdvice: handleTooManyRequestsException");
		log.error("", e);
		Map<String, Object> response = new HashMap<>();
		response.put("code", "0429");
		response.put("message", "TOO_MANY_REQUESTS");
		//response.put("exception", e);
		return response;
    }

}
