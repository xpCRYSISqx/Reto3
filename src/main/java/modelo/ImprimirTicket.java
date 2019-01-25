package modelo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ImprimirTicket {
	
	public void imprimirTicket() throws IOException {
	List<String> lines = Arrays.asList("The first line", "The second line");
	Path file = Paths.get("Ticket.txt");
	Files.write(file, lines, Charset.forName("UTF-8"));
	}
}