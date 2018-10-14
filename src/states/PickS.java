package states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import core.Game;

public class PickS extends BasicGameState{
	
	Image play;
	Image background;
	Image tap;
	Image logo;
	Image choose;
	Image back;
	Image rightglow, leftglow;
	String songs[] = {"Darude - Sandstorm.ogg",
			"Digital Insanity - Welcome to our world.ogg",
			"Lil Pump -  Gucci Gang.ogg",
			"Luis Fonsi - Despacito.ogg",
			"Neil Diamond - Sweet Caroline.ogg",
			"Smash Mouth - All Star.ogg",
			"The Black Eyed Peas - I Gotta Feeling.ogg",
			"Toto - Africa.ogg",
			"Twice - Knock Knock.ogg",
			"We are #1.ogg"};
	int songcounter = 0;
	int left, right = 3;
	boolean l, r;
	

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		play = new Image("res/images/play.png");
		background = new Image("res/images/background.png");
		back = new Image("res/images/back.png");
		logo = new Image("res/images/logo.png");
		tap = new Image("res/images/1double-tapinv.png");
		choose = new Image("res/images/choosesong.png");
		rightglow = new Image("res/images/5glowwave-right.png");
		leftglow = new Image("res/images/4glowwave-left.png");
			
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		int mid = container.getWidth()/2;
		int glowsize = rightglow.getWidth();

		g.drawImage(background, 0, 0, mid*2, container.getHeight(), 0, 0);
		g.drawImage(back, 60, 90, 50 + (back.getWidth() * 1 / 9), 80 + (back.getHeight() * 1 / 9), 0, 0,
				back.getWidth(), back.getHeight());
		g.drawImage(tap, 130, 60, 130 + (tap.getWidth() * 2 / 3), 60 + (tap.getHeight() * 2 / 3), 0, 0, tap.getWidth(),
				tap.getHeight());
		g.drawImage(choose, mid-choose.getWidth()*4/10, 300, (mid-choose.getWidth()*4/10)+choose.getWidth()*4/5,300+(choose.getHeight()*4/5), 0, 0, choose.getWidth(), choose.getHeight());
		
		g.setColor(new Color(0,187,222));
		g.setFont(Game.text);
		
		
		String sn = songs[songcounter]; 
		
		
//		//if (l) {
//			g.drawImage(leftglow, 2, 324, 324 + glowsize, 200 + glowsize, 0, 0, leftglow.getWidth(), leftglow.getHeight());
//		}
//		//if (r) {
//			g.drawImage(rightglow, 432, 234, 54 + glowsize, 200 + glowsize, 0, 0, rightglow.getWidth(), rightglow.getHeight());
//		}
		
		
		int snlen = Game.text.getWidth(sn.toUpperCase()); 
		g.drawString(sn.toUpperCase(), mid-snlen/2, 480);
				
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		if (container.getInput().isKeyDown(Input.KEY_Z))
		 {
			game.enterState(Game.menu, new FadeOutTransition(), new FadeInTransition());
		}
		
		if (container.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			game.enterState(Game.play, new FadeOutTransition(), new FadeInTransition());
		}
		
//		if (left > 0) {
//			left -= delta;
//		} else {
//			l = false;
//		}
//
//		if (right > 0) {
//			right -= delta;
//		} else {
//			r = false;
//		}
		
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_D) {
			if(songcounter == 8)
			{
				songcounter = 0;
			}
			else
			{
				songcounter++;
			}
		} else if (key == Input.KEY_A) {
			if(songcounter == 0)
			{
				songcounter = 0;
			}
			else
			{
				songcounter--;
			}
		};
		super.keyPressed(key, c);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

}
