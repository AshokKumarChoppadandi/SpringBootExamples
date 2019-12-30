/*
package com.java.springboot.sms.service;

import com.java.springboot.sms.entity.Response;
import com.java.springboot.sms.entity.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GeoCoderService {
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String KEY = "AIzaSyB-2FITsqlO5-RHkVm5QVO010rYbBtXGic";

    private RestTemplate restTemplate;

    @Autowired
    public GeoCoderService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Site getLatLong(String... address) throws UnsupportedEncodingException {
        String joinedAddress = String.join("," , address);
        String encodedAddress = "";

        encodedAddress = URLEncoder.encode(joinedAddress, String.valueOf(StandardCharsets.UTF_8));

        System.out.println("ENCODED ADDRESS :: " + encodedAddress);
        String fullAddress = String.format("%s?address=%s&key=%s", BASE_URL, encodedAddress, KEY);
        System.out.println("FULL ADDRESS :: " + fullAddress);

        Response response = restTemplate.getForObject(
                fullAddress,
                Response.class
        );

        return new Site(
                response.getFormattedAddress(),
                response.getLocation().getLatitude(),
                response.getLocation().getLongitude()
        );
    }
}
*/
