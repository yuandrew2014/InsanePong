import java.awt.Color;
import java.awt.Graphics;

public class Rain extends PongObject{
Player1 player;
Rain(int x, int y, int width, int height){
	super(x, y, width, height);
}
void update() {
	y++;
}
void draw(Graphics g) {
	g.setColor(Color.GREEN);
	g.fillRect(x, y, width, height);
	
}

}
