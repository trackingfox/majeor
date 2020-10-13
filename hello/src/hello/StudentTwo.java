package hello;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentTwo{

	private String firstName;
	private String lastName;
	private String country;
	
	//list countries for the drop down list
	List<String> countryOptions;
	
	//create no-arg constructor
	public StudentTwo()
	{
		//populate the list of countries
		countryOptions= new ArrayList<>();
		
		countryOptions.add("Brazil");
		countryOptions.add("France");
		countryOptions.add("Germany");
		countryOptions.add("India");
		countryOptions.add("Turkey");
		countryOptions.add("UK");
		countryOptions.add("US");
		
	}
	
	//need to add a getter method for country options
	public List<String> getCountryOptions() {
		return countryOptions;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}