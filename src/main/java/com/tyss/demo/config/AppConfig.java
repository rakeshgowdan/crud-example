package com.tyss.demo.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.tyss.demo")
@EnableWebMvc
public class AppConfig {

	/*
	 To get EntityManager directly, create a bean for JpaTransactionManager and wire the
	LocalEntityManagerFactoryBean in to it with the property entityManagerFactory and
	create a reference for EntityManager in DAO and annotate that with @PersistenceContaxt
	 */
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		//LocalContainerEntityManagerFactoryBean produces a container-managed EntityManagerFactory. 
		LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
		factory.setPersistenceUnitName("userDB");
		return factory;
	}

	@Bean
	public JpaTransactionManager getTransactionManagerBean() {
		//Binds a JPA EntityManager from the specified factory to the thread, potentially 
		//allowing for one thread-bound EntityManager per factory 
		JpaTransactionManager trans = new JpaTransactionManager();
		trans.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		return trans;
	}
}
/*
Spring @Configuration annotation helps in Spring annotation based configuration. 
@Configuration annotation indicates that a class declares one or more @Bean methods 
and may be processed by the Spring container to generate bean definitions and service 
requests for those beans at runtime.
------------------------------------------------------------------------------------
The @EnableWebMvc annotation is used for enabling Spring MVC in an application and 
works by importing the Spring MVC Configuration from WebMvcConfigurationSupport. 
The XML equivalent with similar functionality is <mvc:annotation-driven/>
------------------------------------------------------------------------------------

*/