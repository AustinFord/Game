package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Main.GamePanel;
import TileMap.Background;

public class DeathState extends GameState {

	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = { "Restart Level", "Main Menu"};
	

	private Color textColor;
	private Font  textFont;
	
	private String prompt = "Sorry, you died";
	
	
public DeathState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-0.1, 0);
			
			textColor = new Color(0,0,0);
			textFont = new Font("Times New Roman", Font.PLAIN, 14);
			
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void init() {
		
		
	}

	@Override
	public void update() {

		
	}

	@Override
	public void draw(Graphics2D g) {
		// draw bg
		bg.draw(g);
		
		
		
		g.setColor(textColor);
		g.setFont(textFont);
		
		g.drawString( prompt, GamePanel.WIDTH  /2 - g.getFontMetrics().stringWidth(prompt) / 2, 70);
		
		g.setFont(textFont);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 145, 140 + i * 15);
		}
		
		
	}

	private void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if(currentChoice == 1) {
			
			gsm.setState(GameStateManager.MENUSTATE);
		}
		if(currentChoice == 2) {
			System.exit(0);
		}
	}
	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		
	}

	@Override
	public void keyReleased(int k) {
		
	}

}
