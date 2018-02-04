package springBootProject.products;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class DealerProduct {

	@EmbeddedId
	private DealerProductID dealerProductId;

	public DealerProductID getDealerProductId() {
		return dealerProductId;
	}

	public void setDealerProductId(DealerProductID dealerProductId) {
		this.dealerProductId = dealerProductId;
	}
	

}