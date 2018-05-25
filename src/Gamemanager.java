import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamemanager {
	long rainTimer;
	 int rainSpawnTime;
	 int score;
	List<Rain>rains = new ArrayList<>();
Player1 p1;
Gamemanager(Player1 p ){
	p1 = p;
	rainTimer= 0;
	rainSpawnTime = 700;
}
void update() {
	if (p1 == null) {
		System.out.println("no player one");
	}
	else {
		p1.update();
	}
	for (int i = 0; i < rains.size(); i++) {
		Rain r = rains.get(i);
		r.update();
	}
}
void draw(Graphics g) {
	p1.draw(g);
	for (int i = 0; i < rains.size(); i++) {
		Rain r = rains.get(i);
		r.draw(g);
	}
}
void addRain(Rain r1){
	rains.add(r1);
}
public void manageEnemies(){
    if(System.currentTimeMillis() - rainTimer >= rainSpawnTime){
            addRain(new Rain(new Random().nextInt(RainGame.gameWidth), 0, 50, 50));

rainTimer = System.currentTimeMillis();
    }
}
void purgeRain() {
	for (int i = 0; i < rains.size(); i++) {
		if (rains.get(i).isAlive == false) {
			rains.remove(i);
		}
	}
	
}

void checkCollision() {
	for(Rain a : rains){
if (a.y >= 700) {
	System.out.println("passed");
	p1.isAlive = false;
	a.isAlive = false;
}
      }
	
        for (int i = 0; i< rains.size(); i++) {
			if (rains.get(i).collisionBox.intersects(p1.collisionBox)) {
				
				rains.remove(i);
				score++;
			}
		}
        
        
}
}

