package dev.ammar.load;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
 
 

import dev.ammar.load.display.Display;
import dev.ammar.load.input.KeyManager;

public class Player implements Runnable{
	private final static int WIDTH = 500,
							 HEIGHT = 500;
	private boolean running;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private Display display;
	private Thread thread;
	int count = 0;
	private Object[] object;
	private HelloWorld helloWorld;
	private KeyManager keyManager;
	private int fCount;
	
	public Player()
	{
		display = new Display(WIDTH, HEIGHT);
		object = new Object[10];
		for (int i = 0; i < object.length; i++) {
			
			object[i] = new Object(30,HEIGHT-10,WIDTH);
		}	
		object[0].visible = true;
		
		helloWorld = new HelloWorld();
		keyManager = new KeyManager(helloWorld);
		display.getCanvas().addKeyListener(keyManager);
		display.getFrame().addKeyListener(keyManager);
	}
	public void render()
	{
		 
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {display.getCanvas().createBufferStrategy(3);return;}
		g = bs.getDrawGraphics();
		 
		//////////
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(fCount<500)
	 	for (int i = 0; i < object.length; i++) {
			g.setColor(Color.WHITE);
			if(object[i].visible) {
			object[i].render(g);
			object[i].tick();
			}
		} 
		
		else
			helloWorld.render(g);
		
		//
		bs.show();
		g.dispose();
	}
	@Override
	public void run()
	{
		 int fps = 60;
	        double timePerTick = 1000000000 / fps;
	        double dalta = 0;
	        long now;
	        long lastTime = System.nanoTime();
	        int counter = 0;
	        while(running)
	        {
	            now = System.nanoTime();
	            dalta += (now - lastTime) / timePerTick;
	            lastTime = now;
	            if(dalta >=1)
	            {
	                  
	                    render();
	                     
	                dalta--;
	                counter++;
	                fCount++;
	                if(counter>=8) {//4
	                	//tick();
	                	counter = 0;
	                	 
	            		count++;
	            		if(count==10)count=0;
	                	 object[count].visible = true;
	                	 if(fCount>=500)
	                		 helloWorld.tick();
	                }
	            }
 	  
	        }
	         
	}
	
	private void tick() {
		 object[count].changeMid();
		
	}
	
	public synchronized void start()
	{
		if(running)return;
		thread = new Thread(this);
		running = true;
		thread.start();
	}
	public synchronized void stop() throws InterruptedException
	{
		if(!running)return;
		thread.join();
		running = false;
	}
	
	
	
}
