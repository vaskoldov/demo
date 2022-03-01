package ru.hemulen.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.hemulen.adapterwebservice.wsdl.*;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SMEVAdapterClient client) {
        FindMessageQuery query = new FindMessageQuery();
        FindTypeCriteria specificQuery = new FindTypeCriteria();
        MessageClientIdCriteria criteria = new MessageClientIdCriteria();
        criteria.setClientId("67b0ccd2-ea2d-4f40-97a7-7ed80c98aee1");
        specificQuery.setMessageClientIdCriteria(criteria);
        query.setItSystem("FSOR01_3T");
        query.setSpecificQuery(specificQuery);
        return args -> {
            QueryResultList resultList = client.Find(query);
            List<AdapterMessage> responses = resultList.getQueryResult();
            for (AdapterMessage response:responses)
            {
                System.err.println(response.getMessage().getMessageType());
                System.err.println(response.getSmevMetadata().getMessageId());
            }
        };
    }
}
