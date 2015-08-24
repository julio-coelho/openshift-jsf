package com.corejsf.ch2;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("numberQuizBean")
@ConversationScoped
public class QuizBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5679104680036250778L;

	@Inject
	private Conversation conversation;

	private ArrayList<ProblemBean> problems = new ArrayList<ProblemBean>();
	private int currentIndex;
	private int score;

	public QuizBean() {

		// pi
		problems.add(new ProblemBean(new int[] { 3, 1, 4, 1, 5 }, 9));

		// fibonacci
		problems.add(new ProblemBean(new int[] { 1, 1, 2, 3, 5 }, 8));

		// squares
		problems.add(new ProblemBean(new int[] { 1, 4, 9, 16, 25 }, 36));

		// primes
		problems.add(new ProblemBean(new int[] { 2, 3, 5, 7, 11 }, 13));

		// power of 2
		problems.add(new ProblemBean(new int[] { 1, 2, 4, 8, 16 }, 32));
	}

	public int getScore() {

		return score;
	}

	public ProblemBean getCurrent() {

		return problems.get(currentIndex);
	}

	public String getAnswer() {

		return "";
	}

	public void setAnswer(String newValue) {

		try {

			if (currentIndex == 0) {
				conversation.begin();
			}

			int answer = Integer.parseInt(newValue);
			if (getCurrent().getSolution() == answer) {
				score++;
			}
			currentIndex = (currentIndex + 1) % problems.size();

			if (currentIndex == 0) {
				conversation.end();
			}

		} catch (NumberFormatException e) {

		}
	}
}
