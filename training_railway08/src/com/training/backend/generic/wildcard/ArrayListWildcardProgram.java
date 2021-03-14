package com.training.backend.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

public class ArrayListWildcardProgram {
List<Object> listWildcard;

public <E> ArrayListWildcardProgram() {
	listWildcard = new ArrayList<Object>();
}

public void sampleData() {
	listWildcard.add("Name");
	listWildcard.add(123);
	listWildcard.add("Address");
}

public void printData() {
	for (Object object : listWildcard) {
		System.out.println(object);
	}
}
}
