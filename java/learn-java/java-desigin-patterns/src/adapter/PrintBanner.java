package adapter;

public class PrintBanner extends  Print{
    private Banner banner;

    public PrintBanner(Banner banner) {
        this.banner = banner;
    }

    @Override
    public void printWidthParen() {
        banner.showWidthParen();
    }

    @Override
    public void printWidthAster() {
        banner.showWithAster();
    }
}
