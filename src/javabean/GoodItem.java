package javabean;

public class GoodItem {
	public String name;
	public Integer number=0;
	public Double price=0.0;
	public Double total=0.0;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	
	
	public void setNumber(Integer number) {
		this.number = number;
		total=number*price;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
		total=number*price;
	}
	public Double getTotal() {		
		return total;
	}	
}
