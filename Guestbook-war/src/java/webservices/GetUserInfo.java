/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import beans.MessageEntityFacadeLocal;
import beans.UserentityFacadeLocal;
import entities.Userentity;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author matthias
 */
@WebService(serviceName = "GetMessages")
public class GetUserInfo {
	@EJB
	UserentityFacadeLocal userEntityFacadeLocal;
	
	@EJB
	MessageEntityFacadeLocal mf;

	@WebMethod(operationName = "getUserInfo")
    public String getUserInfo(@WebParam(name = "userId")
            int userId)
    {
        Userentity user = userEntityFacadeLocal.find(userId);
	if(user == null){
		System.out.println("No user found with id " + userId);
		return null;
	}
		
	
        //Userentity user = userEntityFacadeLocal.findById(userId);
        return user.toString();
    }
}
