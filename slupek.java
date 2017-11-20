import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JCheckBox;

public class slupek {
	public static class BarElement{
		double value;
		Color color;
		BarElement(double d){
			int r, g, b;
			Random rand  = new Random();
			r = rand.nextInt(255);
			g = rand.nextInt(255);
			b = rand.nextInt(255);
			this.value = d;
			Color color = new Color(r,g,b);
			this.color = color;
		}
	}
	
	public class zad2 extends JPanel{

		private Map<Color, Double> bars = new LinkedHashMap<Color, Double>();
		
		public void addBar(BarElement bar) {
			bars.put(bar.color, bar.value);
			repaint();
		}
		
		public void removeBar(BarElement bar) {
			if(bar!=null) {
			bars.remove(bar.color,bar.value);
			repaint();
			}
		}

		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			double max = Double.MIN_VALUE;
			for(Double value : bars.values()) {
				max = Math.max(max, value);
			}
			if(bars.size()!=0) {
			int width = (getWidth() / bars.size()) - 2;
			
			int x = 1;
			for(Color color : bars.keySet()) {
				double value = bars.get(color);
				int height = (int)((getHeight()-5)*((double)value / max));
				g.setColor(color);
				g.fillRect(x, getHeight()-height, width, height);
				g.setColor(Color.black);
				g.drawRect(x, getHeight()-height, width, height);
				x += (width + 2);
			}
			}
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(bars.size() * 10 + 2, 50);
		}
		
	}
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					slupek window = new slupek();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public slupek() {
		initialize();
	}
	
	public boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 212);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 40, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 42, 40, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 73, 40, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 104, 40, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 135, 40, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(90, 11, 40, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(90, 42, 40, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(90, 73, 40, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(90, 104, 40, 20);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(90, 135, 40, 20);
		frame.getContentPane().add(textField_9);
		
		JCheckBox txtbox6 = new JCheckBox();
		txtbox6.setBounds(136, 10, 19, 23);
		frame.getContentPane().add(txtbox6);
		
		JCheckBox txtbox7 = new JCheckBox();
		txtbox7.setBounds(136, 41, 19, 23);
		frame.getContentPane().add(txtbox7);
		
		JCheckBox txtbox8 = new JCheckBox();
		txtbox8.setBounds(136, 72, 19, 23);
		frame.getContentPane().add(txtbox8);
		
		JCheckBox txtbox9 = new JCheckBox();
		txtbox9.setBounds(136, 103, 19, 23);
		frame.getContentPane().add(txtbox9);
		
		JCheckBox txtbox10 = new JCheckBox();
		txtbox10.setBounds(136, 134, 19, 23);
		frame.getContentPane().add(txtbox10);
		
		JCheckBox txtbox1 = new JCheckBox();
		txtbox1.setBounds(56, 10, 19, 23);
		frame.getContentPane().add(txtbox1);
		
		JCheckBox txtbox2 = new JCheckBox();
		txtbox2.setBounds(56, 41, 19, 23);
		frame.getContentPane().add(txtbox2);
		
		JCheckBox txtbox3 = new JCheckBox();
		txtbox3.setBounds(56, 72, 19, 23);
		frame.getContentPane().add(txtbox3);
		
		JCheckBox txtbox4 = new JCheckBox();
		txtbox4.setBounds(56, 103, 19, 23);
		frame.getContentPane().add(txtbox4);
		
		JCheckBox txtbox5 = new JCheckBox();
		txtbox5.setBounds(56, 134, 19, 23);
		frame.getContentPane().add(txtbox5);
		
		zad2 chart = new zad2();
		chart.setBounds(175, 247, 249, -237);
		
		List<BarElement> barList = new ArrayList<BarElement>();
		
		for(int i=0;i<10;i++) {
			barList.add(null);
		}
	
		txtbox1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox1.isSelected()) {
                	String tmp = textField.getText();
                	if(isNumeric(tmp)) {
                		barList.set(0,new BarElement(Double.parseDouble(tmp)));     
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {

                	chart.removeBar(barList.get(0));
                	barList.set(0, null);
                	//System.out.println("ustawia na null");
            		//for(int i=0;i<barList.size();i++) {
            		//	if(barList.get(i)!=null) chart.addBar(barList.get(i));
            		//}
                }
            }
        });
        
        //-------------------------------------------------
		txtbox2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox2.isSelected()) {
                	String tmp = textField_1.getText();
                	if(isNumeric(tmp)) {
                		barList.set(1,new BarElement(Double.parseDouble(tmp)));    
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {
                	chart.removeBar(barList.get(1));
                	barList.set(1, null);
                }
            }
        });
        
        //-------------------------------------------------
		txtbox3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox3.isSelected()) {
                	String tmp = textField_2.getText();
                	if(isNumeric(tmp)) {
                		barList.set(2,new BarElement(Double.parseDouble(tmp)));    
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {
                	chart.removeBar(barList.get(2));
                	barList.set(2, null);
                }
            }
        });
		
        //-------------------------------------------------
		txtbox4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox4.isSelected()) {
                	String tmp = textField_3.getText();
                	if(isNumeric(tmp)) {
                		barList.set(3,new BarElement(Double.parseDouble(tmp)));    
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {
                	chart.removeBar(barList.get(3));
                	barList.set(3, null);
                }
            }
        });
		
        //-------------------------------------------------
		txtbox5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox5.isSelected()) {
                	String tmp = textField_4.getText();
                	if(isNumeric(tmp)) {
                		barList.set(4,new BarElement(Double.parseDouble(tmp)));    
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {
                	chart.removeBar(barList.get(4));
                	barList.set(4, null);
                }
            }
        });
		
        //-------------------------------------------------
		txtbox6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox6.isSelected()) {
                	String tmp = textField_5.getText();
                	if(isNumeric(tmp)) {
                		barList.set(5,new BarElement(Double.parseDouble(tmp)));    
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {
                	chart.removeBar(barList.get(5));
                	barList.set(5, null);
                }
            }
        });
		
        //-------------------------------------------------
		txtbox7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox7.isSelected()) {
                	String tmp = textField_6.getText();
                	if(isNumeric(tmp)) {
                		barList.set(6,new BarElement(Double.parseDouble(tmp)));    
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {
                	chart.removeBar(barList.get(6));
                	barList.set(6, null);
                }
            }
        });
		
        //-------------------------------------------------
		txtbox8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox8.isSelected()) {
                	String tmp = textField_7.getText();
                	if(isNumeric(tmp)) {
                		barList.set(7,new BarElement(Double.parseDouble(tmp)));    
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {
                	chart.removeBar(barList.get(7));
                	barList.set(7, null);
                }
            }
        });
		
        //-------------------------------------------------
		txtbox9.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox9.isSelected()) {
                	String tmp = textField_8.getText();
                	if(isNumeric(tmp)) {
                		barList.set(8,new BarElement(Double.parseDouble(tmp)));    
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {
                	chart.removeBar(barList.get(8));
                	barList.set(8, null);
                }
            }
        });
		
        //-------------------------------------------------
		txtbox10.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(txtbox10.isSelected()) {
                	String tmp = textField_9.getText();
                	if(isNumeric(tmp)) {
                		barList.set(9,new BarElement(Double.parseDouble(tmp)));    
                		for(int i=0;i<barList.size();i++) {
                			chart.removeBar(barList.get(i));
                			if(barList.get(i)!=null) chart.addBar(barList.get(i));
                		}
                	}
                }else {
                	chart.removeBar(barList.get(9));
                	barList.set(9, null);
                }
            }
        });
		

		
        
        

		chart.setBounds(200, 11, 200, 150);
		frame.getContentPane().add(chart);
		
	}
}
