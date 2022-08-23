package dev.ammar.load;

 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HelloWorld {
	private String helloWorld = "> Hello, World!" 
			+ "type any thing and then press 'Enter' to continue ";
	private int x = 80;
	private int y = 120;
	private int length, l;
	boolean color = false;
	String check;
	
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		if(!color)
		g2d.setColor(Color.GREEN);
		else 
			g2d.setColor(Color.BLACK);
			
		g.setFont(new Font("Monospaced", Font.PLAIN, 11));
		g2d.drawLine(x  ,y,x+10  ,y);
		g2d.setColor(Color.GREEN);
		for (int i = 0; i < l; i++) {
			
			
			
			if(i >= 15) {y=140;x=40+length*6;}
			else {x=80+length*6; y=120;}
			
			///Wrappring
		 
			 check = helloWorld.substring(65,helloWorld.length() );
			 System.err.println((int) ( g2d.getFontMetrics().stringWidth(helloWorld) - g2d.getFontMetrics().stringWidth(helloWorld.substring(0,14) )+ 120)  );
			 if(i>=65&&(int) ( g2d.getFontMetrics().stringWidth(helloWorld) - g2d.getFontMetrics().stringWidth(helloWorld.substring(0,14) )+ 120)> 500 )
			 { 
				 y+=20;
				 length = 15;
				  
				 
			 	  
			 }
			  
				 
				 	System.out.println(53);
				 	if(l<helloWorld.length() )
				 	g2d.drawString( helloWorld.charAt(i)+"", x - l*6+i*6, y);
			}
		}	
		 
		
		
 
	public void tick()
	{
		
		if(length+1<helloWorld.length()) {
		x+=6;
		length++;l++;}
		else {
			color =!color; 
			 
		}
	 
	}
	public void appendText(String text)
	{
		helloWorld+=text;
	}

}
