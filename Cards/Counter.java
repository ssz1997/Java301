package multithread;

public class Counter {
    int deck = 52;
    Cards cards;
    
    public Counter(Cards cards){
    	this.cards = cards;
    }
    
    public void decrement(){
    	int temp = deck;
    	//Simulate.HWinterrupt();
    	deck = temp - 1;
    	cards.setTotal(deck);
    }
}

class Simulate{
	public static void HWinterrupt(){
		if (Math.random()<0.5){
			try{Thread.sleep(200);}catch(InterruptedException e){};
		}
	}
}
