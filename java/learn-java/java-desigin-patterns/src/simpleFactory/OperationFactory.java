package simpleFactory;

public class OperationFactory {
    public static Operation createOperation(String operate,Integer num1,Integer num2){
        Operation operation;
        switch (operate)
        {
            case "+":
                operation = new AddOperation(num1,num2);
                return operation;
            case "-":
                operation = new SubOperation(num1,num2);
                return operation;
        }
        return null;
    }
}
