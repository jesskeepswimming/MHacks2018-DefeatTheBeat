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

	boolean[][] data = {{true,false,false,true},{false,false,false,false},{false,false,false,true},{true,true,false,true},{true,false,false,true},{true,false,false,true},{false,false,false,false},{true,true,true,true}};
	boolean start = false;
	int deltaSum = 0;
	int currentTick = 0;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j]) {
					g.fillRect(100 + i * 80, 100 + j * 80 + currentTick * 80, 40, 40);
				}
			}
		}
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
