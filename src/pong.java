import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class pong {
	PongPanel p1;

	public pong() {
	// TODO Auto-generated constructor stub
		this.p1 = new PongPanel();
		setup();
}
	static int gameHeight = 800;
	static int gameWidth = 800;
public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			pong p = new pong();
			p.v();
		}
	});

	
}

JFrame f1 = new JFrame();
void v() {
	JFrame f1 = new JFrame();
	f1.setTitle("PongAway");
	 f1.setVisible(true);
	 f1.getContentPane().setPreferredSize(new Dimension(gameWidth, gameHeight));
	f1.addKeyListener(p1);
	 
	 f1.pack();
	 
}

void setup() {
	f1.add(p1);
	p1.startPong();
	
}

}
