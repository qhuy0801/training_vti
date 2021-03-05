package com.training.backend.staticexercsise;

import java.util.ArrayList;

import com.training.entity.staticexercise.geometry.Geometry;
import com.training.entity.staticexercise.geometry.Rectangle;
import com.training.entity.staticexercise.geometry.Round;

public class GeometryProgram {
	ArrayList<Geometry> geometries = new ArrayList<>();
	
public void sampleData() {
	geometries.add(new Round(2));
	geometries.add(new Round(3));
	geometries.add(new Round(3.3f));
	geometries.add(new Rectangle(3,2));
	geometries.add(new Rectangle(4.5f, 5.3f));
	geometries.add(new Rectangle(4.2f, 5.5f));
}
}
