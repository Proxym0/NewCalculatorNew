package console;

import entity.Operation;
import entity.User;
import service.CalculatorService;
import service.UserService;
import validator.UserValidator;

import java.util.Optional;

import static console.Reader.*;
import static console.Writer.methodWriter;


public class ConsoleApplication extends Thread {

    private final CalculatorService calculator = new CalculatorService();
    UserService userService = new UserService();
    ConsoleSession consoleSession;

    public ConsoleApplication() {
        setName("ConsoleApplicationThread");
    }

    public void run() {
        while (true) {
            if (consoleSession == null) {
                methodWriter("Welcome to Calculator.\nPlease select an operation \n1.Registration 2.Entrance 3.Exit");
                int i = readInteger();
                switch (i) {
                    case 1: {
                        methodWriter("Enter your name ");
                        String firstName = readString();
                        methodWriter("Enter your nickname ");
                        String userName = readString();
                        if (!UserValidator.isValidUsername(userName)) {
                            continue;
                        }
                        methodWriter("Enter password");
                        String password = readString();
                        if (UserValidator.isValidPassword(password)) {
                            continue;
                        }
                        User user = new User(firstName, userName, password);
                        userService.create(user);
                        break;
                    }
                    case 2: {
                        methodWriter("Enter your nickname ");
                        String userName1 = readString();
                        methodWriter("Enter password");
                        String password1 = readString();
                        Optional<User> byUserName = userService.findByUserName(userName1);
                        if (byUserName.isPresent()) {
                            User user1 = byUserName.get();
                            if (user1.getPassword().equals(password1)) {
                                consoleSession = new ConsoleSession(user1);
                                continue;
                            } else {
                                methodWriter("Wrong password");
                                continue;
                            }

                        } else {
                            methodWriter("User not found!");
                            continue;
                        }
                    }
                    case 3:
                        return;
                }
            } else {
                methodWriter("Hello " + consoleSession.getCurrentUser().getUserName());
                methodWriter("Choose the type of operation.\n1.Calculator \n2.History output \n3.Exit");
                int i = readInteger();
                switch (i) {
                    case 1 -> {
                        {
                            methodWriter("Enter number 1");
                            double a = readDouble();
                            methodWriter("Enter number 2");
                            double b = readDouble();
                            methodWriter("Enter type");
                            String operationType = readString();
                            Operation operation = new Operation(a, b, operationType);
                            Optional<Operation> result = calculator.calculator(operation);
                            methodWriter("Result " + result);
                        }
                        continue;
                    }
                    case 2 -> {
                        calculator.showHistory().forEach(s -> methodWriter(s.toString()));
                        continue;
                    }
                    case 3 -> {
                        return;
                    }
                }
            }
        }
    }
}