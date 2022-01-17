package rsb.javareloaded.closeable;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

@Slf4j
class TraditionalResourceHandling {

    private final File file = Utils.setup();

    @Test
    void read() throws Exception {
        var bufferedReader = (BufferedReader) null; // <1>
        try {
            bufferedReader = new BufferedReader(new FileReader(this.file));
            var stringBuilder = new StringBuilder();
            var line = (String) null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            var contents = stringBuilder.toString().trim();
            Assertions.assertEquals(contents, Utils.CONTENTS);
        } //
        catch (IOException e) {
            Utils.error(e);
        } //
        finally {
            close(bufferedReader);
        }
    }

    private static void close(Reader reader) { // <3>
        if (reader != null) {
            try {
                reader.close();
            } //
            catch (IOException e) {
                Utils.error(e);
            }
        }
    }
}
