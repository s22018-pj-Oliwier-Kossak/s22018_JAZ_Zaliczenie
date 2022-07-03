package com.example.jazs22018nbp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpJaz_Service {
  final Repository repository;
  final RestTemplate restTemplate;

    public NbpJaz_Service(Repository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public NbpJaz_entity getWaluta(  String code,String waluta, String startDate, String endDate) {
        NbpJaz_entity exchange = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/rates/" + code
                +"/"+waluta+"/"+startDate+"/"+endDate+"/", NbpJaz_entity.class).getBody();
        return repository.save(exchange);

    }

    public String getZloto() {
        String exchange = restTemplate.getForEntity("https://api.nbp.pl/api/cenyzlota/", String.class).getBody();

        return exchange;

    }

}
