import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class PongObject {
	boolean isAlive = true;

	Rectangle collisionBox;
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
}
void update() {
	collisionBox.setBounds(x, y, width, height);
}
void draw(Graphics g) {
	
}


}
