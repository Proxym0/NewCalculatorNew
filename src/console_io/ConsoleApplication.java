package console_io;

import entity.Operation;
import service.CalculatorService;

import java.util.Optional;

public class ConsoleApplication implements Application {

    private final Reader reader = new ConsoleReader();
    private final Writer consoleWriter = new ConsoleWriter();
    private final CalculatorService calculator = new CalculatorService();


    public void run() {
        while (true) {
            consoleWriter.methodWriter("Choose the type of operation.\n1.Calculator \n2.History output \n3.Exit");
            int i = reader.readInteger();
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
                    consoleWriter.methodWriter("Result " + result);
                }
                continue;
                case 2: {
                    calculator.showHistory().forEach(s ->consoleWriter.methodWriter(s.toString()));
                    continue;
                }
                case 3: {
                    return;
                }
            }
        }
    }


    @Override
    public String toString() {
        return "console_io.ConsoleApplication{" +
                "calculator=" + calculator +
                '}';
    }
}