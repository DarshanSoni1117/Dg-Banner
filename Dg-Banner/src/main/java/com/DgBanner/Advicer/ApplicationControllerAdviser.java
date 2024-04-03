package com.DgBanner.Advicer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationControllerAdviser {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleIllegalArgumentException(MethodArgumentNotValidException ex){
		Map<String,String> errorMap= new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {

			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public String handleEmptyResultException(EmptyResultDataAccessException ex) {
		return ex.getMessage();
	}
}
