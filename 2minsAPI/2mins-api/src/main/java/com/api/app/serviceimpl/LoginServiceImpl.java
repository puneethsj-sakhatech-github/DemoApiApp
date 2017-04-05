package com.api.app.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.app.dao.LoginDao;
import com.api.app.dto.LoginDTO;
import com.api.app.modal.UserEntity;
import com.api.app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;

	@Override
	@Transactional
	public LoginDTO login() {
		LoginDTO jsonDTO = new LoginDTO();
		UserEntity entity = loginDao.login();
		jsonDTO.setStatus(true);
		jsonDTO.setUserInfo(entity);
		return jsonDTO;
	}

}
