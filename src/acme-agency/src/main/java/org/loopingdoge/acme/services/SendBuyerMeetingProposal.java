package org.loopingdoge.acme.services;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.http.HTTPTransportFactory;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServer;
import org.loopingdoge.acme.jolie.sessionmanager.ACMESessionServerService;
import org.loopingdoge.acme.model.House;
import org.loopingdoge.acme.utils.MailServiceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;

public class SendBuyerMeetingProposal implements JavaDelegate {

    private final static Logger logger = Logger.getLogger("SendBuyerMeetingProposal");

    private final String BASE_URL = "http://localhost:7774/";

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MailServiceAPI mailService = retrofit.create(MailServiceAPI.class);
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("service started");
        // TODO implement this
        // settare la variabile di processo String buyerMeetingReply = "retry" || "accept"
    
        // Remove seller session info
        final Bus defaultBus = BusFactory.getDefaultBus();
        final ConduitInitiatorManager extension = defaultBus.getExtension(ConduitInitiatorManager.class);
        extension.registerConduitInitiator("http://schemas.xmlsoap.org/soap/http/", new HTTPTransportFactory());
        
        ACMESessionServer sessionWs = new ACMESessionServerService().getACMESessionServerServicePort();
        sessionWs.removeSession(execution.getProcessInstanceId());
        
        House acceptedHouse = (House) execution.getVariable("acceptedHouse");
        
        // Send mail notification to buyer
        mailService.send(
        		(String) execution.getVariable("buyerName"), 
        		"AcmeAgency", 
        		"Il proprietario di " + acceptedHouse.getName() + "ha specificato date di disponibilita'")
        		.execute().body();
        
        // Add buyer session
        sessionWs.addSession(
        		(String) execution.getVariable("buyerName"), 
        		execution.getProcessInstanceId(), 
        		"WaitForMeetingResponse");
    }

}
