package orgarq;

public class Main {

    public static void main(String[] args) {

	    KnuthMorris knuthMorris = new KnuthMorris();
	    String txt = StringGenerator.generateString(200, "ABC");
        String txt2 = StringGenerator.generateString(50000, "ABC");
        String txt3 = StringGenerator.generateString(1000000, "ABC");
        String txt4 = StringGenerator.generateString(5000000, "ABC");
        System.out.println(txt);
        System.out.println(knuthMorris.KMPSearch("ABC", txt));
        System.out.println(knuthMorris.KMPSearch("ABC", txt2));
        System.out.println(knuthMorris.KMPSearch("ABC", txt3));
        System.out.println(knuthMorris.KMPSearch("ABC", txt4));
    }
}
