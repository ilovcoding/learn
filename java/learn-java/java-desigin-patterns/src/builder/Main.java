package builder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> str1 = new ArrayList<>();
        str1.add("run");
        ArrayList<String> str2 = new ArrayList<>();
        str2.add("meat");
//        传统的对象初始化
        Builder infoOnce = new Builder(
                new BasicInfo("zs", "111"),
                new FeatureInfo(18, 1, 1, "123"),
                new HobbyInfo(
                        str1,
                        str2
                ));
        System.out.println(infoOnce);
        System.out.println("\n");

//        采用了 builder 模式的对象初始化;
        Builder infoBuilder = new Builder();
        infoBuilder = infoBuilder.buildBasic(new BasicInfo("11", "22"));
        System.out.println(infoBuilder);
        infoBuilder = infoBuilder.buildFeature(new FeatureInfo(12, 2, 2, "456"));
        System.out.println(infoBuilder);
        infoBuilder.buildHobby(new HobbyInfo(str1, str2));
        System.out.println(infoBuilder);
    }
}
