package states;

import java.awt.Color;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Game;

public class Menu extends BasicGameState{
	
	Image play;
	Image background;
	Image waves;
	Image text;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		play = new Image("res/images/play.png");
		background = new Image("res/images/background.png");
		waves = new Image("res/images/bars.png");
		text = new Image("res/images/TEXT.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		g.drawImage(background, 0, 0, container.getWidth(), container.getHeight(), 0, 0);
		g.drawImage(waves, 628, 330, 628+(waves.getWidth()*2/3),330+waves.getHeight(), 0, 0, waves.getWidth(), waves.getHeight());
		g.drawImage(play, 760, 650, 820, 720, 0, 0, play.getWidth(), play.getHeight());
		g.drawImage(text, 520, 150, 520+ text.getWidth(), 150+text.getHeight(), 0,0,text.getWidth(), text.getHeight());

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		if (container.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			game.enterState(Game.play);
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
		return Game.menu;
	}

}
