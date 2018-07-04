package multithread;

public class Player implements Runnable {
	
	Cards cards;
	int index;
	int i;
	Counter counter;
	
    public Player(Cards cards, int index, Counter counter){
    	this.cards = cards;
    	this.index = index;
    	this.counter = counter;
    }
	@Override
	public void run() {
		try{
			cards.setValue(index, 0);
			for (i = 1; i <= 13; i++){
				Thread.sleep(250);
				cards.setValue(index, i);
				counter.decrement();
				cards.repaint();
			}
		}
		catch(InterruptedException e){}
	}

}
