package com.myProject.Project1.service;

import com.myProject.Project1.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    private static final String apiKey = "6e9f9a5c6281ea0e3fb188188dcac31a";

    private String url="http://api.weatherstack.com/current?access_key=YOUR_ACCESS_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalAPI = url.replace("CITY",city).replace("YOUR_ACCESS_KEY",apiKey);
        ResponseEntity<WeatherResponse> res = restTemplate.exchange(finalAPI, HttpMethod.GET,null, WeatherResponse.class);
        WeatherResponse body = res.getBody();
        return body;
    }
}
