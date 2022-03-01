package ru.hemulen.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SMEVAdapterConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ru.hemulen.adapterwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public SMEVAdapterClient smevAdapterClient(Jaxb2Marshaller marshaller) {
        SMEVAdapterClient client = new SMEVAdapterClient();
        client.setDefaultUri("http://localhost:7575/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
