package codeWars;

import java.util.HashMap;
import java.util.Map;

public class Encoder {

	public static String convertFromEnglishToMorseCode(String key) {
		Map<String, String> englishSymbols = new HashMap<>();
		
		//alphabet
		englishSymbols.put("A", ".-");
		englishSymbols.put("B", "-...");
		englishSymbols.put("C", "-.-.");
		englishSymbols.put("D", "-..");
		englishSymbols.put("E", ".");
		englishSymbols.put("F", "..-.");
		englishSymbols.put("G", "--.");
		englishSymbols.put("H", "....");
		englishSymbols.put("I", "..");
		englishSymbols.put("J", ".---");
		englishSymbols.put("K", "-.-");
		englishSymbols.put("L", ".-..");
		englishSymbols.put("M", "--");
		englishSymbols.put("N", "-.");
		englishSymbols.put("O", "---");
		englishSymbols.put("P", ".--.");
		englishSymbols.put("Q", "--.-");
		englishSymbols.put("R", ".-.");
		englishSymbols.put("S", "...");
		englishSymbols.put("T", "-");
		englishSymbols.put("U", "..-");
		englishSymbols.put("V", "...-");
		englishSymbols.put("W", ".--");
		englishSymbols.put("X", "-..-");
		englishSymbols.put("Y", "-.--");
		englishSymbols.put("Z", "--..");
		
		//numbers
		englishSymbols.put("1", ".----");
		englishSymbols.put("2", "..---");
		englishSymbols.put("3", "...--");
		englishSymbols.put("4", "....-");
		englishSymbols.put("5", ".....");
		englishSymbols.put("6", "-....");
		englishSymbols.put("7", "--...");
		englishSymbols.put("8", "---..");
		englishSymbols.put("9", "----.");
		englishSymbols.put("0", "-----");
		
		//special symbols
		englishSymbols.put(".", ".-.-.-");
		englishSymbols.put(",", "--..--");
		englishSymbols.put("?", "..--..");
		englishSymbols.put("!", "..--.");
		englishSymbols.put(":", "---...");
		englishSymbols.put("\"", ".-..-.");
		englishSymbols.put("'", ".----.");
		englishSymbols.put("=", "-...-");
		englishSymbols.put(";", "-.-.-");
		englishSymbols.put("/", "-..-.");
		englishSymbols.put("-", "-....-");
		englishSymbols.put("(", "-.--.");
		englishSymbols.put(")", "-.--.-");
		englishSymbols.put("_", "..--.-");
		englishSymbols.put("@", ".--.-.");
		englishSymbols.put("&", ".-...");
		englishSymbols.put("+", ".-.-.");
		englishSymbols.put("$", "...-..-");
		
		return englishSymbols.get(key);
	}
}
