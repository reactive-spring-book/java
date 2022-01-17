package rsb.javareloaded.records;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

class RecordConstructors {

    record Customer(Integer id, String email) {

        Customer {
            Assert.isTrue(StringUtils.hasText(email), () -> "the email is invalid");
        }

        Customer(String email) {
            this(-1, email);
        }
    }

    @Test
    void multipleConstructors() {
        var customer1 = new Customer("test@email.com");
        var customer2 = new Customer(2, "test2@gmail.com");
        Assertions.assertEquals(customer1.id(), -1);
        Assertions.assertEquals(customer2.id(), 2);
    }
}
