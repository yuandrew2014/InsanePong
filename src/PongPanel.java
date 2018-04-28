import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
	Timer t1;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	final int HIGH_STATE = 3;
	int currentState = MENU_STATE;

	public PongPanel() {
		this.t1 = new Timer(1000 / 60, this);
	}

	@Override
	public void paintComponent(Graphics g) {
		System.out.println("menu");
//		if (currentState == MENU_STATE) {
//
//			drawMenuState(g);
//			System.out.println("menu");
//		} else if (currentState == GAME_STATE) {
//
//			drawGameState(g);
//
//		} else if (currentState == END_STATE) {
//
//			drawEndState(g);
//
//		} else if (currentState == HIGH_STATE) {
//
//			drawHighState(g);
//
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		} else if (currentState == HIGH_STATE) {

			updateHighState();

		}

		System.out.println("repaint");
		this.repaint();
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

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.ORANGE);

		g.fillRect(0, 0, pong.gameWidth, pong.gameHeight);
	}

	void updateGameState() {

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, pong.gameWidth, pong.gameHeight);
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
