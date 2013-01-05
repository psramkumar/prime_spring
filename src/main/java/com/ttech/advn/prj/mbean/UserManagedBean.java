package com.ttech.advn.prj.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import lombok.Data;

import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.ttech.advn.prj.dao.entity.User;
import com.ttech.advn.prj.service.UserServiceIFace;

@Data
@Controller("userMB")
@RequestScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@Autowired
	UserServiceIFace userService;

	List<User> userList;

	public String addUser() {
		try {
			User user = new User();
			userService.save(user);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public void reset() {
	}

	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(userService.getResultSet());
		return userList;
	}

	private DynaFormModel model;

	private static List<SelectItem> LANGUAGES = new ArrayList<SelectItem>();


	@PostConstruct
	public void init(){
		model = new DynaFormModel();

		// add rows, labels and editable controls
		// set relationship between label and editable controls to support outputLabel with "for" attribute

		// 1. row
		DynaFormRow row = model.createRegularRow();

		DynaFormLabel label11 = row.addLabel("Author", 1, 1);
		DynaFormControl control12 = row.addControl(new BookProperty("Author", true), "input", 1, 1);
		label11.setForControl(control12);

		DynaFormLabel label13 = row.addLabel("ISBN", 1, 1);
		DynaFormControl control14 = row.addControl(new BookProperty("ISBN", true), "input", 1, 1);
		label13.setForControl(control14);

		// 2. row
		row = model.createRegularRow();

		DynaFormLabel label21 = row.addLabel("Title", 1, 1);
		DynaFormControl control22 = row.addControl(new BookProperty("Title", false), "input", 3, 1);
		label21.setForControl(control22);

		// 3. row
		row = model.createRegularRow();

		DynaFormLabel label31 = row.addLabel("Publisher", 1, 1);
		DynaFormControl control32 = row.addControl(new BookProperty("Publisher", false), "input", 1, 1);
		label31.setForControl(control32);

		DynaFormLabel label33 = row.addLabel("Published on", 1, 1);
		DynaFormControl control34 = row.addControl(new BookProperty("Published on", false), "calendar", 1, 1);
		label33.setForControl(control34);

		// 4. row
		row = model.createRegularRow();

		DynaFormLabel label41 = row.addLabel("Language", 1, 1);
		DynaFormControl control42 = row.addControl(new BookProperty("Language", false), "select", 1, 1);
		label41.setForControl(control42);

		DynaFormLabel label43 = row.addLabel("Description", 1, 2);
		DynaFormControl control44 = row.addControl(new BookProperty("Description", false), "textarea", 1, 2);
		label43.setForControl(control44);

		// 5. row
		row = model.createRegularRow();

		DynaFormLabel label51 = row.addLabel("Rating", 1, 1);
		DynaFormControl control52 = row.addControl(new BookProperty("Rating", 3, true), "rating", 1, 1);
		label51.setForControl(control52);
	}

	public List<SelectItem> getLanguages() {
		if (LANGUAGES.isEmpty()) {
			LANGUAGES.add(new SelectItem("en", "English"));
			LANGUAGES.add(new SelectItem("de", "German"));
			LANGUAGES.add(new SelectItem("ru", "Russian"));
			LANGUAGES.add(new SelectItem("tr", "Turkish"));
		}

		return LANGUAGES;
	}
	public void save() {
		addMessage("Data saved");
	}

	public void update() {
		addMessage("Data updated");
	}

	public void delete() {
		addMessage("Data deleted");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}