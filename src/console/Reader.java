package console;

import java.util.Scanner;

public interface Reader {
    Scanner SCANNER = new Scanner(System.in);

    static String readString() {
        return SCANNER.next();
    }

    static double readDouble() {
        return SCANNER.nextDouble();
    }

    static int readInteger() {
        return SCANNER.nextInt();
    }
}
