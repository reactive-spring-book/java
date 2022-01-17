package rsb.javareloaded.typeinference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class TypeInference {

    @Test
    void infer() throws Exception {
        var map1 = Map.of("key", "value");
        Map<String, String> map2 = Map.of("key", "value");
        Assertions.assertEquals(map2, map1); //<1>
        var anonymousSubclass = new Object() {
            String name = "Peanut the Poodle";
            int age = 7;
        };
        //<2>
        Assertions.assertEquals(anonymousSubclass.age, 7);
        Assertions.assertEquals(anonymousSubclass.name, "Peanut the Poodle");
    }

}