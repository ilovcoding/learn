package state;

public class StateFrame implements Context{
    private State state = DayState.getInstance();
    private int hour = 0;
    @Override
    public void setClock(int hour) {
        this.hour = hour;
        state.doClock(this,hour);
    }

    @Override
    public void changeState(State state) {
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        System.out.println(msg);
    }

    @Override
    public void recordLog(String msg) {
        System.out.println(msg);
    }
    public void use(){
        System.out.println("当前时间是"+hour+"，状态是："+ state);
        state.doUse(this);
        state.doAlarm(this);
        state.doPhone(this);
    }
}
