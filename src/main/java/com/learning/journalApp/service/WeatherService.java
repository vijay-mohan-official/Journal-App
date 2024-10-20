package com.learning.journalApp.service;

import com.learning.journalApp.api.response.WeatherResponse;
import com.learning.journalApp.cache.AppCache;
import com.learning.journalApp.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if(weatherResponse != null){
            return weatherResponse;
        }
        else{
            String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(PlaceHolders.city,city).replace(PlaceHolders.apiKey,apiKey);
            //JSON returned by the API will be deserialized and will be converted to WeatherResponse object
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body != null){
                redisService.set("weather_of_" + city, body,300l);
            }
            return body;
        }
    }

}
