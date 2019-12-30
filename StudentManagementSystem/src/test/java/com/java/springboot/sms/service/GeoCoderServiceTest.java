/*
package com.java.springboot.sms.service;

import com.java.springboot.sms.entity.Site;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.UnsupportedEncodingException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GeoCoderServiceTest {

    @Autowired
    private GeoCoderService service;

    @Test
    public void getLatLngForGoogleHeadQuarters() throws UnsupportedEncodingException {
        Site site = service.getLatLong(
                "1600 Ampitheatre Parkway",
                "Mountain View",
                "CA"
        );

        System.out.println("TEST MESSAGE :: " + site);

        //Assertions.assertEquals(37.42, site.getLatitude(), 0.01);
        //Assertions.assertEquals(-122.08, site.getLongitude(), 0.01);
    }

}
*/
