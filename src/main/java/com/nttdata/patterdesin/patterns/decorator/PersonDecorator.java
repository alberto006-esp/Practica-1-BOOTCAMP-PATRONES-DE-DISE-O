package com.nttdata.patterdesin.patterns.decorator;

public class PersonDecorator implements PersonInterface {
	
	private PersonInterface delegate;
	
	public PersonDecorator(PersonInterface delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return "Sr. " + delegate.getName() + ".";
	}

	@Override
	public void setName(String name) {
		this.delegate.setName(name);
	}

	@Override
	public int getAge() {
		return delegate.getAge() * 365;
	}

	@Override
	public void setAge(int age) {
		this.delegate.setAge(age);
	}

}
