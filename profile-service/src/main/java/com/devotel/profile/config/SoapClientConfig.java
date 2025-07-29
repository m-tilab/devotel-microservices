package com.devotel.profile.config;

import com.devotel.profile.soap.client.UserSoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.devotel.profile.soap.stub");
        return marshaller;
    }

    @Bean
    public UserSoapClient userSoapClient(Jaxb2Marshaller marshaller) {
        UserSoapClient client = new UserSoapClient();
        client.setDefaultUri("http://localhost:8081/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
