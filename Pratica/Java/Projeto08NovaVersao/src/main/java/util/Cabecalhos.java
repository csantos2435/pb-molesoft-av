package util;

public class Cabecalhos {

    private Cabecalhos(){}

    private static final int DEFAULT_SIZE = 50;

    public static void printTitle(String title) {
        String line = generateLine();
        String lineTitle = generateLineWithTitle(title.toUpperCase());
        System.out.println(line);
        System.out.println(lineTitle);
        System.out.println(line);
        System.out.println();
    }

    public static void printSubTitle(String title) {
        String line = generateLine();
        String lineTitle = generateLineWithTitle(title);
        System.out.println(line);
        System.out.println(lineTitle);
        System.out.println(line);
        System.out.println();
    }

    public static void separationLine() {
        String line = generateLine();
        System.out.println();
        System.out.println(line);
        System.out.println();
    }

    private static String generateLine() {
        StringBuilder l = new StringBuilder();
        l.append("*".repeat(Math.max(0, DEFAULT_SIZE)));
        return l.toString();
    }

    private static String generateLineWithTitle(String title) {
        int size = (DEFAULT_SIZE - (title.length() + 2)) / 2;
        StringBuilder l = new StringBuilder();
        String titleCorrect = " " + title + " ";
        l.append("*".repeat(Math.max(0, DEFAULT_SIZE)));
        l.replace(size, size + titleCorrect.length(), titleCorrect);
        return l.toString();
    }
}
