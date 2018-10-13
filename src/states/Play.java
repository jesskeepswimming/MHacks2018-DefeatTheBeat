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

public class Play extends BasicGameState{

	int[] data = {1,1,1,1,2,2,2,2,3,3,3,3,0,0,0,0,1,1,1,1,0,0,0,0,2,2,2};
	boolean start = false;
	int deltaSum = 0;
	int currentTick = 0;
	Image bg;
	int hitY = 700;
	int x1 = 100;
	int x2 = 200;
	int x3 = 300;
	int x4 = 400;
	Image i1, i2, i3, i4;

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
		g.drawImage(i1, x1, hitY, x1 + 80, hitY + 80, 0, 0, i1.getWidth(), i1.getHeight());
		g.drawImage(i2, x2, hitY, x2 + 80, hitY + 80, 0, 0, i2.getWidth(), i2.getHeight());
		g.drawImage(i3, x3, hitY, x3 + 80, hitY + 80, 0, 0, i3.getWidth(), i3.getHeight());
		g.drawImage(i4, x4, hitY, x4 + 80, hitY + 80, 0, 0, i4.getWidth(), i4.getHeight());
		}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
		Input input = container.getInput();
		if(input.isKeyDown(Input.KEY_T))
		{
			start = true;
		}
		
		
		deltaSum += delta;
		
		if(start && deltaSum >= 1000)
		{
			deltaSum -= 1000;
			currentTick++;
		}
	}
	
	@Override
	public void keyPressed(int key, char c) {
		// TODO Auto-generated method stub
		super.keyPressed(key, c);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Game.play;
	}

}
