package com.paazl.rest;

import com.paazl.gui.GuiInterface;
import com.paazl.gui.OrderRequestListener;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShepherdClient {

    private static final String BALANCE_URL = "http://localhost:8080/rest/shepherdmanager/balance";

	/*
        Use a Rest client to obtain the server status, so this client can be used to obtain that status.
     */

    private final Logger log = LoggerFactory.getLogger(getClass());

    private GuiInterface guiInterface;

    @Autowired
    public ShepherdClient(GuiInterface guiInterface) {
        this.guiInterface = guiInterface;

        guiInterface.addOrderRequestListener(new OrderRequestListener() {
            @Override
            public void orderRequest(int i) {
            	updateBalance(i);
                guiInterface.addServerFeedback("Number of sheep to order: " + i);
            }
        });
    }

    public String getServerStatus() {
    	HttpHeaders headers = createHeader();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<BigInteger> responseEntity = restTemplate.exchange(BALANCE_URL,  HttpMethod.GET, requestEntity, BigInteger.class, 1);
    	
        return "Server status..." + responseEntity.getBody();
    }

    public void updateBalance(int i) {
    	OrderNewSheepDto orderNewSheepDto = new OrderNewSheepDto();
    	orderNewSheepDto.setNofSheepDesired(i);          	        		
    	HttpEntity<OrderNewSheepDto> requestEntity = buildRequestEntity(orderNewSheepDto);    	
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<String> responseEntity = restTemplate.exchange(BALANCE_URL, HttpMethod.POST, requestEntity, String.class, 1);
    }
    
	private HttpHeaders createHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
     
    private HttpEntity<OrderNewSheepDto> buildRequestEntity(OrderNewSheepDto orderNewSheepDto) {
		HttpHeaders headers = createHeader();
		HttpEntity<OrderNewSheepDto> requestEntity = new HttpEntity<OrderNewSheepDto>(orderNewSheepDto, headers);
		return requestEntity;
	}
   
}
