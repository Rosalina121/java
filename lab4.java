package lab4;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;


	
	class Slice{
		double value;
		Color color;
		public Slice(double value, Color color) {
			this.value = value;
			this.color = color;
		}
	}
	
	class MyComponent extends JFrame{
		ArrayList<Slice> slices = new ArrayList<>();
		
		public MyComponent(){

		}
		public void addSlice(double value, Color color) {
			slices.add(new Slice(value, color));
		}
		
		public void paint(Graphics g) {
		    drawPie((Graphics2D) g, getBounds(), slices);
		}
		
		void drawPie(Graphics2D g, Rectangle area, ArrayList<Slice> slices) {
			double total = 0.0D;
			for(int i = 0; i< slices.size(); i++) {
				total += slices.get(i).value;
			}
			
			double curValue = 0.0D;
			int startAngle = 0;
			for (int i=0; i<slices.size(); i++) {
				startAngle = (int) (curValue * 360 / total);
				int arcAngle = (int) (slices.get(i).value * 360 / total);
				
				g.setColor(slices.get(i).color);
				g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
				curValue += slices.get(i).value;
				
			}
		}
	}
	
	
	public void idk() {
		Container container;
		container = getContentPane();
    
	 	JFrame frame = new JFrame("JFrame");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	    JButton dodajButton = new JButton("Dodaj");
	    JButton usunButton = new JButton("Usun");
	    JButton edytujButton = new JButton("Edytuj");
	    
	    usunButton.setBounds(850, 0, 100, 50);
	    dodajButton.setBounds(850, 50, 100, 50);
	    edytujButton.setBounds(850, 100, 100, 50);
	    
	    JTextField field = new JTextField(10); //Double.parseDouble(field.getText());
	    field.setBounds(700, 0, 100, 50);
	    
	    frame.add(new MyComponent());
	    
	    frame.add(field);
	    
	    frame.add(dodajButton);
	    frame.add(edytujButton);
	    frame.add(usunButton);
	    
	    frame.setLayout(null);

	    frame.setSize(1000, 300);
	    frame.setVisible(true);
	    
	}
	
	public class lab4 {
	public void main(String[] args) {

		
		new MyComponent();



	}
}

