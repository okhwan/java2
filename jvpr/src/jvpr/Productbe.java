package jvpr;

public class Productbe {
	String pr_id;
	String pr_name;
	Integer pr_price;
	Integer pr_quan;
	String seller_id;
	public String getpr_id() {
		return pr_id;
	}
	public void setpr_id(String id) {
		this.pr_id = id;
	}
	
	public String getpr_name() {
		return pr_name;
	}
	public void setpr_name(String name) {
		this.pr_name = name;
	}
	
	public Integer getpr_price() {
		return pr_price;
	}
	public void setpr_price(Integer price) {
		this.pr_price = price;
	}
	
	public Integer getpr_quan() {
		return pr_quan;
	}
	public void setpr_quan(Integer quan) {
		this.pr_quan = quan;
	}
	
	public String getseller_id() {
		return seller_id;
	}
	public void setseller_id(String seller_id) {
		this.seller_id = seller_id;
	}
}
