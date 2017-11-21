import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class kolowy {

	private JFrame frame;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kolowy window = new kolowy();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void genColor() {
		Random rand  = new Random();
		int red = rand.nextInt(255);
		int green = rand.nextInt(255);
		int blue = rand.nextInt(255);
		piechart.colors.add(new Color(red,green,blue));
	}
	
	public kolowy() {
		initialize();
	}
	
	JList<Double> lista;
	DefaultListModel<Double> listmodel;
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 500, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		piechart panel = new piechart();
		panel.setBounds(270, 45, 140, 140);
		desktopPane.add(panel);
		
		textField = new JTextField();
		textField.setBounds(27, 191, 186, 20);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JButton dodaj = new JButton("dodaj");
		dodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = textField.getText();
				double value;				
				try
				{
					value= Double.parseDouble(s);				
					listmodel.addElement(value);
					genColor();
					panel.values = new Double[listmodel.size()];
					listmodel.copyInto(panel.values);
					panel.repaint();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					return;
				}
			}
		});
		dodaj.setBounds(27, 228, 70, 23);
		desktopPane.add(dodaj);
		
		JButton usun = new JButton("usun");
		usun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = lista.getSelectedIndex();
				if(index>=0)
				{
					listmodel.remove(index);	
					panel.values = new Double[listmodel.size()];
					listmodel.copyInto(panel.values);
					panel.repaint();
				}				
			}
		});
		usun.setBounds(107, 228, 70, 23);
		desktopPane.add(usun);
		
		JButton edytuj = new JButton("edytuj");
		edytuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try
				{
					Double val= Double.parseDouble(textField.getText());
					int index = lista.getSelectedIndex();
					if(index>=0)
					{
						listmodel.remove(index);
						listmodel.add(index, val);				
						panel.values = new Double[listmodel.size()];
						listmodel.copyInto(panel.values);
						panel.repaint();
					}	
				}
				catch(Exception exception)
				{
					System.out.println(exception.getMessage());
				}
											
			}
		});
		edytuj.setBounds(187, 228, 70, 23);
		desktopPane.add(edytuj);
		
		
		listmodel = new DefaultListModel<Double>();
		
		lista = new JList<Double>();
		lista.setModel((ListModel<Double>)listmodel);
		lista.setSize(186, 121);
		
		lista.setLocation(0, 0);
		
		
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setLocation(27, 44);
		listScroller.setSize(186, 121);
		desktopPane.add(listScroller);		
	}
}
