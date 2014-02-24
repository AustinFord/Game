package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Main.GamePanel;
import TileMap.Background;

public class HelpState extends GameState{
	
	private Background bg;
	
	private Color titleColor;
	private Font titleFont;
	
	
	
	private Color textColor;
	private Font  textFont;
	
	private  String menuName = "Help";
	
	
public HelpState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font(
					"Times New Roman",
					Font.PLAIN,
					28);
			
			textColor = new Color(0,0,0);
			textFont = new Font("Times New Roman", Font.PLAIN, 14);
			
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		bg.update();
		
	}

	@Override
	public void draw(Graphics2D g) {
		// draw bg
				bg.draw(g);
				
				// draw title
				g.setColor(titleColor);
				g.setFont(titleFont);
				g.drawString(menuName, GamePanel.WIDTH  /2 - g.getFontMetrics().stringWidth(menuName) / 2, 70);
				
				
				g.setColor(textColor);
				g.setFont(textFont);
				
				g.drawString("Hello, welcome to our game. If you would", 50, 100);
				g.drawString("like to return to the previous menu, press", 50, 120);
				g.drawString("enter.", 50, 140);
				g.drawString("Created By: ", 50, 160);
				g.drawString("Austin Ford and Wesley Carlsen", 50, 180);
				
				
								
				
		
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			gsm.setState(gsm.MENUSTATE);
		}
	}

	@Override
	public void keyReleased(int k) {
		
		
	}

}
