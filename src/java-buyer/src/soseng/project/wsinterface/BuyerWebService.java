package soseng.project.wsinterface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2017-08-25T18:09:51.581+02:00
 * Generated source version: 3.1.6
 * 
 */
@WebService(targetNamespace = "http://acme.loopingdoge.org/", name = "BuyerWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface BuyerWebService {

    @WebMethod
    @RequestWrapper(localName = "houseProposalReply", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.HouseProposalReply")
    @ResponseWrapper(localName = "houseProposalReplyResponse", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.HouseProposalReplyResponse")
    @WebResult(name = "return", targetNamespace = "")
    public soseng.project.wsinterface.HouseRequestReplyMessage houseProposalReply(
        @WebParam(name = "replyAction", targetNamespace = "")
        java.lang.String replyAction,
        @WebParam(name = "selectedHouseIndex", targetNamespace = "")
        int selectedHouseIndex
    );

    @WebMethod
    @RequestWrapper(localName = "requestHouses", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.RequestHouses")
    @ResponseWrapper(localName = "requestHousesResponse", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.RequestHousesResponse")
    @WebResult(name = "return", targetNamespace = "")
    public soseng.project.wsinterface.HouseRequestReplyMessage requestHouses(
        @WebParam(name = "houseProfile", targetNamespace = "")
        soseng.project.wsinterface.HouseProfile houseProfile,
        @WebParam(name = "buyerName", targetNamespace = "")
        java.lang.String buyerName
    );
}