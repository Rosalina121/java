import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class piechart extends JPanel {
	
	public piechart() {
		setPreferredSize(new Dimension(400, 400));		
	}

	public Double[] values;
	
	public static ArrayList<Color> colors = new ArrayList<Color>();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(values != null) {
			Graphics2D g2d = (Graphics2D) g;
			double sum = 0;
			
			if(values.length>0)
			for(double x : values) {
				sum += x;
			}
			
			int angle = 0;
			for(int i = 0; i<values.length; i++) {
				
				int size=(int) Math.round(values[i]*360.0f/sum);
				g2d.setColor(colors.get(i));
				g2d.fillArc(0, 0, 120, 120, angle, size);
				angle += size;
			}
		}		
	}
}
