package com.corejsf.ch3;

import java.io.Serializable;

public class Problem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3533963147338889324L;
	private String question;
	private String answer;
	
	public Problem(String question, String answer) {
		
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
	
	public boolean isCorrect(String response) {
		
		return response.trim().equalsIgnoreCase(answer);
	}

}
