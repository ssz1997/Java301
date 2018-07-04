package multithread;

public class SyncCounter extends Counter {
	
	public SyncCounter(Cards cards){
		super(cards);
	}

	public synchronized void decrement(){
		super.decrement();
	}
}
