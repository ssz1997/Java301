package multithread;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cards extends Applet{
	Button start;
	Label card, pone, ptwo, pthree, pfour;
	Checkbox synch;
	int total = 52;
	Player player1, player2, player3, player4;
	Thread tplayer1, tplayer2, tplayer3, tplayer4;
	Counter deck;
	int one, two, three, four;
	
	public void init(){
		super.init();
		setLayout(null);
		setBackground(Color.lightGray);
		start = new Button("Start");
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (player1 == null && player2 == null && player3 == null && player4 == null){
					go();				
				}
				else if (!tplayer1.isAlive() && !tplayer2.isAlive() && !tplayer3.isAlive() && !tplayer4.isAlive()){
					go();
				}
			}
		});
		add(start);
		start.setBounds(80,155,40,20);
		synch = new Checkbox("Synchronize");
		add(synch);
		synch.setBounds(120, 170, 80,20);
		card = new Label("Cards");
		add(card);
		card.setBounds(80,55,40,20);
		pone = new Label("Player 1");
		ptwo = new Label("Player 2");
		pthree = new Label("Player 3");
		pfour = new Label("Player 4");
		add(pone);
		add(ptwo);
		add(pthree);
		add(pfour);
		pone.setBounds(75, 0, 55, 20);
		ptwo.setBounds(0, 55, 55, 20);
		pthree.setBounds(75, 130, 55, 20);
		pfour.setBounds(150, 55, 55, 20);
	}
    
	public void go(){
		if (!synch.getState()){
			deck = new Counter(this);
		}
		else{
			deck = new SyncCounter(this);
		}
		player1 = new Player(this, 1, deck);
		tplayer1 = new Thread(player1);
		player2 = new Player(this, 2, deck);
		tplayer2 = new Thread(player2);
		player3 = new Player(this, 3, deck);
		tplayer3 = new Thread(player3);
		player4 = new Player(this, 4, deck);
		tplayer4 = new Thread(player4);
		tplayer1.start();
		tplayer2.start();
		tplayer3.start();
		tplayer4.start();
		
	}
	
	public void setValue(int player, int i){
		switch(player){
		case 1: one = i; break;
		case 2: two = i; break;
		case 3: three = i; break;
		default: four = i; break;
		}
	}
	
	public void setTotal(int i){
		this.total = i;
	}

    public void paint(Graphics g){
    	super.paint(g);
    	g.drawString(String.valueOf(one), 90, 35);
    	g.drawString(String.valueOf(two), 20, 90);
    	g.drawString(String.valueOf(three), 90, 120);
    	g.drawString(String.valueOf(four), 160, 90);
    	g.drawString(String.valueOf(total), 90, 90);
    }
	
}

