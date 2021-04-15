package business;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import beans.BeautifulThing;
import database.DatabaseInterface;

@Local
@Stateless
@Alternative
public class BusinessService1 implements BusinessServiceInterface {
	@Inject
	DatabaseInterface db;

	@Override
	public int deleteOne(int d) {
		return db.deleteOne(d);
	}

	@Override
	public int insertOne(BeautifulThing b) {
		return db.insertOne(b);
	}

	@Override
	public ArrayList<BeautifulThing> readAll() {
		return db.readAll();
	}

	@Override
	public int updateOne(int d, BeautifulThing b) {
		return db.updateOne(d, b);
	}

}
