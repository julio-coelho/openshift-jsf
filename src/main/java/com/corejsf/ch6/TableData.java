package com.corejsf.ch6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TableData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3633695566658051360L;
	
	private ArrayList<Name> names = new ArrayList<Name> (Arrays.asList(
		new Name("William", "Dupont"),
		new Name("Anna", "Keeney"),
		new Name("Mariko", "Randor"),
		new Name("John", "Wilson"),
		new Name("Julio", "Coelho"),
		new Name("Carol", "Coelho"),
		new Name("Miguel", "Coelho"),
		new Name("Sara", "Coelho")
	));

	public ArrayList<Name> getNames() {
		return names; 
	}
	
	public String save() {
		for (Name name : names) {
			name.setEditable(false);
		}
		return null;
	}
	
	public String deleteRow(Name name) {
		names.remove(name);
		return null;
	}
}
