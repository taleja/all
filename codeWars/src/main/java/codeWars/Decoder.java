package codeWars;

import java.util.HashMap;
import java.util.Map;

public class Decoder {

	public static String convertFromMorseToEnglish(String key) {
		Map<String, String> morseCodesSymbols = new HashMap<>();
		
		//alphabet
		morseCodesSymbols.put(".-", "A");
		morseCodesSymbols.put("-...", "B");
		morseCodesSymbols.put("-.-.", "C");
		morseCodesSymbols.put("-..", "D");
		morseCodesSymbols.put(".", "E");
		morseCodesSymbols.put("..-.", "F");
		morseCodesSymbols.put("--.", "G");
		morseCodesSymbols.put("....", "H");
		morseCodesSymbols.put("..", "I");
		morseCodesSymbols.put(".---", "J");
		morseCodesSymbols.put("-.-", "K");
		morseCodesSymbols.put(".-..", "L");
		morseCodesSymbols.put("--", "M");
		morseCodesSymbols.put("-.", "N");
		morseCodesSymbols.put("---", "O");
		morseCodesSymbols.put(".--.", "P");
		morseCodesSymbols.put("--.-", "Q");
		morseCodesSymbols.put(".-.", "R");
		morseCodesSymbols.put("...", "S");
		morseCodesSymbols.put("-", "T");
		morseCodesSymbols.put("..-", "U");
		morseCodesSymbols.put("...-", "V");
		morseCodesSymbols.put(".--", "W");
		morseCodesSymbols.put("-..-", "X");
		morseCodesSymbols.put("-.--", "Y");
		morseCodesSymbols.put("--..", "Z");
		
		//numbers
		morseCodesSymbols.put(".----", "1");
		morseCodesSymbols.put("..---", "2");
		morseCodesSymbols.put("...--", "3");
		morseCodesSymbols.put("....-", "4");
		morseCodesSymbols.put(".....", "5");
		morseCodesSymbols.put("-....", "6");
		morseCodesSymbols.put("--...", "7");
		morseCodesSymbols.put("---..", "8");
		morseCodesSymbols.put("----.", "9");
		morseCodesSymbols.put("-----", "0");
		
		//special symbols
		morseCodesSymbols.put(".-.-.-", ".");
		morseCodesSymbols.put("--..--", ",");
		morseCodesSymbols.put("..--..", "?");
		morseCodesSymbols.put("..--.", "!");
		morseCodesSymbols.put("---...", ":");
		morseCodesSymbols.put(".-..-.", "\"");
		morseCodesSymbols.put(".----.", "'");
		morseCodesSymbols.put("-...-", "=");
		morseCodesSymbols.put("-.-.-", ";");
		morseCodesSymbols.put("-..-.", "/");
		morseCodesSymbols.put("-....-", "-");
		morseCodesSymbols.put("-.--.", "(");
		morseCodesSymbols.put("-.--.-", ")");
		morseCodesSymbols.put("..--.-", "_");
		morseCodesSymbols.put(".--.-.", "@");
		morseCodesSymbols.put(".-...", "&");
		morseCodesSymbols.put(".-.-.", "+");
		morseCodesSymbols.put("...-..-", "$");
		
		return morseCodesSymbols.get(key);
	}

}
