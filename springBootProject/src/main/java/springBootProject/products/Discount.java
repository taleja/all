package springBootProject.products;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Discount {

	@Column(name =  "discount_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long discountId;
	private Date startDate;
	private Date endDate;
	@OneToMany
	private List<DiscountProduct> discountProducts; 
	
	public Long getDiscountId() {
		return discountId;
	}
	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<DiscountProduct> getDiscountProducts() {
		return discountProducts;
	}
	public void setDiscountProducts(List<DiscountProduct> discountProducts) {
		this.discountProducts = discountProducts;
	}
	
	
}
