import java.awt.Color;
import java.awt.Graphics;

public class Player1 extends PongObject{
int speed = 80;
	public Player1(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		 super.update();
		
	}
	void draw(Graphics g) {
		  g.drawImage(PongPanel.bucketImg, x, y, width, height, null);


	}

}
