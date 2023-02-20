package sg.edu.nus.iss.workshop13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop13Application {

	public static void main(String[] args) throws IOException {

		SpringApplication app = new SpringApplication(Workshop13Application.class);

		String dataDir = null;

		ApplicationArguments appArgs = new DefaultApplicationArguments(args);

		if (appArgs.containsOption("dataDir")) {

			dataDir = appArgs.getOptionValues("dataDir").get(0);
			Files.createDirectories(Paths.get("C:" + dataDir));

		}else{
			System.out.println("Please indicate dataDir and rerun the program");
			System.exit(1);
		}

		app.run(args);

		// SpringApplication.run(Workshop13Application.class, args);
	}

}
