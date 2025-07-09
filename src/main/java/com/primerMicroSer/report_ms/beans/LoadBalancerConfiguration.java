package com.primerMicroSer.report_ms.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


//los paquetes llamados bean se usan como una convención para organizar clases que definen beans personalizados
//La clase LoadBalancerConfiguration está destinada a configurar un bean para el balanceo de carga
//un bean es una clase que Spring instancia, configura e inyecta automáticamente cuando lo necesitas.
        @Slf4j
public class LoadBalancerConfiguration {


    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context){
        log.info("configuring load balancer");
        return ServiceInstanceListSupplier
                .builder()   // Crea un builder (patrón de diseño) para configurar cómo se construirá el ServiceInstanceListSupplier.
                .withBlockingDiscoveryClient()  //Le indica que use un DiscoveryClient bloqueante (como el que proporciona Eureka o Consul).
                                                //Es decir, obtendrá las instancias desde el servicio de descubrimiento de manera síncrona (esperando la respuesta).
                //.withSameInstancePreference() //Le da preferencia a usar la misma instancia que ya usó antes (si está disponible).
                .build(context); // Finalmente construye el objeto pasando el ConfigurableApplicationContext de Spring.



    }
}
