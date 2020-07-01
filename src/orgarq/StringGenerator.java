package orgarq;

import java.util.Random;

public class StringGenerator {

    public static String generateString(int length, String pat) {
        Random r = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
        for(int i = 0; i < length - 1; i++) {
            stringBuilder.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        int begin = r.nextInt(length - 3);
        stringBuilder.replace(begin, begin + pat.length(), pat);

        return stringBuilder.toString();
    }
}
