package springBootProject.products;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DealerProductID implements Serializable{

	@Column(name = "product_id")
	private Long productId;
	@Column(name = "dealer_id")
	private Long dealerId;
	@Column(name =  "adress_id")
	private Long adressId;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getDealerId() {
		return dealerId;
	}
	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}
	public Long getAdressId() {
		return adressId;
	}
	public void setAdressId(Long adressId) {
		this.adressId = adressId;
	}
	
	
}
