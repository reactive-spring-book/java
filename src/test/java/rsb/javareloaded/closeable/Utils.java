package rsb.javareloaded.closeable;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.time.Instant;

@Slf4j
public class Utils {

	static String CONTENTS = String.format("""
			<html>
			<body><h1> Hello, world, @ %s !</h1> </body>
			</html>
			""", Instant.now().toString()).trim();

	@SneakyThrows
	static File setup() {
		var file = Files.createTempFile("rsb", ".txt").toFile();
		file.deleteOnExit();
		try (var fw = new FileWriter(file)) {
			FileCopyUtils.copy(CONTENTS, fw);
		}
		return file;
	}

	static void error(Throwable throwable) {// <2>
		log.error("there's been an exception processing the read! ", throwable);
	}

}
