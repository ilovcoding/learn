package abstractFactory.simple;

public abstract class SimpleOperation {
    public Integer numA;
    public Integer numB;

    public SimpleOperation(Integer numA, Integer numB) {
        this.numA = numA;
        this.numB = numB;
    }

    public abstract Integer getResult();
}
