package factoryMethod;

public class AddOperation extends Operation {
    public AddOperation(Integer numA, Integer numB) {
        super(numA, numB);
    }

    @Override
    public Integer getResult() {
        return this.numA + this.numB;
    }
}
