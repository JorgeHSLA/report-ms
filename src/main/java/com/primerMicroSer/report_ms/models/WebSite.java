package com.primerMicroSer.report_ms.models;



import lombok.Data;

import java.io.Serializable;



@Data
public class WebSite implements Serializable {


    private Long id;
    private String name;
    //va a ser la columna llamada category

    private Category category;
    private String description;
}
//Controla cómo JPA (Java Persistence API) mapea un enum Java a la base de datos.
//ejemplo:
//    Valor Java	        Almacenado en DB como
//    Category.TECHNOLOGY	"TECHNOLOGY"
//    Category.HEALTHCARE	"HEALTHCARE"
//    Category.EDUCATION	"EDUCATION"
