import java.awt.Color;
import java.awt.Graphics;

public class Rain extends PongObject{
Player1 player;

Rain(int x, int y, int width, int height){
	super(x, y, width, height);
}
void update() {
	 super.update();
	y+=5;
}
void draw(Graphics g) {
	 g.drawImage(PongPanel.rainImg, x, y, width, height, null);
	
}

}
