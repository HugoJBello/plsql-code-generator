package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("foo.txt");
		Charset charset = StandardCharsets.UTF_8;

		String content = new String(Files.readAllBytes(path), charset);
		
		
		//DeclarationClean cleaner = new DeclarationClean();
		//System.out.println(cleaner.clean(content));
		TransformToTable transformer = new TransformToTable();
		String output = transformer.obtainStringTable(content);
		System.out.println(output);
		PrintWriter out = new PrintWriter("output_text.txt");	
		out.println(output);
		out.close();


	}

}
