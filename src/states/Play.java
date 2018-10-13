package states;

import java.awt.Color;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Game;

public class Play extends BasicGameState{
	
	Image randomi;
	
	

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		randomi = new Image("res/images/play.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		g.drawImage(randomi, 100, 10, 500, 100, 0,0,randomi.getWidth(), randomi.getHeight());
		g.drawImage(image, x, y, x2, y2, srcx, srcy, srcx2, srcy2, col);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
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
