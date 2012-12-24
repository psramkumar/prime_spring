package com.ttech.advn.prj.mbean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookProperty {

	private String name;
	private Object value;
	private boolean required;

	public BookProperty(String name, boolean required) {
		this.name = name;
		this.required = required;
	}

}
