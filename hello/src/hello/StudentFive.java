package hello;




import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentFive{

	private String firstName;
	private String lastName;
	private String favoriteLanguage;
	
		
	


	//create no-arg constructor
	public StudentFive()
	{
		//pre-populating the bbean data
		firstName="Mary";
		lastName="public";
		favoriteLanguage="PHP";
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