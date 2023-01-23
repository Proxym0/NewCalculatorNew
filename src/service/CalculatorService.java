package service;
import entity.Operation;
import java.util.Optional;

public class CalculatorService implements Calculotor {

    public Optional<Operation> calculator(Operation operation){

        switch (operation.getType()){
            case "sum":
                double sum=methodSum(operation.getNum1(),operation.getNum2());
                operation.setResult(sum);
                return Optional.of(operation);
            case "sub":
                double sub=methodSub(operation.getNum1(),operation.getNum2());
                operation.setResult(sub);
                return Optional.of(operation);
            case "mult":
                double mult=methodMult(operation.getNum1(),operation.getNum2());
                operation.setResult(mult);
                return Optional.of(operation);
            case "div":
                double div=methodDiv(operation.getNum1(),operation.getNum2());
                operation.setResult(div);
                return Optional.of(operation);
        }
        return Optional.empty();
    }
    public double methodSum(double a,double b){ return  a+b; }
    public double methodSub(double a,double b){ return  a-b; }
    public double methodMult(double a,double b){ return  a*b;}
    public double methodDiv(double a,double b){ return  a/b; }
}
