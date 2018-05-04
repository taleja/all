package codeWars;

public class MorseCodeDecoder {

	public static void main(String... args) {
		String morse = ".... . -.--   .--- ..- -.. .";
		String morse1 = ".-..-. ... --- ... ..--.   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-  .-..-.";
		decode(morse1);
	}

	public static String decode(String morseCode) {
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < morseCode.length(); i++) {

			if (!Character.isWhitespace(morseCode.charAt(i))) {
				sb.append(morseCode.charAt(i));
			} else {
				if (i + 2 < morseCode.length() && Character.isWhitespace(morseCode.charAt(i + 1)) &&
						Character.isWhitespace(morseCode.charAt(i + 2))) {
					if (sb.length() > 0) {
						result.append(Decoder.convertFromMorseToEnglish(sb.toString())).append(" ");
						sb.setLength(0);
					}
				} else {
					if (sb.length() > 0) {
						result.append(Decoder.convertFromMorseToEnglish(sb.toString()));
						sb.setLength(0);
					}
				}
			}
			if (i == morseCode.length() - 1) {
				if (sb.length() > 0) {
					result.append(Decoder.convertFromMorseToEnglish(sb.toString()));
					sb.setLength(0);
				}
			}
		}
		System.out.println(result.toString());
		return result.toString();
	}


}
