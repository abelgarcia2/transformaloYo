package com.abelgarcia2.transformaloYo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class DatosFake{
    public int age;
    public String image_url;
}


@Service
public class FotoFakeService {
    
     @Autowired
     RestTemplate restTemplate;

     public String getFotoFake(){
         String url = "https://fakeface.rest/face/json";
         DatosFake json = restTemplate.getForObject(url, DatosFake.class);
         return json.image_url;
     }
}
