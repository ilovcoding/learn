package abstractFactory.science;

public class AddScienceOperation extends ScienceOperation {
    public AddScienceOperation(Double numA, Double numB) {
        super(numA, numB);
    }

    @Override
    public Double getResult() {
        return this.numA + this.numB;
    }
}
