package core;

import java.awt.Font;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

import states.Play;

public class Game extends StateBasedGame {

	public static final String gameName = "Beat to Move";
	public static final String version = "0.0.1";
	public static final int fps = 119;
	public static final boolean debugMode = false;
	public static final int menu = 1, play = 2;

	public static TrueTypeFont heading, text, title;

	public static AppGameContainer appgc;

	public Game(String gameName) throws SlickException {

		super(gameName);
		this.addState(new Play());
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// fonts
		Font javaFont = new Font("Verdana", Font.BOLD, (int) (appgc.getWidth() / 80));
		heading = new TrueTypeFont(javaFont, true);

		javaFont = new Font("Verdana", Font.PLAIN, (int) (appgc.getWidth() / 90));
		text = new TrueTypeFont(javaFont, true);

		javaFont = new Font("Verdana", Font.BOLD, (int) (appgc.getWidth() / 60));
		title = new TrueTypeFont(javaFont, true);
		
		this.getState(play).init(appgc, this);
		this.enterState(play);
	}

	public static void main(String[] args) {

		try {
			appgc = new AppGameContainer(new Game(gameName + " " + version));
			appgc.setDisplayMode(1600, 900, false);
			appgc.setDefaultFont(text);
			appgc.setShowFPS(debugMode);
			appgc.setTargetFrameRate(fps);
			appgc.start();

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}