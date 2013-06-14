/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author BJORN
 */
@WebService(serviceName = "WebServiceGuestBook")
@Stateless()
public class WebServiceGuestBook {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addNumbers")
    public int addNumbers(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i + j;
        return k;
    }
}
