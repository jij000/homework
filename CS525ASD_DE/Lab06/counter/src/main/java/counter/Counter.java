package counter;

import counter.status.StepStatus;

import javax.swing.*;
import java.util.Observable;

public class Counter extends Observable {
	
	private int count=0;
	private StepStatus stepStatus;

	public StepStatus getStepStatus() {
		return this.stepStatus;
	}

	public void setStepStatus(StepStatus stepStatus) {
		this.stepStatus = stepStatus;
	}

	public void increment(){
		count = stepStatus.increment(count);
		System.out.println("count=" + count);
		setChanged();
		notifyObservers((Integer) count);
	}
	
	public void decrement(){
		count = stepStatus.decrement(count);
		System.out.println("count=" + count);
		setChanged();
		notifyObservers((Integer) count);
	}

}
