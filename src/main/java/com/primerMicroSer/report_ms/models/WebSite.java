package com.primerMicroSer.report_ms.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebSite implements Serializable {


    private String name;
    //va a ser la columna llamada category
}
