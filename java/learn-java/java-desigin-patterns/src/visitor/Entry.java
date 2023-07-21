package visitor;

import java.util.Iterator;

public abstract class Entry implements Element{
    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatMentException {
           throw new FileTreatMentException();
    }

    public Iterator iterator() throws FileTreatMentException {
        throw new FileTreatMentException();
    }

    @Override
    public String toString() {
        return getName() + "("+getSize()+")";
    }
}
