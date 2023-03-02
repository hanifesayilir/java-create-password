package sample;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Originator {
    private volatile String state;
    private Memento memento = new Memento();

    public Originator(String state) {
        this.state = state;
        memento.setOriginator(this);
    }

    public String getState() {
        return state;
    }

    public Memento getMemento() {
        return memento;
    }

    public String toString() {
        return "Originator [state= " + state + "]";
    }

    public void setState(String previousState) {
        this.state = previousState;
    }
}
