package com.greetings;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpHost;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {

    @Autowired
    private Environment env;

    public static void main(String[] args) throws UnirestException {

        /*
          If the network is not going through proxy server. You may remove this line.
          Otherwise, set your proxy details in the application.yml file.
         */
        Unirest.setProxy(new HttpHost(new Main().env.getProperty("proxy.server"), Integer.parseInt(new Main().env.getProperty("proxy.port"))));

        HttpResponse<String> response = Unirest.get("http://api.imagga.com/v1/tagging?url=http%3A%2F%2Fplayground.imagga.com%2Fstatic%2Fimg%2Fexample_photo.jpg&version=2")
                .header("accept", "application/json")
                .header("authorization", "Basic " + new Main().env.getProperty("api.token"))
                .asString();

        System.out.println(response.getBody());

    }
}