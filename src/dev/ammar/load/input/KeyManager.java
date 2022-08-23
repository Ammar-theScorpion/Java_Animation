package dev.ammar.load.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.ammar.load.HelloWorld;

public class KeyManager implements KeyListener{

	 
	private HelloWorld helloWorld;
	public KeyManager(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		helloWorld.appendText(e.getKeyChar()+"");
	 
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
 
	

}
