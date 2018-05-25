import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class PongObject {
	boolean isAlive = true;

	Rectangle collisionBox;
	Rectangle deathbox;
	  int x;
      int y;
      int width;
      int height;
public PongObject(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.collisionBox = new Rectangle(x,y,width,height);
	this.deathbox = new Rectangle(4,600,800,30);
}
void update() {
	collisionBox.setBounds(x, y, width, height);
	deathbox.setBounds(4, 600, 800, 30);
}
void draw(Graphics g) {
	
}


}
