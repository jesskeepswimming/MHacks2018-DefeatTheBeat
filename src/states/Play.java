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

	int [] intarray = {0,0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,2,2,2,2,2,2,4,4,4,4,4,4};
	//boolean[][] data = {{true,true,true,true},{true,true,true,true},{true,true,true,true},{true,true,true,true},{true,true,true,true},{true,true,true,true},{true,true,true,true},{true,true,true,true}};
	boolean start = false;
	int deltaSum = 0;
	int currentTick = 0;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		boolean key = false;
		/*
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j]) {
					g.fillRect(100 + j * 80, 100 + i * 80 + currentTick * 80, 40, 40);
				}
			}
		}
		*/
		for (int i = 0; i < intarray.length; i++) {
			if (intarray[i] == 1 && key == true)
			{
				
			}
			else if (intarray[i]==2)
			{
				
			}
			else if (intarray[i]==3)
			{
				
			}
			else if (intarray[i]==4)
			{
				
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
		
		if(start && deltaSum >= 500)
		{
			deltaSum -= 500;
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
