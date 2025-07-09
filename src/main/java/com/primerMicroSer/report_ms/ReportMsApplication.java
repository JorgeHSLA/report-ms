package com.primerMicroSer.report_ms;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ReportMsApplication {

//
//	@Autowired
//	private EurekaClient eurekaClient; // un bean que ya viene por defecto que ayuda al balanceo, el cliente que Spring usa para comunicarse con el servidor Eureka.

	public static void main(String[] args) {
		SpringApplication.run(ReportMsApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		this.eurekaClient
//				.getAllKnownRegions() // literalmente esta hablando de ciertas regiones geograficas,
//				.forEach(System.out::println); //Imprime cada región conocida por consola.
//		System.out.println(this.eurekaClient.getApplication("companies-crud"));
//
//	} sirve para cierta infomracion de las instancias, gracias a eureka

}
