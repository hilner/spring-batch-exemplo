package br.gov.curso.batch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.dataprev.batch.exemplo.HelloWorldBean;

public class Main {
	private static ApplicationContext app;

	public static void main(String[] args) {
		app = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorldBean bean = app.getBean("helloWorldBean",
				HelloWorldBean.class);
		System.out.println(bean.print());
	}
}
