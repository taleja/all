package codeWars;

public class MorseCodeDecoder {

	public static void main(String... args) {
		String morse = ".... . -.--   .--- ..- -.. .";
		String morse1 = ".-..-. ... --- ... ..--.   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-  .-..-.";
		decode(morse1);
	}

	public static String decode(String morseCode) {
		StringBuilder buffer = new StringBuilder();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < morseCode.length(); i++) {

			if (isThreeWhitespaces(morseCode, i)) {
				consumeWord(buffer, result);
			} else if (Character.isWhitespace(morseCode.charAt(i))) {
				consumeCharacter(buffer, result);
			} else {
				consumeSignal(morseCode, buffer, i);
			}

		}
		consumeCharacter(buffer, result);

		System.out.println(result.toString());
		return result.toString();
	}

	private static void consumeSignal(String morseCode, StringBuilder buffer, int i) {
		buffer.append(morseCode.charAt(i));
	}

	private static boolean isThreeWhitespaces(String morseCode, int i) {
		return i + 2 < morseCode.length() && Character.isWhitespace(morseCode.charAt(i))
				&& Character.isWhitespace(morseCode.charAt(i + 1)) && Character.isWhitespace(morseCode.charAt(i + 2));
	}

	private static void consumeWord(StringBuilder buffer, StringBuilder result) {
		if (buffer.length() > 0) {
			result.append(Decoder.convertFromMorseToEnglish(buffer.toString())).append(" ");
			buffer.setLength(0);
		}
	}

	private static void consumeCharacter(StringBuilder buffer, StringBuilder result) {
		if (buffer.length() > 0) {
			result.append(Decoder.convertFromMorseToEnglish(buffer.toString()));
			buffer.setLength(0);
		}
	}

}
