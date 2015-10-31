import java.awt.Color;
import java.awt.Graphics2D;

public class green extends Obj{
	public green(int x, int y){
		setX(x);
		setY(y);
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(x-10, y-10, 20, 20);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
