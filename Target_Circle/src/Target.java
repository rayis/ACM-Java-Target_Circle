import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Target extends GraphicsProgram {
	
		public void run(){
			double offset = (double) (OUTER_RADIUS - INNER_RADIUS) / 4;
			double x = (double) getWidth() / 2 - INNER_RADIUS;
			double y = (double) getHeight() / 2 - INNER_RADIUS;
			double size = 2 * INNER_RADIUS;
			GOval circle1 = createFilledCircle(x, y, size, Color.RED);
			add(circle1);
			for(int i = 1; i < N_CIRCLES; i++){
				size += offset;
				x = (getWidth() - size) / 2;
				y = (getHeight() - size) / 2;
				Color color = Color.WHITE;
				if(i % 2 == 0) color = Color.RED;
				GOval circles = createFilledCircle(x, y, size, color);
				add(circles);
				circles.sendToBack();
			}
		}
		private GOval createFilledCircle(double n, double m, double rradius, Color color) {
			GOval circle = new GOval(n, m, rradius, rradius);
			circle.setColor(color);
			circle.setFilled(true);
			return circle;
		}
		
		private static final int N_CIRCLES = 5;
		private static final double OUTER_RADIUS = 75;
		private static final double INNER_RADIUS = 10;
}
