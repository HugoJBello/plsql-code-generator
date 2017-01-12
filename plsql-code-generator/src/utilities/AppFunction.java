package utilities;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import main.TransformToTable;

public class AppFunction {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("function.txt");
		Charset charset = StandardCharsets.UTF_8;
		
		String input = new String(Files.readAllBytes(path), charset);
		
		String functionName = "fp_r_registro";
		ArrayList<String> entryList = new ArrayList<String>();
		entryList.add("aaaaaaaa");
		entryList.add("aaaaasd");
		entryList.add("aaafffa");
		entryList.add("af");

		
		
 		InvokeMethodPLSQL inv = new InvokeMethodPLSQL();
 		String output = inv.function(functionName,entryList);
		output = inv.function(input);
		//TransformToTable transformer = new TransformToTable();
		//String output = transformer.obtainStringTable(dbmsOutputs);
		
		
		System.out.println(output);
		PrintWriter out = new PrintWriter("output_text.txt");	
		out.println(output);
		out.close();


	}

}
