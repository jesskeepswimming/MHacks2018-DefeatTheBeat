package states;

import java.awt.Font;
import java.util.Arrays;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Game;

public class Play extends BasicGameState {

	private static final org.newdawn.slick.Font Verdana = null;
	
	int[] data;
	int[] circleY;
	boolean start = false;
	int deltaSum = 0;
	int currentTick = 0;
	
	//y coord of top of the hit circles
	int hitY = 706;
	
	//pixel difference between array elements
	int indexGap = 15;
	int circleDia = 222;
	
	//location of tracks
	int x1 = 466;
	int x2 = 730;
	int x3 = 994;
	int x4 = 1259;
	int iconSize = 222;
	int score = 0;
	Image bg, i1, i2, i3, i4, back, tap;
	Music main;
	String songname = "SONG NAME";

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		bg = new Image("res/images/background.png");
		i1 = new Image("res/images/2make-fist.png");
		i2 = new Image("res/images/3spread-fingers.png");
		i3 = new Image("res/images/4wave-left.png");
		i4 = new Image("res/images/5wave-right.png");
		tap = new Image("res/images/1double-tap.png");
		back = new Image("res/images/back.png");
		
		main = new Music("songs/sandstorm.ogg");

		// make sure to derive the size
		try {
			data = beats.getarray();
			//System.out.println(Arrays.toString(data));
		} catch (Exception e) {
			e.printStackTrace();
		}
		generateMetaData();
		
		main.play();
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

		g.drawImage(i1, x1, hitY, x1 + iconSize, hitY + iconSize, 0, 0, i1.getWidth(), i1.getHeight());
		g.drawImage(i2, x2, hitY, x2 + iconSize, hitY + iconSize, 0, 0, i2.getWidth(), i2.getHeight());
		g.drawImage(i3, x3, hitY, x3 + iconSize, hitY + iconSize, 0, 0, i3.getWidth(), i3.getHeight());
		g.drawImage(i4, x4, hitY, x4 + iconSize, hitY + iconSize, 0, 0, i4.getWidth(), i4.getHeight());
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
			Input input = container.getInput();
			boolean scorecheck = false;
			if (input.isKeyDown(Input.KEY_A)) {
				if (data[i] == 1 && (circleY[i]>=hitY-20 && circleY[i] <=hitY+iconSize+20))
				{
					scorecheck = true;
					System.out.println("a");
				}
			}
			else if (input.isKeyDown(Input.KEY_W)) {
				if (data[i] == 2 && (circleY[i]>=hitY-20 && circleY[i] <=hitY+iconSize+20))
				{
					scorecheck = true;
					System.out.println("b");
				}
			}
			else if (input.isKeyDown(Input.KEY_S)) {
				if (data[i] == 3 && (circleY[i]>=hitY-20 && circleY[i] <=hitY+iconSize+20))
				{
					scorecheck = true;
					System.out.println("c");
				}
			}
			else if (input.isKeyDown(Input.KEY_D)) {
				if (data[i] == 4 && (circleY[i]>=hitY-20 && circleY[i] <=hitY+iconSize+20))
				{
					scorecheck = true;
					System.out.println("d");
				}
			}

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
	}

	@Override
	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);
	}

	@Override
	public int getID() {
		return Game.play;
	}

}
