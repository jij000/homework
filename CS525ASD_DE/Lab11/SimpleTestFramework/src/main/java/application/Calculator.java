package application;

import framework.Service;

public interface Calculator {
    public void reset();

    public int add(int newValue);

    public int subtract(int newValue);
}
