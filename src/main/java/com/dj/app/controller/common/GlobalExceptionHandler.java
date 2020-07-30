package com.dj.app.controller.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dj.app.exception.DMLException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DMLException.class)
	public String handle(DMLException e, Model model) {
		model.addAttribute("msg", e.getMessage());
		return "result/error";
	}
	
}
