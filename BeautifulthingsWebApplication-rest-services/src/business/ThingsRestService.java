package business;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.BeautifulThing;

@RequestScoped
@Path("/things")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class ThingsRestService {
	@Inject
	BusinessServiceInterface bs;
	
	// get all records and display them in json format
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<BeautifulThing> getAllThingsAsJson(){
		return bs.readAll();
	}
	
	@GET
	@Path("/getjsonbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public BeautifulThing getOneThingAsJson(@PathParam("id") int id) {
		return bs.readOne(id);
	}
	
	@GET
	@Path("/getjsonbyname/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public ArrayList<BeautifulThing> getOneThingAsJson(@PathParam("name") String name) {
		return bs.searchFor(name);
	}
	
	// get all records and display them in json format
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	
	public BeautifulThing[] getAllThingsAsXML(){
		List<BeautifulThing> things = bs.readAll();
		return things.toArray(new BeautifulThing[things.size()]);
	}
}
