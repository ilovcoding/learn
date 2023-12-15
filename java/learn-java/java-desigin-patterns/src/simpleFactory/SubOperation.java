package simpleFactory;

public class SubOperation extends Operation{
    public SubOperation(Integer numA, Integer numB) {
        super(numA, numB);
    }

    @Override
    public Integer getResult() {
        return this.numA - this.numB;
    }
}
