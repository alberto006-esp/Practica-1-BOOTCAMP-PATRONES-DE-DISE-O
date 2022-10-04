package com.nttdata.patterdesin.patterns.proxy;

public abstract class AbstractPersonProxy implements PersonaProxyInterface {
	private PersonaProxyInterface person;

	public AbstractPersonProxy(PersonaProxyInterface person) {
		this.person = person;
	}

	@Override
	public void operacion() {
		before();
		person.operacion();
		after();
	}

	public abstract void before();

	public abstract void after();

}
