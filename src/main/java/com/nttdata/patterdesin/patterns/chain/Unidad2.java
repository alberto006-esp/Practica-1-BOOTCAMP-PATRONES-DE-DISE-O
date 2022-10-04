package com.nttdata.patterdesin.patterns.chain;

public class Unidad2 extends Unidad {
	
	public Unidad2(String nombre) {		
		super(nombre);
	}
	
	public void ejecutaOrden(String orden) {
		if (super.mando != null) {
			System.out.println("Soy el MEGAGUAY " +  nombre + " y mando la orden " + orden + " a " + mando.nombre);	
			mando.ejecutaOrden(orden);
		} else {
			System.out.println("Soy el MEGAGUAY " +  nombre + " y soy el tonto que ejecuta la orden");
		}
	}
}