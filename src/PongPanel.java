import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
	Timer t1;
	Player1 player;
	Font titleFont;
	Font titleFont2;
	Font titleFont3;
	Font titleFont4;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	final int HIGH_STATE = 3;
	int currentState = MENU_STATE;

	public PongPanel() {
		this.player = new Player1(5,400,50,120);
		this.t1 = new Timer(1000 / 60, this);
		this.titleFont = new Font("Arial",Font.PLAIN,48);
		this.titleFont2 = new Font("Arial",Font.PLAIN,24);
		this.titleFont3= new Font("Arial",Font.PLAIN,24);
		this.titleFont4 = new Font("Arial",Font.PLAIN,24);
	}

	@Override
	public void paintComponent(Graphics g) {
		
		if (currentState == MENU_STATE) {

			drawMenuState(g);
		} else if (currentState == GAME_STATE) {

		drawGameState(g);

		} else if (currentState == END_STATE) {

		drawEndState(g);

		} else if (currentState == HIGH_STATE) {

		drawHighState(g);

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

		} else if (currentState == HIGH_STATE) {

			updateHighState();

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
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.y -= 40;
		
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.y += 40;
		
		}
	}
		
	

	@Override

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == 10) {
			System.out.println(currentState);
			currentState += 1;

			if (currentState > END_STATE) {

				currentState = MENU_STATE;

			}
			if (currentState > HIGH_STATE) {

				currentState = MENU_STATE;

			}
		}
	}

	void updateMenuState() {
		repaint();
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, pong.gameWidth, pong.gameHeight);
		g.setColor(Color.BLACK);
		
		g.setFont(titleFont);
		g.drawString("Pong",350,400);
		g.setFont(titleFont2);
		g.drawString("Click E to initiate easy mode",250,440);
		g.setFont(titleFont3);
		g.drawString("Click H to initiate hard mode",250,480);
		g.setFont(titleFont4);
		g.drawString("Click I to initiate insane mode",250,520);
	}

	void updateGameState() {
player.update();
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, pong.gameWidth, pong.gameHeight);
		g.setColor(Color.WHITE);
		player.draw(g);
	}

	void updateEndState() {

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, pong.gameWidth, pong.gameHeight);
	}

	void updateHighState() {

	}

	void drawHighState(Graphics g) {
		g.setColor(Color.GREEN);

		g.fillRect(0, 0, pong.gameWidth, pong.gameHeight);
	}
}
