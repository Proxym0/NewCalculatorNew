package console_io;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final Scanner scanner=new Scanner(System.in);

    public String readString(){
        return scanner.next();
    }
    public double readDouble(){
        return scanner.nextDouble();
    }
}
