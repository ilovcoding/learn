package builder;

public class BasicInfo {
    String username;
    String password;

    public BasicInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "BasicInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
