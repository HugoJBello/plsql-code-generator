package utilities;

import java.util.ArrayList;

import main.TransformToTable;

public class InvokeMethodPLSQL {
	
	private String generateSpaces (int numberOfSpaces){
		String spaces = new String(new char[numberOfSpaces]).replace("\0", " ");
		return spaces;
	}
	
	public String function(String functionName, ArrayList<String> entryList){
		String firstLine = functionName + "(";
		String output= firstLine;
		int spacesNumber = firstLine.length();
		ArrayList<String> entryListAux = new ArrayList<String>();
		String aux = "";
		for (int i=0; i<entryList.size()-1; i++){
			aux = aux + entryList.get(i) + " => " + entryList.get(i) + " ," + "\n";
		}
		aux = aux + entryList.get(entryList.size()-1) + " => " + entryList.get(entryList.size()-1) + "\n";
		TransformToTable tr = new TransformToTable();
		tr.setWithEndOfLineMark(false);
		String entryBlock = tr.obtainStringTable(aux);
		String[] entries = entryBlock.split("\n");
		
		output= output+ entries[0]+ "\n";
		
		for (int i=1; i< entries.length-1; i++){
			output = output+ generateSpaces(spacesNumber) + entries[i]+"\n";
			
		}
		output = output+ generateSpaces(spacesNumber)+entries[entries.length-1] + ");";
		return output;
	}
	
	public String function(String input){
		String str = input;
		str = str.replaceAll("\\s+"," ");
		str = str.replaceAll("FUNCTION\\s+","").replaceAll("PROCEDURE\\s+","").replaceAll("\\("," , ").replaceAll("\\)"," , ");
		str = str.replaceAll("\n","");
		str = str.replaceAll("RETURN", "").replaceAll("IS", "");
		String functionName = str.split(",")[0].trim();
		String[] aux = str.split(",");
 		ArrayList<String> entryList = new ArrayList<String>();
		for (int i=1; i< aux.length-1; i++) {
			entryList.add(aux[i].trim().split(" ")[0]);			
		}
		//System.out.println(functionName);
		//System.out.println(entryList.toString());
		return function(functionName, entryList).replace("  );", ");");
	}

}
