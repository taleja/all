package com.paazl.rest;

import com.paazl.gui.GuiInterface;
import com.paazl.gui.OrderRequestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShepherdClient {

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
                guiInterface.addServerFeedback("Number of sheep to order: " + i);
            }
        });
    }

    public String getServerStatus() {
        return "Server status...";
    }
}
