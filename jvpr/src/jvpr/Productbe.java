package jvpr;

public class Productbe {
	String pr_id;
	String pr_name;
	Integer pr_price;
	Integer pr_quan;
	String seller_id;
	Integer wallet;
	Integer user_pr_quan;
	String user_pr_id;
	String user_id;
	public Integer getwallet() {
		return wallet;
	}
	public void setwallet(Integer wallet) {
		this.wallet = wallet;
	}
	
	public Integer getuser_pr_quan() {
		return user_pr_quan;
	}
	public void setuser_pr_quan(Integer user_pr_quan) {
		this.user_pr_quan = user_pr_quan;
	}
	
	public String getpr_id() {
		return pr_id;
	}
	public void setpr_id(String id) {
		this.pr_id = id;
	}
	
	public String getuser_pr_id() {
		return user_pr_id;
	}
	public void setuser_pr_id(String id) {
		this.user_pr_id = id;
	}
	
	public String getuser_id() {
		return user_id;
	}
	public void setuser_id(String id) {
		this.user_id = id;
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
