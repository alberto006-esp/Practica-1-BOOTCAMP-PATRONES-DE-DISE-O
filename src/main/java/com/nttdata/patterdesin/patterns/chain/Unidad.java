package com.nttdata.patterdesin.patterns.chain;

public class Unidad {
	
	protected Unidad mando;
	
	protected String nombre;

	public Unidad(String nombre) {		
		this.nombre = nombre;
	}
	
	public void estableceMando(Unidad mando) {
		this.mando = mando;
	}
	
	public void ejecutaOrden(String orden) {
		if (mando != null) {
			System.out.println("Soy el " +  nombre + " y mando la orden " + orden + " a " + mando.nombre);	
			mando.ejecutaOrden(orden);
		} else {
			System.out.println("Soy el " +  nombre + " y soy el tonto que ejecuta la orden");
		}
	}
}