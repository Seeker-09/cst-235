package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
public class FormController {
	
	public String onSubmit() {
		// Gets the user values from the input form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// Used for testing
		//System.out.println("its working");
		//System.out.println("The first name is " + user.getFirstName());
		//System.out.println("The Last name is " + user.getLastName());
		
		// put the user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		// Show next page
		return "Response.xhtml";
	}
}
