package com.ttech.advn.prj.dao;

import org.springframework.stereotype.Repository;

import com.ttec.advn.prj.support.AbstractSupportDAO;
import com.ttech.advn.prj.dao.entity.SwitchboardItem;

@Repository
public class SwitchBoardDAO extends AbstractSupportDAO<SwitchboardItem> implements SwitchBoardDAOIFace<SwitchboardItem>{

	public SwitchBoardDAO(){
		super(SwitchboardItem.class);
	}
}
