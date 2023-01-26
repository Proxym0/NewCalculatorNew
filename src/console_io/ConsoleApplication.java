package console_io;

import entity.Operation;
import service.CalculatorService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class ConsoleApplication implements Application {

    private final FileWriter fileWriter;

    {
        try {
            fileWriter = new FileWriter("history.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final Reader reader = new ConsoleReader();
    private final Writer consoleWriter = new ConsoleWriter();
    private final CalculatorService calculator = new CalculatorService();


    public void run() {
        while (true) {
            consoleWriter.methodWriter("Choose the type of operation.\n1.Calculator \n2.History output \n3.Exit");
        }
            int i=reader.readInteger();
            switch (i) {
                case 1: {
                    consoleWriter.methodWriter("Enter number 1");
                    double a = reader.readDouble();
                    consoleWriter.methodWriter("Enter number 2");
                    double b = reader.readDouble();
                    consoleWriter.methodWriter("Enter type");
                    String operationType = reader.readString();
                    Operation operation = new Operation(a, b, operationType);
                    Optional<Operation> result = calculator.calculator(operation);
                }
            }
//                case 2: {
//
//                }




            try {
                fileWriter.write(result.toString());
                fileWriter.write("\n");
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            consoleWriter.methodWriter("Result " + result);
        }


    @Override
    public String toString() {
        return "console_io.ConsoleApplication{" +
                "calculator=" + calculator +
                '}';
    }
}