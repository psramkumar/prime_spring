package com.ttech.advn.prj.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ttec.advn.prj.support.AbstractSupportController;
import com.ttech.advn.prj.dao.entity.Role;
import com.ttech.advn.prj.service.ISwitchBoardService;

@Controller
public class SwitchBoardController extends AbstractSupportController<Role> {

	@Autowired
	ISwitchBoardService switchBoardService;

	public List<Role> getResultSet() {
		return switchBoardService.getResultSet();
	}
	
	public String addSwitchBoard(){
		switchBoardService.save(getInstance());
		return "switchboard";
	}
	public String reset(){
		newInstance();
		return "success";
	}

	

	

}
