package com.ttech.advn.prj.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ttech.advn.prj.dao.entity.SwitchboardItem;
import com.ttech.advn.prj.service.ISwitchBoardService;

@Controller
public class SwitchBoardController {

	@Autowired
	ISwitchBoardService switchBoardService;
	
	public List<SwitchboardItem> getResultSet(){
		return switchBoardService.getResultset();
	}
	
}
