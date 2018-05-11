import java.awt.Graphics;

public class Gamemanager {
Player1 p1;
Gamemanager(Player1 p ){
	p1 = p;
}
void update() {
	if (p1 == null) {
		System.out.println("no player one");
	}
	else {
		p1.update();
	}
	
}
void draw(Graphics g) {
	p1.draw(g);
}
}
