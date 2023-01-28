package console_io;

import entity.Operation;
import entity.Users;
import service.CalculatorService;
import service.UserService;

import java.util.Optional;

public class ConsoleApplication implements Application {

    private final Reader reader = new ConsoleReader();
    private final Writer consoleWriter = new ConsoleWriter();
    private final CalculatorService calculator = new CalculatorService();
    UserService userService = new UserService();
    ConsoleSession consoleSession;


    public void run() {
        while (true) {
            if (consoleSession == null) {
                consoleWriter.methodWriter("Welcome to Calculator.\nPlease select an operation \n1.Registration 2.Entrance 3.Exit");
                int i = reader.readInteger();
                switch (i) {
                    case 1: {
                        consoleWriter.methodWriter("Enter your name ");
                        String firstName = reader.readString();
                        consoleWriter.methodWriter("Enter your nickname ");
                        String userName = reader.readString();
                        consoleWriter.methodWriter("Enter password");
                        String password = reader.readString();
                        Users user = new Users(firstName, userName, password);
                        userService.create(user);
                        break;
                    }
                    case 2: {
                        consoleWriter.methodWriter("Enter your nickname ");
                        String userName1 = reader.readString();
                        consoleWriter.methodWriter("Enter password");
                        String password1 = reader.readString();
                        Optional<Users> byUserName = userService.findByUserName(userName1);
                        if (byUserName.isPresent()) {
                            Users user1 = byUserName.get();
                            if (user1.getPassword().equals(password1)) {
                                consoleSession = new ConsoleSession(user1);
                                continue;
                            } else {
                                consoleWriter.methodWriter("Wrong password");
                                continue;
                            }

                        } else {
                            consoleWriter.methodWriter("User not found!");
                            continue;
                        }
                    }
                    case 3:
                        return;
                }
            } else {
                consoleWriter.methodWriter("Hello " + consoleSession.getCurrentUser().getUserName());
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
                        calculator.showHistory().forEach(s -> consoleWriter.methodWriter(s.toString()));
                        continue;
                    }
                    case 3: {
                        return;
                    }
                }
            }
        }
    }
}