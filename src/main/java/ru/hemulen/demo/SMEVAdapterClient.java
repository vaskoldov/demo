package ru.hemulen.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.hemulen.adapterwebservice.wsdl.*;

public class SMEVAdapterClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(SMEVAdapterClient.class);

    public QueryResultList Find(FindMessageQuery query) {
        log.info("Requesting find for " + query.getSpecificQuery().getMessageClientIdCriteria().getClientId());
        QueryResultList result = (QueryResultList) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7575/ws/SMEVServiceAdapterService?wsdl",
                query, new SoapActionCallback("ru.hemulen.adapterwebservice.wsdl"));
        return result;
    }
}
