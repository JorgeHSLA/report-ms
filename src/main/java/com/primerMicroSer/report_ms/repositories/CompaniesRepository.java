package com.primerMicroSer.report_ms.repositories;


import com.primerMicroSer.report_ms.beans.LoadBalancerConfiguration;
import com.primerMicroSer.report_ms.models.Company;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

//PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP

//Imperativo	Escribes tú mismo to: abrir conexión, parsear, manejar errores, etc.	  ->  RestTemplate, HttpClient, OkHttp
//Declarativo	Solo defines una interfaz con anotaciones y el cliente lo hace  por ti	  ->  FeignClient, Retrofit, etc.

//PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP

//declarativo

//@FeignClient(name = "servicio-productos")
//public interface ProductoClient {
//
//    @GetMapping("/productos/{id}")
//    Producto obtenerProducto(@PathVariable("id") Long id);
//}

//LllllllllLLlllLlLllllLLLŁLllllllllLLlllLlLllllLLLŁLllllllllLLlllLlLllllLLLŁLllllllllLLlllLlLllllLLLŁLllllllllLLlllLlLllllLLLŁ

//❌ Imperativo
//java
//        Copiar
//Editar
//RestTemplate restTemplate = new RestTemplate();
//String url = "http://servicio-productos/productos/" + id;
//ResponseEntity<Producto> response = restTemplate.getForEntity(url, Producto.class);
//Producto producto = response.getBody();


@FeignClient(name = "companies-crud") //anotación de Spring Cloud que te permite crear un cliente HTTP declarativo en Java para comunicarte con otros microservicios.
@LoadBalancerClient(name = "companies-crud", configuration = LoadBalancerConfiguration.class) //Le indica a Spring que cuando vaya a balancear peticiones hacia "companies-crud", use la configuración personalizada definida en LoadBalancerConfiguration.
public interface CompaniesRepository {


    @GetMapping(path = "/companies-crud/company/{name}") //ira a esta ruta para obtener datos
    Optional<Company> getbyName(@PathVariable String name);

}




