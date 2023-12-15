package prototype;

public interface Product<T> extends  Cloneable{
    public abstract void use();
    public abstract T createClone();
}
