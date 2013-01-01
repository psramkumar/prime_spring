package com.ttech.advn.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttech.advn.prj.dao.ISwitchBoardDAO;
import com.ttech.advn.prj.dao.entity.SwitchboardItem;

@Service
@Transactional
public class SwitchBoardService implements ISwitchBoardService {

	@Autowired
	ISwitchBoardDAO<SwitchboardItem> switchBoardDao;
	
	@Override
	public List<SwitchboardItem> getResultset() {
		return switchBoardDao.resultSet();
	}
	
	

}
