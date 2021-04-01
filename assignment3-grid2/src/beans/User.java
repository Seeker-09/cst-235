package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class User {
	private String firstName, lastName;
	
	public User() {
		firstName = "David";
		lastName = "Mundt";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
