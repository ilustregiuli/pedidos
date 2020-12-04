package entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	
	
	List<OrderItem> item = new ArrayList<>();
	
	public Order() {
		this.moment = new Date();
	}
	
	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}
	
	public List<OrderItem> getItem() {
		return item;
	}

	public Date getMoment() {
		return this.moment;
	}
	
	public OrderStatus getOrderStatus() {
		return this.status;
	}
	
	public void setOrderStatus(OrderStatus s) {
		this.status = s;
	}
	
	public void addItem(OrderItem item) {
		this.item.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.item.remove(item);
	}
	
	public double total() {
		double totalOrder = 0.0;
		for(OrderItem itemList : item) {
			totalOrder += itemList.subTotal();
		}
		return totalOrder;
	}
}
