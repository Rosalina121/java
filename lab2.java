import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
	
public class lab2 extends JFrame {
	
	class Slice {
		   double value;
		   Color color;
		   public Slice(double value) {  
		      this.value = value;
		      this.color = color.BLACK; // randomize this shit
		   }
		}
	
	class PieChart extends JComponent {
		   Slice[] slices;
		   PieChart(Slice[] slices) {
			   this.slices = slices;
		   }
		   public void paint(Graphics g) {
		      drawPie((Graphics2D) g, getBounds(), slices);
		   }
		   void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
		      double total = 0.0D;
		      
		      for (int i = 0; i < slices.length; i++) {
		         total += slices[i].value;
		      }
		      double curValue = 0.0D;
		      int startAngle = 0;
		      for (int i = 0; i < slices.length; i++) {
		         startAngle = (int) (curValue * 360 / total);
		         int arcAngle = (int) (slices[i].value * 360 / total);
		         g.setColor(slices[i].color);
		         g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
		         curValue += slices[i].value;
		      }
		   }
		  
		}
	
	
	JPanel p=new JPanel();
	JButton dodaj=new JButton("Dodaj");
	JButton usun=new JButton("Usun");
	JButton edytuj = new JButton("Edytuj");
	JTextField t=new JTextField("",20);
	JTextArea ta=new JTextArea("Tu wyswietlane beda bledy",1,5);
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public lab2() {
		
		super("Basic Swing App");
		
		
		ArrayList<Slice> arraySlices = new ArrayList<Slice>();
		Slice[] theSlices = arraySlices.toArray(new Slice[arraySlices.size()]);
		
		PieChart chart = new PieChart(theSlices);
		DefaultListModel lista = new DefaultListModel(); 
		JList aList = new JList(lista);
		JScrollPane sp = new JScrollPane(aList);
		
		aList.setFixedCellHeight(10);
		aList.setFixedCellWidth(50);
	
		sp.setPreferredSize(new Dimension(100,200));
		setSize(800,600);
		
		setResizable(true);

		p.add(dodaj);
		p.add(usun);
		p.add(edytuj);
		p.add(t);
		p.add(sp);
		p.add(ta);
		add(p);
		setVisible(true);
		chart.setVisible(true);
		chart.repaint();
		
		dodaj.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent ae){
			      String textFieldValue = t.getText();
			      if(isNumeric(textFieldValue)) {
			      lista.addElement(textFieldValue);
			      arraySlices.add(new Slice(Double.parseDouble(textFieldValue)));
			      }else {
					   String timeStamp = new SimpleDateFormat("[HH:mm:ss] ").format(new Date());
					   ta.setText(null);
					   ta.append(timeStamp + "B³¹d. Podaj liczbê.");
			      }
			   }
			});
		
		
		
		aList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				usun.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent ae){
						   if(aList.getSelectedIndex()!=-1) {
						   int a = aList.getSelectedIndex();
					       lista.remove(a);
						   arraySlices.remove(a);
						   }
					   }
					});
				edytuj.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent ae) {
						   if(aList.getSelectedIndex()!=-1) {
							   String textFieldValue = t.getText();
							   if(isNumeric(textFieldValue)) {
							   int a = aList.getSelectedIndex();
							   lista.set(a,textFieldValue);
							   arraySlices.set(a, new Slice(Double.parseDouble(textFieldValue)));
							   }else {
								   String timeStamp = new SimpleDateFormat("[HH:mm:ss] ").format(new Date());
								   ta.setText(null);
								   ta.append(timeStamp + "B³¹d. Podaj liczbê.");
							   }
						   }
					   }
					});
			}                 
        });				
	}
	
	
	public static void main(String[] args) {
		new lab2();
	}
	
	
}