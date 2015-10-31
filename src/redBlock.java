import java.awt.Color;
import java.awt.Graphics2D;

public class redBlock extends Obj{
	public redBlock(int x, int y){
		setX(x);
		setY(y);
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x-20/2, y-20/2, 20, 20);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
