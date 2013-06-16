/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Roel_Storms
 */
public class RegistrationController extends AbstractController {
    
    public RegistrationController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("RegistrationController");
        ModelAndView mv = new ModelAndView("registrationview");
        return mv;
    }
}