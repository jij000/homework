package counter;

import javax.swing.*;
import java.util.Observable;

public class Counter extends Observable {
	
	private int count=0;

	public void increment(){
		count++;
		setChanged();
		notifyObservers((Integer) count);
	}
	
	public void decrement(){
		count--;
		setChanged();
		notifyObservers((Integer) count);
	}

}
