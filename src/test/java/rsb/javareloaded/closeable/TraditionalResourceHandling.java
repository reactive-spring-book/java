package rsb.javareloaded.closeable;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static rsb.javareloaded.closeable.Utils.error;

@Slf4j
class TraditionalResourceHandling {

	private final File file = Utils.setup();// <1>

	@Test
	void read() throws Exception {
		var bufferedReader = (BufferedReader) null; // <2>
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
		catch (IOException e) { // <3>
			error(e);
		} //
		finally { // <4>
			close(bufferedReader);
		}
	}

	private static void close(Reader reader) { // <3>
		if (reader != null) {
			try {
				reader.close();
			} //
			catch (IOException e) {
				error(e);
			}
		}
	}

}
