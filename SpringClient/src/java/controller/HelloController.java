/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.User;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.HelloService;

/**
 *
 * @author Roel_Storms
 */
public class HelloController extends SimpleFormController {
    private HelloService helloService;

    public HelloController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(User.class);
        setCommandName("user");
        setSuccessView("registrationsucces");
        setFormView("registration");
    }
    
    public void setHelloService(HelloService helloService) {
    this.helloService = helloService;
    }
   
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
     @Override
     protected ModelAndView onSubmit(
     HttpServletRequest request, 
     HttpServletResponse response, 
     Object command, 
     BindException errors) throws Exception {
     User user = (User) command;
     service.HelloService.sayHello("test");
     
     ModelAndView mv = new ModelAndView(getSuccessView());
     mv.addObject("helloMessage", "Hello");
     return mv;
     }
     
}