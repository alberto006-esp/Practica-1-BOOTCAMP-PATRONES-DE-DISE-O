package com.nttdata.patterdesin.patterns.domain;

import com.nttdata.patterdesin.patterns.singleton.PersonSingleton;

public class Bussines {
	
	public void ejecuta() {
		System.out.println("Estoy en Bussiness: " + PersonSingleton.INSTANCE.getName() +  " - " +  PersonSingleton.INSTANCE);
	}

}
