package com.paazl.scheduling;

import com.paazl.gui.GuiInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ServerStatusTask {

    /*
        The task will update the gui per instructed by the CRON job set in the properties file. But now it only prints
        a hard coded string.
        Change the code so this task prints the server status obtained from the server instead of the hard coded
        string.
     */

    private GuiInterface guiInterface;

    @Autowired
    public ServerStatusTask(
            GuiInterface guiInterface) {

        this.guiInterface = guiInterface;
    }

    @Scheduled(cron="${scheduling.server_status.cron}")
    public void getServerStatus() {
        guiInterface.addServerFeedback("Server status... " + new Date().toString());
    }

}
