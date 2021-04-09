package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {
	List<Order> orders = new ArrayList<Order>();
	
	public AnotherOrdersBusinessService() {
		orders.add(new Order("000000000a", "This is product 1", (float)1.00, 1));
		orders.add(new Order("000000000b", "This is product 2", (float)2.00, 2));
		orders.add(new Order("000000000c", "This is product 3", (float)3.00, 3));
		orders.add(new Order("000000000d", "This is product 4", (float)4.00, 4));
		orders.add(new Order("000000000e", "This is product 5", (float)5.00, 5));
		orders.add(new Order("000000000f", "This is product 6", (float)6.00, 6));
		orders.add(new Order("000000000g", "This is product 7", (float)7.00, 7));
		orders.add(new Order("000000000h", "This is product 8", (float)8.00, 8));
		orders.add(new Order("000000000i", "This is product 9", (float)9.00, 9));
		orders.add(new Order("000000000j", "This is product 10", (float)10.00, 10));
	}

	@Override
	public void test() {
		System.out.println("Running   02");
	}

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void setOrder(List<Order> orders) {
		this.orders = orders;		
	}

}
