import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
	Timer t1;
	public static BufferedImage bucketImg;
	public static BufferedImage rainImg;
	public static BufferedImage landImg;
	int ezspeed = 100;
	int harspeed = 55;
	int inspeed = 40;
	Player1 player;
	Font titleFont;
	Font titleFont2;
	Font titleFont3;
	Font titleFont4;
	Font endFont;
	Font arrows;
	;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	
	int currentState = MENU_STATE;
	Gamemanager gm;
	
	 

        
	
	public PongPanel(){

		try {
			bucketImg = ImageIO.read(this.getClass().getResourceAsStream("bucket.png"));
			rainImg = ImageIO.read(this.getClass().getResourceAsStream("rain.png"));
			landImg = ImageIO.read(this.getClass().getResourceAsStream("rainyLandscape.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.player = new Player1(400,400,100,120);
		this.t1 = new Timer(1000 / 60, this);
		this.titleFont = new Font("Arial",Font.PLAIN,48);
		this.titleFont2 = new Font("Arial",Font.PLAIN,24);
		this.titleFont3= new Font("Arial",Font.PLAIN,24);
		this.titleFont4 = new Font("Arial",Font.PLAIN,24);
		this.endFont = new Font("Arial", Font.PLAIN,24);
		this.arrows = new Font("Arial", Font.PLAIN,24);
		this.gm = new Gamemanager(player);
			}

	@Override
	public void paintComponent(Graphics g) {
		
		if (currentState == MENU_STATE) {

			drawMenuState(g);
		} else if (currentState == GAME_STATE) {

		drawGameState(g);

		} else if (currentState == END_STATE) {

		drawEndState(g);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			//System.out.println("repaint");
			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

		if (player.isAlive == false) {
			currentState 
			= END_STATE;
		}
		repaint();
	}

	void startPong() {
		t1.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.x -= player.speed;
		
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.x += player.speed;
		
		}
		if(currentState == 0) {
			if (e.getKeyCode() == KeyEvent.VK_E) {
				player.speed = ezspeed;
			
			}
			else if (e.getKeyCode() == KeyEvent.VK_H) {
				player.speed = harspeed;
				
			}
			else if (e.getKeyCode() == KeyEvent.VK_I) {
				player.speed = inspeed;
				
			}
		}
	}
	@Override

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println(currentState);
			currentState += 1;


			if (currentState > END_STATE) {
				player.isAlive = true;
				currentState = MENU_STATE;
				this.player = new Player1( 400,  400, 100,  120);
				this.gm = new Gamemanager(player);
			}
	
	}
			
		}
	

	void updateMenuState() {
		repaint();
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, RainGame.gameWidth, RainGame.gameHeight);
		g.setColor(Color.BLACK);
		
		g.setFont(titleFont);
		g.drawString("Collect the Rain",220,400);
		g.setFont(titleFont2);
		g.drawString("Click E to initiate easy mode",250,440);
		g.setFont(titleFont3);
		g.drawString("Click H to initiate hard mode",250,480);
		g.setFont(titleFont4);
		g.drawString("Click I to initiate insane mode",250,520);
		g.setFont(arrows);
		g.drawString("Use your arrow key to move", 250, 600);
	}

	void updateGameState() {
gm.update();
gm.manageEnemies();
gm.checkCollision();
gm.purgeRain();

	}

	void drawGameState(Graphics g) {
		 g.drawImage(PongPanel.landImg, 0,0,  800, 800, null);
		g.setColor(Color.WHITE);
		gm.draw(g);
	}

	void updateEndState() {

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, RainGame.gameWidth, RainGame.gameHeight);
		g.setColor(Color.DARK_GRAY);
		g.setFont(endFont);
		g.drawString("your score is : " + gm.score,340 , 400);
		
	}

	void updateHighState() {

	}

	void drawHighState(Graphics g) {
		g.setColor(Color.GREEN);

		g.fillRect(0, 0, RainGame.gameWidth, RainGame.gameHeight);
	}
}
