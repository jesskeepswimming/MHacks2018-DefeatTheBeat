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
import states.beats;

import core.Game;

public class Play extends BasicGameState {

	int[] data;
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

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		bg = new Image("res/images/background.png");
		i1 = new Image("res/images/2make-fist.png");
		i2 = new Image("res/images/3spread-fingers.png");
		i3 = new Image("res/images/4wave-left.png");
		i4 = new Image("res/images/5wave-right.png");
		try {
			data = beats.getarray("http://ericamwang.com/videoplayback.aif");
			System.out.println(Arrays.toString(data));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

		g.drawImage(bg, 0, 0, container.getWidth(), container.getHeight(), 0, 0, bg.getWidth(), bg.getHeight());
		g.drawImage(i1, x1, hitY, x1 + iconSize, hitY + iconSize, 0, 0, i1.getWidth(), i1.getHeight());
		g.drawImage(i2, x2, hitY, x2 + iconSize, hitY + iconSize, 0, 0, i2.getWidth(), i2.getHeight());
		g.drawImage(i3, x3, hitY, x3 + iconSize, hitY + iconSize, 0, 0, i3.getWidth(), i3.getHeight());
		g.drawImage(i4, x4, hitY, x4 + iconSize, hitY + iconSize, 0, 0, i4.getWidth(), i4.getHeight());

		int length = data.length * iconSize;

		for (int i = 0; i < data.length; i++) {
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
			int y = (int) (currentTick * 40) + hitY - (i * (iconSize + 50));
			
			g.fillOval(x, y, iconSize, iconSize);
		}

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
		// TODO Auto-generated method stub
		super.keyPressed(key, c);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Game.play;
	}

}
