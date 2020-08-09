package counter;

import counter.chainhandler.CounterHandler;
import counter.status.StepStatus;

import javax.swing.*;
import java.util.Observable;

public class Counter extends Observable {
	
	private int count=0;
	private StepStatus stepStatus;
	private CounterHandler counterHandler;
	public StepStatus getStepStatus() {
		return this.stepStatus;
	}

	public void setStepStatus(StepStatus stepStatus) {
		this.stepStatus = stepStatus;
	}

	public void increment(){
		count = stepStatus.increment(count);
		System.out.println("count=" + count);
		counterHandler.handleCounter(this);
		setChanged();
		notifyObservers((Integer) count);
	}
	
	public void decrement(){
		count = stepStatus.decrement(count);
		System.out.println("count=" + count);
		counterHandler.handleCounter(this);
		setChanged();
		notifyObservers((Integer) count);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CounterHandler getCounterHandler() {
		return counterHandler;
	}

	public void setCounterHandler(CounterHandler counterHandler) {
		this.counterHandler = counterHandler;
	}
}
