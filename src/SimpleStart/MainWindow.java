package SimpleStart;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import SimpleStart.Drops;

public class MainWindow extends JFrame {
	private static long lastFrameTime;
    private static MainWindow gameWindow;
	private static Image backGround;
	private static Image drop;
	private static Image GG;

	private static float DropX = 200;
	private static float DropY = -100;
	private static float Speed = 100;

	private static int countDrops = 50;
	private static ArrayList<Drops> dropsList;
    public static void main(String[] args) throws IOException {
		backGround = ImageIO.read(MainWindow.class.getResourceAsStream("background.png"));
		drop = ImageIO.read(MainWindow.class.getResourceAsStream("drop.png"));
		GG = ImageIO.read(MainWindow.class.getResourceAsStream("game_over.png"));

	    gameWindow = new MainWindow();
	    gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    gameWindow.setLocation(200, 100);
	    gameWindow.setSize (906, 478);
	    gameWindow.setResizable(false);
	    gameWindow.setVisible(true);

	    lastFrameTime = System.nanoTime();
	    GameField gameField = new GameField();
	    gameWindow.add(gameField);
		dropsList = new ArrayList<Drops>();
		for (int i = 0; i < countDrops; i++){
			dropsList.add(new Drops((float)(Math.random() * 900), -100, drop));
		}
    }

    private static void onRepaint(Graphics g){
    	long currentTime = System.nanoTime();
    	float deltaFrameTime = (currentTime - lastFrameTime) * 0.000000001f;
		System.out.println(deltaFrameTime);
    	lastFrameTime = currentTime;

    	DropY = DropY + Speed * deltaFrameTime;
    	//Speed+=10;

		//DropX = (int)(Math.random() * 900);
		g.drawImage(backGround, 0,0,null);
		for (Drops item : dropsList) {
			if (item.GetY() > 400){
				item.SetY(-100);
				item.SetX((float)(Math.random() * 900));
			}
			item.SetY((item.GetY() + (int)(Math.random() * 25)) + Speed * deltaFrameTime);
			g.drawImage(item.GetImage(), (int)item.GetX(), (int)item.GetY(), null);
		}
		//g.drawImage(GG, 280,120,null);
	}
	private static class GameField extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			onRepaint(g);
			repaint();
		}
	}
}
