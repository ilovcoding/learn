package templateMethod;

public class PersonTwo extends SelfIntroduction {

    @Override
    public void sayName() {
        System.out.println("First Person Name");
    }

    @Override
    public void sayCountry() {
        System.out.println("First Person Country");
    }
}
