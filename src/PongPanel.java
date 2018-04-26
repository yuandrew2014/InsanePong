import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener{
Timer t1;
 public PongPanel(){
	 this.t1 = new Timer(1000/60, this);
 }


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	System.out.println("ping ching");
}
void startPong() {
	t1.start();
}
}
