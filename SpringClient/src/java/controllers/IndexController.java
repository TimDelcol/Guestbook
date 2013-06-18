/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author matthias
 */
@Controller
public class IndexController {
	
	@RequestMapping("/index.htm")
	public void home(){
		;
	}
}
