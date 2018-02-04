package springBootProject.products;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dealer {

	@Column(name = "dealerId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dealerId;
	@OneToMany
	private List<Address> addresses;
	
	//OneToOne 
	//private Owner owner;

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}
}
