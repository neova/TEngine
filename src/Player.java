import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Player extends Obj{
	private Input in;
	private double dx, dy;
	private int h = 10;
	public Player(int x, int y, Input inp){
		this.x = x;
		this.y = y;
		in = inp;
	}
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x-h/2, y-h/2, h, h);
		
	}

	@Override
	public void update() {
		int width = Scene.content.getSize().width;
		int height = Scene.content.getSize().height;
		if(in.getKey(KeyEvent.VK_A)){
			dx = -2f;
		}else if(in.getKey(KeyEvent.VK_W)){
			dy = -2f;
		}else if(in.getKey(KeyEvent.VK_D)){
			dx = 2f;
		}else if(in.getKey(KeyEvent.VK_S)){
			dy = 2f;
		}
		
		if(x+dx>=width -h/2){
			x = width -h/2;
		}else if(x+dx<=h/2){
			x = h/2;
		}else x +=dx;
		dx = 0;
		if(y+dy>=height -h/2){
			y = height -h/2;
		}else if(y+dy<=h/2){
			y = h/2;
		}else y +=dy;
		dy = 0;
	}

}
