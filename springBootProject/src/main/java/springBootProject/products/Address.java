package springBootProject.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.MapKeyType;

@Entity
public class Address {

	@Column(name = "adress_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adressID;
	@ManyToOne
	private Dealer dealer;
	private String city;

	public Long getAdressID() {
		return adressID;
	}

	public void setAdressID(Long adressID) {
		this.adressID = adressID;
	}
	
}
