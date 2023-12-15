package factoryMethod;

public abstract class Operation {
    public Integer numA;
    public Integer numB;

    public Operation(Integer numA, Integer numB) {
        this.numA = numA;
        this.numB = numB;
    }

    public abstract Integer getResult();
}
