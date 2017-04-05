package com.api.app.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.dto.LoginDTO;
import com.api.app.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/validate/{name}/{pswd}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> login(@PathVariable("name") String name, @PathVariable("pswd") String pswd,
			 HttpServletRequest request, HttpServletResponse response){
		LoginDTO jsonObj = loginService.login();
		Map<String, Object> responseObj = new LinkedHashMap<>();
		responseObj.put("jsondata", jsonObj);

		return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.OK);

	}
}
