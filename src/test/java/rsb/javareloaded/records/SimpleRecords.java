package rsb.javareloaded.records;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class SimpleRecords {

	record Customer(Integer id, String name) {
	}

	record Order(Integer id, double total) {
	}

	record CustomerOrder(Customer customer, List<Order> orders) {
	}

	@Test
	void simple() {
		var customer = new Customer(2534, "Tammie");
		var order1 = new Order(2232, 74.023);
		var order2 = new Order(9593, 23.44);
		var cos = new CustomerOrder(customer, List.of(order1, order2));
		Assertions.assertEquals(order1.id(), 2232);
		Assertions.assertEquals(order1.total(), 74.023);
		Assertions.assertEquals(customer.name(), "Tammie");
		Assertions.assertEquals(cos.orders().size(), 2);
	}

}
