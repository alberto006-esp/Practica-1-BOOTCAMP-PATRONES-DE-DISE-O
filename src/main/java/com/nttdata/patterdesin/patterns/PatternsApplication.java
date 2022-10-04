package com.nttdata.patterdesin.patterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nttdata.patterdesin.patterns.chain.Unidad;
import com.nttdata.patterdesin.patterns.chain.Unidad2;
import com.nttdata.patterdesin.patterns.chain.UnidadDeMando;
import com.nttdata.patterdesin.patterns.decorator.PersonDecorator;
import com.nttdata.patterdesin.patterns.decorator.PersonInterface;
import com.nttdata.patterdesin.patterns.domain.Bussines;
import com.nttdata.patterdesin.patterns.domain.Person;
import com.nttdata.patterdesin.patterns.proxy.AbstractPersonProxy;
import com.nttdata.patterdesin.patterns.proxy.PersonProxyBBDD;
import com.nttdata.patterdesin.patterns.proxy.PersonProxyCOLAS;
import com.nttdata.patterdesin.patterns.singleton.PersonSingleton;
import com.nttdata.patterdesin.patterns.singleton.PersonSingletonEnum;

@SpringBootApplication
@ComponentScan(value = "com.nttdata")
public class PatternsApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	private PersonInterface personPrototype;

	public PatternsApplication(PersonInterface personPrototype) {
		this.personPrototype = personPrototype;
	}

	public static void main(String[] args) {
		SpringApplication.run(PatternsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicio...");

		System.out.println("=============================================================================");
		System.out.println("Prácticas con Singleton");
		System.out.println("=============================================================================");
		PersonSingletonEnum.INSTANCE.person().setName("Joselito");

		System.out.println(PersonSingletonEnum.INSTANCE.person().getName());

		PersonSingleton.INSTANCE.setName("Alberto");

		System.out.println(
				"ID del objeto singleton: " + PersonSingleton.INSTANCE.getName() + " - " + PersonSingleton.INSTANCE);

		Bussines bussines = new Bussines();
		bussines.ejecuta();

		System.out.println("=============================================================================");
		System.out.println("Prácticas con Prototype");
		System.out.println("=============================================================================");

		Person person = new Person("Alberto", 30);
		Person personClon = person.Clone();

		System.out.println("ID del objeto persona: " + person.getName() + " Edad: " + person.getAge() + "- " + person);
		System.out.println("ID del objeto clon de persona: " + personClon.getName() + " Edad: " + personClon.getAge()
				+ " - " + personClon);

		System.out.println("=============================================================================");
		System.out.println("Prácticas con Builder");
		System.out.println("=============================================================================");

		Person person2 = Person.Builder().name("Alberto").age(10000).build();

		System.out
				.println("ID del objeto persona: " + person2.getName() + " Edad: " + person2.getAge() + "- " + person2);

		System.out.println("=============================================================================");
		System.out.println("Prácticas con Singleton/prototype/builder Spring/Lombok");
		System.out.println("=============================================================================");

		System.out.println("ID Objecto Singleton ->" + personPrototype.getName());
		System.out.println("ID Objecto Prototype ->" + ((Person) context.getBean("personPrototype")).getName());

		System.out.println("ID Objecto Singleton " + ((Person) context.getBean("personSingleton")).getName());
		System.out.println("ID Objecto Singleton " + context.getBean("personSingleton"));

		System.out.println("ID Objecto Prototype " + context.getBean("personPrototype"));
		System.out.println("ID Objecto Prototype " + context.getBean("personPrototype"));

		PersonInterface person3 = Person.Builder().age(32).name("Alberto Suarez Olvera").build();
		PersonInterface person4 = new PersonDecorator(person3);

		System.out.println("Nombre Prototype " + person3.getName());
		System.out.println("Nombre Prototype Decorated " + person4.getName());

		System.out.println("Prototype Edad en Meses" + person3.getAge());
		System.out.println("Prototype Decorated Edad en Días " + person4.getAge());

		System.out.println("=============================================================================");
		System.out.println("Prácticas con Proxy");
		System.out.println("=============================================================================");

		Person entidad = Person.Builder().age(25).name("Enrique Rojas").build();
		Person entidad2 = Person.Builder().age(27).name("Marcos Olvera").build();

		AbstractPersonProxy proxyBbdd = new PersonProxyBBDD(entidad);
		AbstractPersonProxy proxyColas = new PersonProxyCOLAS(entidad2);

		proxyBbdd.operacion();
		proxyColas.operacion();

		System.out.println("=============================================================================");
		System.out.println("Prácticas con Proxy");
		System.out.println("=============================================================================");

		UnidadDeMando unidadMando = new UnidadDeMando();

		unidadMando.anadirEjercito(new Unidad("Capitan"));
		unidadMando.anadirEjercito(new Unidad2("Sargento"));
		unidadMando.anadirEjercito(new Unidad("Soldado"));

		unidadMando.ejecutaOrden("Matar al terrorista");

		System.out.println("Fin...");
	}
}
