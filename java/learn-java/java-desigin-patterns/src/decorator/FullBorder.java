package decorator;

public class FullBorder extends Border{
    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return 1+ display.getColumns()+ 1;
    }

    @Override
    public int getRows() {
        return 1+ display.getRows()+ 1;
    }

    @Override
    public String getRowText(int row) {
        if(row == 0){
//         上边框
            return "+"+ printLine('-', display.getColumns())+"+";
        }else if (row == display.getRows()+1){
//        下边框
            return "+"+ printLine('-', display.getColumns())+"+";
        }
        return "|"+ display.getRowText(row-1) +"|";
    }
    private String printLine(char ch, int count){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buffer.append(ch);
        }
        return buffer.toString();
    }
}
