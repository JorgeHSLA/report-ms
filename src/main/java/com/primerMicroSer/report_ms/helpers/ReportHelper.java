package com.primerMicroSer.report_ms.helpers;

import com.primerMicroSer.report_ms.models.Company;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ReportHelper {

    @Value("${report.template}")
    private String reporTemplate;

    public String readTemplate(Company company) {
        return reporTemplate
                .replace("{company}", company.getName())
                .replace("{foundation_date}", company.getFoundationDate().toString())
                .replace("{founder}", company.getFounder())
                .replace("{web_sites}",company.getWebSites().toString());
    }

    public List<String> getPlaceholdersFromTemplate(String template){
        var split = template.split("\\{");
        return Arrays.stream(split)                          // Crea un stream a partir del arreglo `split` (cada parte del texto separado por '{')
                .filter(line -> !line.isEmpty())             // Filtra y elimina elementos vacíos (por ejemplo, si el string empezaba con '{')
                .map(line -> {                               // Transforma cada fragmento del stream:
                    var index = line.indexOf("}");           // Busca el índice donde aparece la primera llave de cierre '}'
                    return line.substring(0, index);         // Toma solo lo que está antes de esa llave, o sea, el contenido del placeholder
                })
                .collect(Collectors.toList());               // Recolecta todos los valores transformados en una lista

    }



}
