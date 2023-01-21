import java.io.FileWriter;
import java.io.IOException;

public class ConsoleApplication implements Application {

    private final FileWriter fileWriter; {
        try {
            fileWriter = new FileWriter("history.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private final Reader reader = new ConsoleReader();
    private final Writer consoleWriter = new ConsoleWriter();
    private final ConsoleCalculator calculator=new ConsoleCalculator();




    public void run() {
        while (true) {
            consoleWriter.methodWriter("Enter number 1");
            double a = reader.readDouble();
            consoleWriter.methodWriter("Enter number 2");
            double b = reader.readDouble();
            consoleWriter.methodWriter("Enter type");
            String operationType = reader.readString();
            Operation operation = new Operation(a, b, operationType);
            Operation result = calculator.calculator(operation);
            try {
                fileWriter.write(result.toString());
                fileWriter.write("\n");
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            consoleWriter.methodWriter("Result " + result);
        }
    }
    @Override
    public String toString() {
        return "ConsoleApplication{" +
                "calculator=" + calculator +
                '}';
    }
}