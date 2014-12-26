package br.gov.curso.batch.exemplo;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldBean {

	public String print(){
		return "hello";
	}
}
