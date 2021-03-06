package com.paazl.rest;

import com.paazl.service.OrderNewSheepDto;
import com.paazl.service.ShepherdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.math.BigInteger;

@Path("/shepherdmanager")
@Service
public class ShepherdResource {

    @Autowired
    ShepherdService service;

    @GET
    @Path("/balance")
    public BigInteger getBalance() {
        return service.getBalance();
    }
    
    @POST
    @Path("/balance")
    public String orderNewSheep(OrderNewSheepDto orderNewSheepDto) {
    	return service.orderNewSheep(orderNewSheepDto.getNofSheepDesired());
    }

}
