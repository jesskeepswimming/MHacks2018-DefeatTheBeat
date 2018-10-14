package states;

import java.awt.Font;
import java.util.Arrays;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.Timer;
import java.util.TimerTask;


import core.Game;

public class Play extends BasicGameState {

	int pointcount=0;
	boolean b1, b2, b3, b4 = false;
	int t1, t2, t3, t4 = 0;
	
	
	private static final org.newdawn.slick.Font Verdana = null;
	
	int[] data;
	int[] circleY;
	boolean start = false;
	int deltaSum = 0;
	int currentTick = 0;
	
	//y coord of top of the hit circles
	int hitY = 706;
	int ahitY = hitY-42;
	
	//pixel difference between array elements
	int indexGap = 15;
	int circleDia = 222;
	
	//location of tracks
	int x1 = 466;
	int x2 = 730;
	int x3 = 994;
	int x4 = 1259;
	int ax1 = x1-42;
	int ax2 = x2-42;
	int ax3 = x3-42;
	int ax4 = x4-42;
	int iconSize = 222;
	int aiconSize = iconSize*138/100;
	int score = 0;
	Image bg, i1, i2, i3, i4, back, tap;
	String songname = "SONG NAME";
	Image a1, a2, a3, a4;
	

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		bg = new Image("res/images/background.png");
		i1 = new Image("res/images/2make-fist.png");
		i2 = new Image("res/images/3spread-fingers.png");
		i3 = new Image("res/images/4wave-left.png");
		i4 = new Image("res/images/5wave-right.png");
		tap = new Image("res/images/1double-tap.png");
		back = new Image("res/images/back.png");

		a1 = new Image("res/images/2glowmake-fist.png");
		a2 = new Image("res/images/3glowspread-fingers.png");
		a3 = new Image("res/images/4glowwave-left.png");
		a4 = new Image("res/images/5glowwave-right.png");
		
		// make sure to derive the size
		try {
			data = beats.getarray("http://ericamwang.com/videoplayback.aif");
			System.out.println(Arrays.toString(data));
		} catch (Exception e) {
			e.printStackTrace();
		}
		generateMetaData();
	}

	// generates values needed to run game based of inputed beat map
	public void generateMetaData() {
		circleY = new int[data.length];

		for (int i = 0; i < data.length; i++) {
			circleY[i] = 0 - i * indexGap;
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

		g.drawImage(bg, 0, 0, container.getWidth(), container.getHeight(), 0, 0, bg.getWidth(), bg.getHeight());
		g.drawImage(back, 60, 90, 50 + (back.getWidth() * 1 / 9), 80 + (back.getHeight() * 1 / 9), 0, 0,
				back.getWidth(), back.getHeight());
		g.drawImage(tap, 130, 60, 130 + (tap.getWidth() * 2 / 3), 60 + (tap.getHeight() * 2 / 3), 0, 0, tap.getWidth(),
				tap.getHeight());

		g.setFont(Game.title);
		g.drawString("NOW PLAYING:", 1380, 120);
		g.setFont(Game.text);
		g.drawString(songname, 1380, 190);
		
		if(!b1) {
			g.drawImage(i1, x1, hitY, x1 + iconSize, hitY + iconSize, 0, 0, i1.getWidth(), i1.getHeight());			
		}
		else {
        	g.drawImage(a1, ax1, ahitY, ax1 + aiconSize, ahitY + aiconSize, 0, 0, a1.getWidth(), a1.getHeight());
		}
		
		if(!b2) {
			g.drawImage(i2, x2, hitY, x2 + iconSize, hitY + iconSize, 0, 0, i2.getWidth(), i2.getHeight());
		} else {
        	g.drawImage(a2, ax2, ahitY, ax2 + aiconSize, ahitY + aiconSize, 0, 0, a2.getWidth(), a2.getHeight());
		}
		
		if(!b3) {
			g.drawImage(i3, x3, hitY, x3 + iconSize, hitY + iconSize, 0, 0, i3.getWidth(), i3.getHeight());
		} else {
        	g.drawImage(a3, ax3, ahitY, ax3 + aiconSize, ahitY + aiconSize, 0, 0, a3.getWidth(), a3.getHeight());
		}
		
		if(!b4) {
			g.drawImage(i4, x4, hitY, x4 + iconSize, hitY + iconSize, 0, 0, i4.getWidth(), i4.getHeight());			
		} else {
        	g.drawImage(a4, ax4, ahitY, ax4 + aiconSize, ahitY + aiconSize, 0, 0, a4.getWidth(), a4.getHeight());
		}
		
		for (int i = 0; i < data.length; i++) {

			int x = 0;

			switch (data[i]) {
			case 0:
				//draw off screen
				x = -69420;
				break;
			case 1:
				x = x1;
				break;
			case 2:
				x = x2;
				break;
			case 3:
				x = x3;
				break;
			case 4:
				x = x4;
				break;
			default:
				break;
			}

			g.fillOval(x, circleY[i], circleDia, circleDia);
		}

	}

	private Font Font(String string, int plain, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
		int distance = indexGap * delta / 100;
			
		for (int i = 0; i < circleY.length; i++) {
			
			circleY[i] += distance;
		}
		
		
		if(container.getInput().isKeyDown(Input.KEY_Y)) { //change code
			b1 = true;
			t1 = 1000;
		}	
		if(t1 > 0)	{
			t1 -= delta;
		} else {
			b1 = false;
		}
		
		
		if(container.getInput().isKeyDown(Input.KEY_U)) { //change code
			b2 = true;
			t2 = 1000;
		}
		if(t2 > 0)	{
			t2 -= delta;
		} else {
			b2 = false;
		}
		
		if(container.getInput().isKeyDown(Input.KEY_I)) { //change code
			b3 = true;
			t3 = 1000;
		}
		if(t3 > 0)	{
			t3 -= delta;
		} else {
			b3 = false;
		}
		
		if(container.getInput().isKeyDown(Input.KEY_O)) { //change code
			b4 = true;
			t4 = 1000;
		}
		if(t4 > 0)	{
			t4 -= delta;
		} else {
			b4 = false;
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Game.play;
	}

}
