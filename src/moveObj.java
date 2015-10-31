import java.awt.Color;
import java.awt.Graphics2D;

public class moveObj extends Obj{
	private int dx = 2;
	private int h = 20;
	
	public moveObj(int x, int y) {
		setX(x);
		setY(y);
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x-h/2, y-h/2, h, h);
		
	}

	@Override
	public void update() {
		int width = Scene.content.getSize().width;
		x +=dx;
		if(x+dx>=width -h/2){
			x = width -h/2;
			dx = -dx;
		}else if(x+dx<=h/2){
			x = h/2;
			dx = -dx;
		}
	}
}
