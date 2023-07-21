package builder;

public class Builder {
    private BasicInfo basicInfo;
    private FeatureInfo featureInfo;
    private HobbyInfo hobbyInfo;

    public Builder() {
    }

    public Builder(BasicInfo basicInfo, FeatureInfo featureInfo, HobbyInfo hobbyInfo) {
        this.basicInfo = basicInfo;
        this.featureInfo = featureInfo;
        this.hobbyInfo = hobbyInfo;
    }

    public Builder buildBasic(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
        return this;
    }

    public Builder buildFeature(FeatureInfo featureInfo) {
        this.featureInfo = featureInfo;
        return this;
    }

    public Builder buildHobby(HobbyInfo hobbyInfo) {
        this.hobbyInfo = hobbyInfo;
        return this;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "basicInfo=" + basicInfo +
                ", featureInfo=" + featureInfo +
                ", hobbyInfo=" + hobbyInfo +
                '}';
    }
}
