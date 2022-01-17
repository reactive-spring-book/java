package rsb.javareloaded;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class MultilineStrings {

    private final String instant = Instant.now().toString();

    private final String multilines = String.format("""
                    <html>
                    <body>
                    <h1> Hello, world, @ %s!</h1> </body>
                    </html>
                    """, instant)
            .trim();

    private final String concatenated =
            "<html>\n<body>\n" +
                    "<h1> Hello, world, @ " + instant + "!</h1> </body>\n" +
                    "</html>";

    @Test
    void stringTheory() {
        Assertions.assertEquals(this.multilines, this.concatenated);
    }
}
