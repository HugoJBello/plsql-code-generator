package utilities;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import main.TransformToTable;

public class AppObjectDbmsOutput {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("objectDeclaration.txt");
		Charset charset = StandardCharsets.UTF_8;

		String input = new String(Files.readAllBytes(path), charset);
		
		ObjectToDbmsOutput dbms = new ObjectToDbmsOutput();
 		dbms.setVariableName("result");
 		dbms.setIndexName("i");
 		dbms.setWithLoop(true); 		
		String output = dbms.convert(input);
		

		System.out.println(output);
		PrintWriter out = new PrintWriter("output_text.txt");	
		out.println(output);
		out.close();
	}

}
