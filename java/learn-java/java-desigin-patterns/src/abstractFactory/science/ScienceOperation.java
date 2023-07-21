package abstractFactory.science;

public abstract class ScienceOperation {
    public Double numA;
    public Double numB;

    public ScienceOperation(Double numA, Double numB) {
        this.numA = numA;
        this.numB = numB;
    }

    public abstract Double getResult();
}
