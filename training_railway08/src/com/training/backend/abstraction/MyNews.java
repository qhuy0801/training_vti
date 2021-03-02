package com.training.backend.abstraction;

import java.util.ArrayList;
import java.util.Scanner;

import com.training.entity.abstraction.News;

public class MyNews {
	Scanner in = new Scanner(System.in);
	//	Initialize objects
	private ArrayList<News> data = new ArrayList<>();
	
//==========================================================================================		
	public void InsertNews() {
		// Create a blank new (entity)
		News new1 = new News();

		// Gather data
		System.out.println("Enter the title here: ");
		String Title = in.nextLine();
		new1.setTitle(Title);
		
		System.out.println("Enter the publish date here: ");
		String PublishDate = in.nextLine();
		new1.setPublishDate(PublishDate);
		
		System.out.println("Enter the author here: ");
		String Author = in.nextLine();
		new1.setAuthor(Author);
		
		System.out.println("Enter the content here: ");
		String Content = in.nextLine();
		new1.setContent(Content);
		
		new1.Calculate();

		data.add(new1);
	}
	
//==========================================================================================	
	public void ViewListNews() {
		for (News news : data) {
			news.Display();
		}
	}
	
//==========================================================================================
	
}
