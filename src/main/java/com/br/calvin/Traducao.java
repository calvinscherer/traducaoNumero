package com.br.calvin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.calvin.entity.Numero;

@RestController
@RequestMapping(value="/")
public class Traducao {
	
	@RequestMapping(value="/{numero}", method=RequestMethod.GET)
	public String listar( @PathVariable Integer numero) {
		Numero numeroClasse = new Numero(numero);
		return numeroClasse.toString();
	}

}
