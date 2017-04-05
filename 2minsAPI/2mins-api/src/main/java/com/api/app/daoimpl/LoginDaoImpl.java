package com.api.app.daoimpl;


import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.app.dao.LoginDao;
import com.api.app.modal.UserEntity;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public UserEntity login() {
		Session session = sessionFactory.getCurrentSession();
		Criterion idCri = Restrictions.eq("userId", 1);
		Criteria cr = session.createCriteria(UserEntity.class).add(idCri);
		return (UserEntity) cr.uniqueResult();
	}

}
