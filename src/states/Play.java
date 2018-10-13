package states;

import java.awt.Color;
import java.util.Arrays;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Game;

public class Play extends BasicGameState {

	//int[] data = { 1, 0, 1, 2, 4, 3, 0, 1, 0, 3, 2, 1, 0, 3, 1, 1, 2, 1, 2, 1, 0, 3, 0, 3, 1, 2,4,3,2,4,1,3,2,4,0,3,2,0,2,1,2,3,0,0,1,2,3,0 };
	int[] data = {1,1,1,1};
	boolean start = false;
	int deltaSum = 0;
	int currentTick = 0;
	Image bg;
	int hitY = 706;
	int x1 = 466;
	int x2 = 730;
	int x3 = 994;
	int x4 = 1259;
	int iconSize = 222;
	Image i1, i2, i3, i4;
	int score = 0;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		bg = new Image("res/images/background.png");
		i1 = new Image("res/images/2make-fist.png");
		i2 = new Image("res/images/3spread-fingers.png");
		i3 = new Image("res/images/4wave-left.png");
		i4 = new Image("res/images/5wave-right.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

		g.drawImage(bg, 0, 0, container.getWidth(), container.getHeight(), 0, 0, bg.getWidth(), bg.getHeight());
		g.drawImage(i1, x1, hitY, x1 + iconSize, hitY + iconSize, 0, 0, i1.getWidth(), i1.getHeight());
		g.drawImage(i2, x2, hitY, x2 + iconSize, hitY + iconSize, 0, 0, i2.getWidth(), i2.getHeight());
		g.drawImage(i3, x3, hitY, x3 + iconSize, hitY + iconSize, 0, 0, i3.getWidth(), i3.getHeight());
		g.drawImage(i4, x4, hitY, x4 + iconSize, hitY + iconSize, 0, 0, i4.getWidth(), i4.getHeight());
		int counter = 0;
		for (int i = 0; i < data.length; i++) {
			counter = 0;
			int x = 0;

			switch (data[i]) {
			case 0:
				x = -1000;
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
			int y = (int) (currentTick * 0.3) + hitY - (i * (iconSize + 100)) - 800;
			counter +=1;
			//System.out.println(y);
			Input input = container.getInput();
			g.fillOval(x, y, iconSize, iconSize);
			//System.out.println(x);
			//System.out.println("Hi");
			//System.out.println(y);
			//System.out.println(counter);
			boolean scorecheck = false;
			boolean scorecheck2 = false;
			if (input.isKeyDown(Input.KEY_A)) {
				if (x == 466 && (y>=hitY-20 && y <=hitY+iconSize+20))
				{
					scorecheck = true;
					//System.out.println(y);
					System.out.println("yo");
				}
				//System.out.println(hitY);
				//System.out.println(iconSize);
			}
			else if (input.isKeyDown(Input.KEY_W)) {
				if (x == 730 && (y>=hitY-20 && y <=hitY+iconSize+20))
				{
					scorecheck = true;
					System.out.println("mom");
				}
			}
			else if (input.isKeyDown(Input.KEY_S)) {
				if (x == 994 && (y>=hitY-20 && y <=hitY+iconSize+20))
				{
					scorecheck = true;
					System.out.println("ahoe");
				}
			}
			else if (input.isKeyDown(Input.KEY_D)) {
				if (x == 1259 && (y>=hitY-20 && y <=hitY+iconSize+20))
				{
					scorecheck = true;
					System.out.println(x);
					System.out.println("69");
				}
			}
			if (scorecheck == true)
			{
				score += 20;
				System.out.println("hi");
			}
		}
		System.out.println(score);
		g.drawRect(0,686,1920,262);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_T)) {
			start = true;
		}

		if (start) {
			currentTick += delta;
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
