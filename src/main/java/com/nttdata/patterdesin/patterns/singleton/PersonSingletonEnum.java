package com.nttdata.patterdesin.patterns.singleton;

import com.nttdata.patterdesin.patterns.domain.Person;

public enum PersonSingletonEnum {
	INSTANCE;
	
	Person person;
	
	PersonSingletonEnum() {
		this.person = new Person();
	}
	
	public Person person() {
		return person;
	}
}
