package entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Address {
	@Id private String streetAddress;
	private String city;
	private String postalCode;
	private String state;

	@OneToOne
	private Student student;

	public Address() {
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address(String streetAddress, String city, String postalCode, String state) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
	}


}
