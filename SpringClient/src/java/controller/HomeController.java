/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.stereotype.Controller;



/**
 *
 * @author Roel_Storms
 */
@Controller
public class HomeController extends AbstractController {
    
    public HomeController() {
    }
    
    @RequestMapping(value = "/home/")
    public String home()
    {
        System.out.println("home controller");
        
        return "WEB-INF/jsp/home.jsp";
        
    }
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}