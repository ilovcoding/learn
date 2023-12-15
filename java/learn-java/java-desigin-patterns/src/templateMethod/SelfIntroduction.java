package templateMethod;

public abstract class SelfIntroduction {
    public  abstract void sayName();
    public  abstract void sayCountry();
    public final void say(){
        System.out.println("------self-introduction start-----------");
        sayName();
        sayCountry();
        System.out.println("------self-introduction end-------------\n");
    }
}
