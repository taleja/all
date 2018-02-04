package springBootProject.products;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DiscountProduct {

	@EmbeddedId
	private  DiscountProductId discountProductId;
	@ManyToOne
	private Product product;
	@ManyToOne
	private Discount discount;

	public DiscountProductId getDiscountProductId() {
		return discountProductId;
	}

	public void setDiscountProductId(DiscountProductId discountProductId) {
		this.discountProductId = discountProductId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	
}
