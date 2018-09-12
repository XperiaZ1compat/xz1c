package javabean;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	public Double totalMoney;
	
	public List<GoodItem> goods=new ArrayList<GoodItem>();

	public Double getTotalMoney() {
		totalMoney=0.0;
		for(int i=0;i<goods.size();i++){
			totalMoney+=goods.get(i).getTotal();
		}
		return totalMoney;
	}

	public List<GoodItem> getGoods() {
		return goods;
	}
	public void setGoods(List<GoodItem> goods) {
		this.goods = goods;
	}	
	
}
