package utilities;

import main.TransformToTable;

public class querryCsvToDeclaration {
	String endOfColumnMark = ";";
	String variablePrefix = "v_";
	boolean changeToLowerCase = true;
	boolean detectVarChars = true;
	public String convert(String input){
		String str;
		String output= "";
		//reemplazamos
		str=input.replaceAll("\"","");
		//str= str.replaceAll("\n", " ").replaceAll(",","").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(";","");
		str= str.replaceAll("\\st_\\w+","");
		String[] heads = str.split("\n")[0].split(endOfColumnMark);
		String[] values = str.split("\n")[1].split(endOfColumnMark);

		for (int i =0; i< heads.length; i++){
			String head; 
			if (changeToLowerCase){
				head = heads[i].trim().toLowerCase();
			} else {
				head = heads[i].trim();
			}
			String value;
			if (detectVarChars){
				if (!values[i].matches("-?\\d+(\\.\\d+)?")){
					value = "'"+values[i].trim() + "'";
				} else {
					value = values[i].trim();}
			} else {
				value = values[i].trim();
			}
			output= output + head + " := " + value + ";\n"; 
		}
		TransformToTable transformer = new TransformToTable();
		transformer.setEndOflineMark(";");
		transformer.setWithEndOfLineMark(true);
		output = transformer.obtainStringTable(output);

		return output;
	}

}
