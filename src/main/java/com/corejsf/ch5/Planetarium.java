package com.corejsf.ch5;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Planetarium implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4267748890262734450L;
	private String selectedPlanet;

	public String getSelectedPlanet() {
		return this.selectedPlanet;
	}
	
	public String changePlanet(String newValue) {
		
		this.selectedPlanet = newValue;
		return this.selectedPlanet;
	}
}
