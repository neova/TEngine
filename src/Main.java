import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static Player player;
	public static redBlock red;
	public static green gre;
	public static moveObj mvb;
	public static void main(String[] args) {
		
		JFrame win = new JFrame("Demo");
		win.setSize(new Dimension(600, 400));
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		
		Dimension size = win.getContentPane().getSize();
		JPanel leftM = new JPanel();
		leftM.setSize(new Dimension(100, size.height));
		leftM.setPreferredSize(new Dimension(100, size.height));

		JLabel key = new JLabel();
		key.setFont(new Font("TimesRoman", Font.BOLD, 16));
		key.setText("X");
		key.setPreferredSize(new Dimension(90, 300));
		leftM.add(key, BorderLayout.CENTER);
		
		win.add(leftM, BorderLayout.EAST);
		
		Scene.create(win);
		Scene.resize(new Dimension(size.width-100, size.height));
		
		Input in = new Input();
		win.add(in);
		
		String s = "";
		
		player = new Player(40, 40, in);
		gre = new green(40,100);
		red = new redBlock(100, 39);
		mvb = new moveObj(200, 75);
		win.revalidate();
		
		boolean push = false;
		while(true){
			//update
			player.update();
			mvb.update();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			push = false;
			for(int i = 0; i < 256; i++){
				
				if (in.getMap()[i]){
					s += KeyEvent.getKeyText(i)+"<br>";
					push = true;
				}
			}
			if (push) {
				key.setText("<html>" + s + "</html>");
				s = "";
			}else {
				s = "";
				key.setText("X");
			}
			//draw
			Scene.clear();
			gre.draw(Scene.getGraphics());
			red.draw(Scene.getGraphics());
			mvb.draw(Scene.getGraphics());
			player.draw(Scene.getGraphics());
			Scene.swapBuffers();
			//--
		}
	}
}
