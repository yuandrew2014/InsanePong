import java.awt.Color;
import java.awt.Graphics;

public class Player1 extends PongObject{

	public Player1(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		 super.update();
		
	}
	void draw(Graphics g) {
		g.setColor(Color.CYAN);

        g.fillRect(x, y, width, height);


	}

}
