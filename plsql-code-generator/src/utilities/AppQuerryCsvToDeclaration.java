package utilities;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import main.TransformToTable;

public class AppQuerryCsvToDeclaration {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("querry.csv");
		Charset charset = StandardCharsets.UTF_8;

		String input = new String(Files.readAllBytes(path), charset);
		
		querryCsvToDeclaration dbms = new querryCsvToDeclaration();
		String output = dbms.convert(input);
		

		System.out.println(output);
		PrintWriter out = new PrintWriter("output_text.txt");	
		out.println(output);
		out.close();
	}

}
