package business;

import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrdersBusinessInterface {
	public void test();
	public List<Order> getOrders();
	public void setOrder(List<Order> orders);
}