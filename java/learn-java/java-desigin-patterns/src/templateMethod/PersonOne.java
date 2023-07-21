package templateMethod;

public class PersonOne extends SelfIntroduction{
    @Override
    public void sayName() {
        System.out.println("Second Person Name");
    }

    @Override
    public void sayCountry() {
       System.out.println("Second Person Country");
    }
}
