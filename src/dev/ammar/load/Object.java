package dev.ammar.load;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Object {
	private double x;
	private double y;
	private float angle=160;
	private int thickness;
	private int mid;
	private double oldx;
	private double oldy;
	public boolean visible;
	
	 

	public Object (int x, int y, int width )
	{
		this.x = x;
		this.y = y;
		mid = width/2;
		thickness = 6;

	}
	public void render(Graphics g)
	{
	    Graphics2D  g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(thickness));

		g2.drawLine((int)x,(int)y,(int)oldx,(int)oldy); 
	}
	public void tick() {
		oldx = x;
		oldy = y; 
		x = Math.cos(angle/57.2957795)*mid+250;
		y = Math.sin(angle/57.2957795)*mid+250;
		angle+=6;
 		
		 
			mid-=2;
	}
	public void changeMid() {
		if(thickness>1)
		thickness-=2;
	}

}
