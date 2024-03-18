package impl;

import util.Incrementer;

public class AtomicIncrementer implements Incrementer {
    private int temp;
    //TODO: implement
    public AtomicIncrementer(int startValue) {
        //TODO: implement, do not change the signature!
        this.temp = startValue;
    }

    @Override
    public synchronized void increment() {
        temp += 1;
    }

    @Override
    public synchronized void incrementBy(int amount) {
        temp += amount;
    }

    @Override
    public synchronized int incrementAndGet() {
        temp += 1;
        return temp;
    }

    @Override
    public synchronized int getandIncrement() {
        int value = temp;
        temp += 1;
        return value;
    }

    @Override
    public synchronized int getValue() {
        return temp;
    }

    @Override
    public synchronized int resetValue() {
        int value = temp;
        temp = 0;
        return value;
    }

    @Override
    public synchronized int setValue(int newValue) {
        int old = temp;
        temp = newValue;
        return old;
    }
}
