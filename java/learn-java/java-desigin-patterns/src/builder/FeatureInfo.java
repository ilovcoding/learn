package builder;

public class FeatureInfo {
    Integer age;
    Integer height;
    Integer weight;
    String phone;

    public FeatureInfo(Integer age, Integer height, Integer weight, String phone) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "FeatureInfo{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", phone='" + phone + '\'' +
                '}';
    }
}
