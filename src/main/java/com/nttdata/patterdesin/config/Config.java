package com.nttdata.patterdesin.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nttdata.patterdesin.patterns.decorator.PersonInterface;
import com.nttdata.patterdesin.patterns.domain.Person;

@Configuration
public class Config {

	@Bean("personPrototype")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PersonInterface prototypePerson() {
		//return Person.Builder().age(17).name("Pepito").build();
		return new Person();
	}

	@Bean("personSingleton")
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PersonInterface singletonPerson() {
		return new Person();
	}

}
