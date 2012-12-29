package com.ttech.advn.prj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttech.advn.prj.dao.entity.SwitchboardItem;
@Repository
public class SwitchBoardDAO implements ISwitchBoardDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SwitchboardItem> getResultset() {
		return sessionFactory.getCurrentSession().createQuery("from SwitchboardItem").list();
	}

}
