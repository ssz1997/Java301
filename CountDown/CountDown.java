package thread;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountDown extends Applet implements ActionListener, Runnable{
	Font f = new Font("TimesRoman", Font.BOLD, 24);
	Thread runner;
	int i = 10;
	boolean running;
	Button resume, restart, pulse, stop;
	
	public void init() {
	    this.setLayout(null);	
	    resume = new Button("Resume");
	    add(resume);
	    resume.setBounds(120, 130, 60, 20);
	    restart = new Button("Start");
	    add(restart);
	    restart.setBounds(120, 160, 60, 20);
	    pulse = new Button("Pulse");
	    add(pulse);
	    pulse.setBounds(20, 130, 60, 20 );
	    stop = new Button("Stop");
	    add(stop);
	    stop.setBounds(20, 160, 60, 20);
	    
	    resume.addActionListener(this);
	    pulse.addActionListener(this);
	    stop.addActionListener(this);
	    restart.addActionListener(this);
	    
	}
	
	public void start() {
		if (runner == null) {
			runner = new Thread(this);
			runner.start();
			running = true;
		}
	}
    
	public void stop() {
		if (runner != null) {
			runner.stop();
			runner = null;
			i = 10;
			running = false;
		}
	}
	
	public void pulse() {
		runner.stop();
		runner = null;
		running = false;
	}
	
	public void resume() {
		runner = new Thread(this);
		runner.start();
		running = true;
		
	}
	
	public void restart() {
		i = 10;
		stop();
		start();
		
	}
	
	public void run() {
		while (i >= 0) {
			repaint();
			try {Thread.sleep(1000);}
			catch (InterruptedException e) {}
			i --;
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(f);
		g.drawString("Count Down", 30, 50);
		g.drawString(String.valueOf(i), 90, 100);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == stop) {
			stop();
		}
		else if (e.getSource() == pulse) {
			pulse();
		}
		else if (e.getSource() == resume) {
			resume();
		}
		else if (e.getSource() == restart) {
			restart();
		}
		
	}
}
