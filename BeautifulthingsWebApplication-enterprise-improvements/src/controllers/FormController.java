package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.BeautifulThing;
import business.BusinessServiceInterface;

@ManagedBean
public class FormController {
	public FormController() {
		
	}
	
	@Inject
	BusinessServiceInterface bs;
	
	public String onSubmitCreate() throws SQLException {
		// read the get values from the form
		FacesContext context = FacesContext.getCurrentInstance();
		
		// store the get values in an object
		// b holds the value of the submitted object from the web page
		BeautifulThing b = context.getApplication().evaluateExpressionGet(context, "#{beautifulThing}", BeautifulThing.class);
		
		//testing
		System.out.println("The object you entered is: " + b.getThingTitle() + " " + b.getThingDescription() + " " + 
				b.getRating());
		
		// store the object in the database
		bs.insertOne(b);
		
		// put the get values into a response page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulThing", b);
		
		// show the response page
		return "ResponsePage.xhtml";
	}
	
	public ArrayList<BeautifulThing> getAll() throws SQLException {
		return bs.readAll();
	}
	
	public String onSubmitEdit() throws SQLException {
		// read the get values from the form
		FacesContext context = FacesContext.getCurrentInstance();
		
		// store the get values in an object
		// b holds the value of the submitted object from the web page
		BeautifulThing b = context.getApplication().evaluateExpressionGet(context, "#{beautifulThing}", BeautifulThing.class);
		
		//testing
		System.out.println("The object you entered is: " + b.getThingTitle() + " " + b.getThingDescription() + " " + 
				b.getRating());
		
		// store the object in the database
		bs.updateOne(b.getId(), b);
		
		// put the get values into a response page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulThing", b);
		
		// show the response page
		return "ResponsePage.xhtml";
	}
	
	public String onDelete(BeautifulThing b) throws SQLException {
		// delete the object in the database
		bs.deleteOne(b.getId());
		
		// put the get values into a response page
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulThing", b);
		
		return "ResponsePage.xhtml";
	}
	
	public String onShowEdit(BeautifulThing b) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulThing", b);
		
		return "EditForm.xhtml";
	}
	
	public String showEntryForm() {
		return "EntryForm.xhtml";
	}
	
	public String showIndexForm() {
		return "index.xhtml";
	}
}
