public class Calculator {

    public Operation calculator(Operation operation){

        switch (operation.getType()){
            case "sum":
                double sum=methodSum(operation.getNum1(),operation.getNum2());
                operation.setResult(sum);
                return operation;
            case "sub":
                double sub=methodSub(operation.getNum1(),operation.getNum2());
                operation.setResult(sub);
                return operation;
            case "mult":
                double mult=methodMult(operation.getNum1(),operation.getNum2());
                operation.setResult(mult);
                return operation;
            case "div":
                double div=methodDiv(operation.getNum1(),operation.getNum2());
                operation.setResult(div);
                return operation;
        }
        return null;
    }
    public  static  double methodSum(double a,double b){ return  a+b;}
    public  static  double methodSub(double a,double b){
        return  a-b;
    }
    public  static  double methodMult(double a,double b){
        return  a*b;
    }
    public  static  double methodDiv(double a,double b){
        return  a/b;
    }
}
