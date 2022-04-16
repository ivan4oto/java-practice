package parsing;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

	private static HashMap<String, HashMap<String, String>> jsonMap = new HashMap<>();
	private static String currentKey;

	public static String parseLine(String line) {
		if(line.startsWith("[") & line.endsWith("]")) {
			line = line.replace("[", "");
			line = line.replace("]", "");
			jsonMap.put(line, new HashMap<String, String>());
			currentKey = line;
			return line;
		}
		// System.out.println(line);

		line = line.replace(" ", "");
		if (line.isEmpty()){
			return "";
		}
		List<String> items = Arrays.asList(line.split("="));
		// System.out.println(items.toString());
		HashMap<String, String> tempMap = new HashMap<>();
		tempMap.put(items.get(0), items.get(1));
		tempMap.putAll(jsonMap.get(currentKey));

		jsonMap.put(currentKey, tempMap);

		return line;
	}

	public static void main(String[] args) {
		String filename = "testfile.ini";
		try{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null) {
                parseLine(line);
            };
            reader.close();
			System.out.println(jsonMap);

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}