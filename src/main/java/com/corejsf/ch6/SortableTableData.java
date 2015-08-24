package com.corejsf.ch6;

import java.io.Serializable;
import java.util.Comparator;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.inject.Named;

@Named
@SessionScoped
public class SortableTableData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5188817195807117633L;
	
	private SortFilterModel<Name> filterModel;
	private static final Name[] names = {
		new Name("William", "Dupont"),
		new Name("Anna", "Keeney"),
		new Name("Mariko", "Randor"),
		new Name("John", "Wilson"),
		new Name("Julio", "Coelho"),
		new Name("Carol", "Coelho"),
		new Name("Miguel", "Coelho"),
		new Name("Sara", "Coelho")	
	};

	public SortableTableData() {
		filterModel = new SortFilterModel<Name>(new ArrayDataModel<Name>(names));
	}
	
	public DataModel<Name> getNames() {
		return filterModel;
	}
	
	public String sortByFirst() {
		filterModel.sortBy(new Comparator<Name>() {

			@Override
			public int compare(Name o1, Name o2) {
				
				return o1.getFirst().compareTo(o2.getFirst());
			}
		});
		return null;
	}
	
	public String sortByLast() {
		filterModel.sortBy(new Comparator<Name>(){

			@Override
			public int compare(Name o1, Name o2) {
				
				return o1.getLast().compareTo(o2.getLast());
			}
			
		});
		return null;
	}
}
