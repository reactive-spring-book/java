package rsb.javareloaded.closeable;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Files;
import java.time.Instant;

@Slf4j
public class Utils {

	// <1>
	static String CONTENTS = String.format("""
			<html>
			<body><h1> Hello, world, @ %s !</h1> </body>
			</html>
			""", Instant.now().toString()).trim();

	// <2>
	@SneakyThrows
	static File setup() {
		var path = Files.createTempFile("rsb", ".txt");
		var file = path.toFile();
		file.deleteOnExit();
		Files.writeString(path, CONTENTS);
		return file;
	}

	// <3>
	static void error(Throwable throwable) {// <2>
		log.error("there's been an exception processing the read! ", throwable);
	}

}
