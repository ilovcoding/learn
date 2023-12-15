package abstractFactory.simple;

public class AddOperation extends SimpleOperation {
    public AddOperation(Integer numA, Integer numB) {
        super(numA, numB);
    }

    @Override
    public Integer getResult() {
        return this.numA + this.numB;
    }
}
