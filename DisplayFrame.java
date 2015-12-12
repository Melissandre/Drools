package com.sample;

public class DisplayFrame implements Runnable {
	public DisplayFrame() {
		
	}
	
	public void setQuestionGoal (String nazwa) {
		NewJFrame frame = new NewJFrame(nazwa,new String[] {});
		frame.setVisible(true);
	}
	
	public void setQuestionB (String nazwaPytania, String[] lista) {
		FrameWithButtons fr = new FrameWithButtons();
		fr.wyswietl(nazwaPytania, lista);
		while(fr.counter < 1) {
			waiting(100);
		}
	}
	
	public String getChosen() {
		return DroolsTest.chosen;
	}
	
	public void waiting(int miliseconds){
    	try {
    	Thread.sleep( miliseconds);
    	}
    	catch (InterruptedException e) {}	
    	}
	
	public void run() {
		
	}
}
