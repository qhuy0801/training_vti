package com.training.entity.abstraction;

import java.util.Scanner;

public class News implements INews {
	private int ID;
	private String Title;
	private String PublishDate;
	private String Author;
	private String Content;
	float AverageRate;

//==========================================================================================
//	Create getters and setters
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public float getAverageRate() {
		return AverageRate;
	}

//==========================================================================================
//	Unimplemented methods
	@Override
	public void Display() {
		System.out.println("News [Title=" + Title + ", PublishDate=" + PublishDate + ", Author=" + Author + ", Content="
				+ Content + ", AverageRate=" + AverageRate + "]");
	}

	@Override
	public float Calculate() {
		Scanner in = new Scanner(System.in);
		int[] rates = new int[3];
		System.out.println("Please enter 3 rates: ");
		rates[0] = in.nextInt();
		rates[1] = in.nextInt();
		rates[2] = in.nextInt();
		int sum = rates[0] + rates[1] + rates[2];
		float avg = ((float) sum/3);
		this.AverageRate = avg;
		return avg;
	}
}
