package wielowatek;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class orbita implements Runnable{
	
	private class CircleCombo{
		int speed;
		JSlider slider;
		public CircleCombo(int spd, int sliderH) {
			speed = spd;
			slider = new JSlider();
			slider.setBounds(395, sliderH, 163, 23);
		}
	}
	
	public class MyRun implements Runnable {
		 
	    private int id;
	 
	    public MyRun(int id) {
	        this.id = id;
	    }
	 
	    @Override
	    public void run() {
	        while(true) {
	            System.out.println("Watek "+id);
	            try {
	                //usypiamy w¹tek na 100 milisekund
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orbita window = new orbita();
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
	public orbita() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	ArrayList<CircleCombo> sliderList = new ArrayList<CircleCombo>();
	
	private void initialize() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		frame = new JFrame();
		frame.setBounds(100, 100, 584, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 375, 375);
		frame.getContentPane().add(panel);
		
		int sliderH = 11;
		int defaultSpeed = 10;
		for(int i = 0; i < n; i++) {
			sliderList.add(new CircleCombo(defaultSpeed, sliderH+(34*i)));
			sliderList.get(i).slider.setBounds(395, sliderH+(34*i), 163, 23);
			frame.getContentPane().add(sliderList.get(i).slider);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
