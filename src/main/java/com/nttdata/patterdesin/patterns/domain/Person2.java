package com.nttdata.patterdesin.patterns.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person2 {

	private String name;

	private int age;

	public Person2() {
		super();
	}
	
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
