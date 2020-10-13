package hello;


import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentThree{

	private String firstName;
	private String lastName;
	private String favoriteLanguage;
	
	

	//list countries for the drop down list
	List<String> countryOptions;
	
	//create no-arg constructor
	public StudentThree()
	{
		
		
	}
	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	
	
	
	//define getter/setter methods-
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