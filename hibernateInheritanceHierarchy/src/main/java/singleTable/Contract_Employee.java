package singleTable;

import javax.persistence.*;

@Entity
@DiscriminatorValue("contractemployee")
public class Contract_Employee extends Employee {

	@Column(name = "pay_per_hour")
	private float pay_for_hour;
	@Column(name = "contract_duration")
	private String contract_duration;

	public float getPay_for_hour() {
		return pay_for_hour;
	}

	public void setPay_for_hour(float pay_for_hour) {
		this.pay_for_hour = pay_for_hour;
	}

	public String getContract_duration() {
		return contract_duration;
	}

	public void setContract_duration(String contract_duration) {
		this.contract_duration = contract_duration;
	}	
}
