package rsb.javareloaded.typeinference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

class LambdasAndTypeInference {

	@FunctionalInterface
	interface MyHandler {

		String handle(String one, int two);

	}

	private String delegate(String s, Integer two) {
		return "Hello " + s + ":" + two;
	}

	@Test
	void lambdas() {
		MyHandler defaultHandler = this::delegate;
		var withVar = new MyHandler() {

			@Override
			public String handle(String one, int two) {
				return delegate(one, two);
			}
		};
		var withCast = (MyHandler) this::delegate;
		var string = "hello";
		var integer = 2;
		var set = new HashSet<>(List.of(withCast.handle(string, integer), withVar.handle(string, integer),
				defaultHandler.handle(string, integer)));
		Assertions.assertEquals(set.size(), 1, "the 3 entries should all be the same, and thus deduplicated out");
	}

}
