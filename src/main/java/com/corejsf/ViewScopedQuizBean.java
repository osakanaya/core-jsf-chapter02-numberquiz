package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ViewScopedQuizBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<ProblemBean> problems = new ArrayList<ProblemBean>();
	private int currentIndex;
	private int score;

	public ViewScopedQuizBean() {
		problems.add(new ProblemBean(new int[] { 3, 1, 4, 1, 5 }, 9)); // pi
		problems.add(new ProblemBean(new int[] { 1, 1, 2, 3, 5 }, 8)); // fibonacci
		problems.add(new ProblemBean(new int[] { 1, 4, 9, 16, 25 }, 36)); // squares
		problems.add(new ProblemBean(new int[] { 2, 3, 5, 7, 11 }, 13)); // primes
		problems.add(new ProblemBean(new int[] { 1, 2, 4, 8, 16 }, 32)); // powers of 2
	}
	
	public void setProblems(ArrayList<ProblemBean> problems) {
		this.problems = problems;
		currentIndex = 0;
		score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getAnswer() {
		return "";
	}
	
	public ProblemBean getCurrent() {
		return problems.get(currentIndex);
	}
	
	public void setAnswer(String answer) {
		try {
			int value = Integer.parseInt(answer.trim());
			if (getCurrent().getSolution() == value) {
				score++;
				currentIndex = (currentIndex + 1) % problems.size();
			}
		} catch (NumberFormatException e) {
		}
	}
}
