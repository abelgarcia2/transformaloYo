package com.abelgarcia2.transformaloYo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class Picture{
    public String large;
    public String medium;
}

class Results{
    public String gender;
    public String email;
    public String phone;
    public Picture picture;
}

class Datos{
    public ArrayList<Results> results = new ArrayList<Results>();
}

@Service
public class FotoService {
    
    @Autowired
    RestTemplate restTemplate;

    public String getFoto(){
        String url = "https://randomuser.me/api/";
        Datos json = restTemplate.getForObject(url, Datos.class);
        return json.results.get(0).picture.large;
    }
}
