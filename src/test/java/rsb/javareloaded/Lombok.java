package rsb.javareloaded;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j // <1>
public class Lombok {

	@Data
	@RequiredArgsConstructor
	class Customer {

		private final String name;

		private final Integer id;

	}

	class MyReallyBadException extends Exception {

	}

	// <2>
	void boom() throws MyReallyBadException {
		throw new MyReallyBadException();
	}

	// <3>
	@SneakyThrows
	void boomClient() {
		boom();
	}

	@Test
	void sneakyThrows() {
		Assertions.assertThrows(MyReallyBadException.class, this::boomClient);
	}

	@Test
	void lombok() {// <4>

		var customer = new Customer("Betty", 1);
		log.info("the customer toString(): " + customer);
		log.info("the name is {} and the id is {}", customer.getName(), customer.getId());
		Assertions.assertEquals(customer.getId(), 1);
		Assertions.assertEquals(customer.getName(), "Betty");

	}

}
