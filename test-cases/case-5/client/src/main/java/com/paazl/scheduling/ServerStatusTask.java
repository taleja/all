package com.paazl.scheduling;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.paazl.gui.GuiInterface;
import com.paazl.rest.ShepherdClient;

@Component
public class ServerStatusTask {

    /*
        The task will update the gui per instructed by the CRON job set in the properties file. But now it only prints
        a hard coded string.
        Change the code so this task prints the server status obtained from the server instead of the hard coded
        string.
     */

    private GuiInterface guiInterface;
    private ShepherdClient shepherdClient;

    @Autowired
    public ServerStatusTask(
            GuiInterface guiInterface, ShepherdClient shepherdClient) {

        this.guiInterface = guiInterface;
        this.shepherdClient = shepherdClient;
    }

    @Scheduled(cron="${scheduling.server_status.cron}")
    public void getServerStatus() {		
        guiInterface.addServerFeedback(shepherdClient.getServerStatus());
    }

}
