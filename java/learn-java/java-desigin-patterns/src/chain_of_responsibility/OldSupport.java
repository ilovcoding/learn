package chain_of_responsibility;

public class OldSupport extends Support{
    public OldSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() % 2 == 1 ){
         return  true;
        }else {
            return false;
        }
    }
}
