package com.example.jazs22018nbp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nbp")
public class NbpJaz_RestController {
    final NbpJaz_Service nbpJaz_service;

    public NbpJaz_RestController(NbpJaz_Service nbpJaz_service) {
        this.nbpJaz_service = nbpJaz_service;
    }

    @GetMapping("/waluta/{code}/{waluta}/{startDate}/{endDate}")
    public NbpJaz_entity all(@PathVariable String code, @PathVariable String waluta,@PathVariable  String startDate,@PathVariable String endDate){
        return nbpJaz_service.getWaluta(code,waluta,startDate,endDate);
    }
    @GetMapping("/zloto")
    public String all2(){
        return nbpJaz_service.getZloto();
    }

}
