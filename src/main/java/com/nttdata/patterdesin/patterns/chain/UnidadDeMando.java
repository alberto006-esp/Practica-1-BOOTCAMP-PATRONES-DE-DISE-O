package com.nttdata.patterdesin.patterns.chain;

import java.util.ArrayList;
import java.util.List;

public class UnidadDeMando {
	
	private List<Unidad> ejercito;
	
	public UnidadDeMando() {
		this.ejercito = new ArrayList<>();
	}
	
	public void anadirEjercito(Unidad unidad) {
		if (this.ejercito.size() > 0) {
			this.ejercito.get(this.ejercito.size() - 1).estableceMando(unidad);			
		}
		
		this.ejercito.add(unidad);
	}
	
	public void ejecutaOrden(String orden) {
		this.ejercito.get(0).ejecutaOrden(orden);
		
	}
	
	
	
	

}
