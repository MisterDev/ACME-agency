
package soseng.project.wsinterface;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SellerWebService", targetNamespace = "http://acme.loopingdoge.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SellerWebService {


    /**
     * 
     * @param processId
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBuyerMeetingDateList", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.GetBuyerMeetingDateList")
    @ResponseWrapper(localName = "getBuyerMeetingDateListResponse", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.GetBuyerMeetingDateListResponse")
    public List<String> getBuyerMeetingDateList(
        @WebParam(name = "processId", targetNamespace = "")
        String processId);

    /**
     * 
     * @param house
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "proposeHouse", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.ProposeHouse")
    @ResponseWrapper(localName = "proposeHouseResponse", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.ProposeHouseResponse")
    public String proposeHouse(
        @WebParam(name = "house", targetNamespace = "")
        House house);

    /**
     * 
     * @param processId
     * @param accept
     * @param accepedDate
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "confirmMeeting", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.ConfirmMeeting")
    @ResponseWrapper(localName = "confirmMeetingResponse", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.ConfirmMeetingResponse")
    public String confirmMeeting(
        @WebParam(name = "processId", targetNamespace = "")
        String processId,
        @WebParam(name = "accept", targetNamespace = "")
        boolean accept,
        @WebParam(name = "accepedDate", targetNamespace = "")
        String accepedDate);

    /**
     * 
     * @param processId
     * @param dateList
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendAvailability", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.SendAvailability")
    @ResponseWrapper(localName = "sendAvailabilityResponse", targetNamespace = "http://acme.loopingdoge.org/", className = "soseng.project.wsinterface.SendAvailabilityResponse")
    public String sendAvailability(
        @WebParam(name = "processId", targetNamespace = "")
        String processId,
        @WebParam(name = "dateList", targetNamespace = "")
        List<String> dateList);

}
