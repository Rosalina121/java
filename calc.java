package kalulator;

import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public class calc {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calc window = new calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public calc() {
		initialize();
	}

	private String listToString(ArrayList<String> list) {
		String tmp = "";
		if(list.size()!=0) {
			for(int i=0;i<list.size();i++) {
				tmp += list.get(i);
			}
		}
		return tmp; 
	}
	
	ArrayList<String> buffer = new ArrayList<String>();
	ArrayList<String> minibr = new ArrayList<String>();
	int i = 0; //, abcfp = 0;
	String jtextAreaText = "";
	Timer timer;
	long startTime;
	boolean dm = false;
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 264, 167);
		frame.getContentPane().add(textPane);
		
		JButton stuv = new JButton("stuv");
		stuv.setBounds(10, 327, 89, 23);
		frame.getContentPane().add(stuv);
		stuv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm) {
					minibr.add("S");
				}else {
					minibr.add("s");
				}
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton mno = new JButton("mno");
		mno.setBounds(10, 293, 89, 23);
		frame.getContentPane().add(mno);
		mno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm) {
					minibr.add("M");
				}else {
					minibr.add("m");
				}
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton ghi = new JButton("ghi");
		ghi.setBounds(10, 259, 89, 23);
		frame.getContentPane().add(ghi);
		ghi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm) {
					minibr.add("G");
				}else {
					minibr.add("g");
				}
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton abc = new JButton("abc");
		abc.setBounds(10, 225, 89, 23);
		frame.getContentPane().add(abc);
		abc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm) {
					minibr.add("A");
				}else {
					minibr.add("a");
				}
				textPane.setText(listToString(minibr));
				
				/*startTime=System.currentTimeMillis();
				timer=new Timer(3000, this);
				timer.setRepeats(false);
				
				++i;
				if(i%1==0) {
					//timer.cancel();
					timer.start();
					if(abcfp==0) minibr.add(" ");
					minibr.set(minibr.size()-1,"a");
					abcfp++;
				}
				if(i%2==0) {
					
					timer.start();
					minibr.set(minibr.size()-1,"b");
					abcfp++;
				}
				if(i%3==0) {
					
					timer.start();
					minibr.set(minibr.size()-1,"c");
					abcfp++;
				}
				if(i==3) {
					i=0;
				}
				long now=System.currentTimeMillis();
				long elapsed=now-startTime;
				System.out.println(elapsed);
				textPane.setText(listToString(minibr));	*/
			}
		});
		
		JButton def = new JButton("def");
		
		def.setBounds(109, 225, 89, 23);
		frame.getContentPane().add(def);
		def.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm) {
					minibr.add("D");
				}else {
					minibr.add("d");
				}
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton wxyz = new JButton("wxyz");
		wxyz.setBounds(109, 327, 89, 23);
		frame.getContentPane().add(wxyz);
		wxyz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm) {
					minibr.add("W");
				}else {
					minibr.add("w");
				}
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton jkl = new JButton("jkl");
		jkl.setBounds(109, 259, 89, 23);
		frame.getContentPane().add(jkl);
		jkl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm) {
					minibr.add("J");
				}else {
					minibr.add("j");
				}
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton pqr = new JButton("pqr");
		pqr.setBounds(109, 293, 89, 23);
		frame.getContentPane().add(pqr);
		pqr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm) {
					minibr.add("P");
				}else {
					minibr.add("p");
				}
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton clear = new JButton("C");
		clear.setBounds(109, 191, 89, 23);
		frame.getContentPane().add(clear);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(minibr.size()!=0) minibr.remove(minibr.size()-1);
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton plusb = new JButton("+");
		plusb.setBounds(208, 191, 66, 23);
		frame.getContentPane().add(plusb);
		plusb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minibr.add("+");
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton minusb = new JButton("-");
		minusb.setBounds(208, 225, 66, 23);
		frame.getContentPane().add(minusb);
		minusb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minibr.add("-");
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton divideb = new JButton("/");
		divideb.setBounds(208, 259, 66, 23);
		frame.getContentPane().add(divideb);
		divideb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minibr.add("/");
				textPane.setText(listToString(minibr));
			}

		});
		
		JButton DM = new JButton("D/M");
		DM.setBounds(10, 191, 89, 23);
		frame.getContentPane().add(DM);
		DM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dm) {
					dm = false;
					abc.setText("abc");
					def.setText("def");
					ghi.setText("ghi");
					jkl.setText("jkl");
					mno.setText("mno");
					pqr.setText("pqr");
					stuv.setText("stuv");
					wxyz.setText("wxyz");
				}else {
					dm = true;
					abc.setText("ABC");
					def.setText("DEF");
					ghi.setText("GHI");
					jkl.setText("JKL");
					mno.setText("MNO");
					pqr.setText("PQR");
					stuv.setText("STUV");
					wxyz.setText("WXYZ");
				}
			}
		});
		
		JButton equalsb = new JButton("=");
		equalsb.setBounds(208, 293, 66, 57);
		frame.getContentPane().add(equalsb);
		equalsb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tmp = "???", tmp1 = "", tmp2 = "";
				int j=0, action=0; // 1+, 2-, 3/, brkIndex - miejesce znkau operatora
				while(minibr.get(j)!="+" && minibr.get(j)!="-" && minibr.get(j)!="/"){
					tmp1+=minibr.get(j);
					j++;
				}
				
				switch(minibr.get(j)) {
				case "+":
					action = 1;
					break;
				case "-":
					action = 2;
					break;
				case "/":
					action = 3;
					break;			
				}
				
				for(int c=j+1;c<minibr.size();c++) {
					tmp2+=minibr.get(c);
				}
				
				switch(action) {
				case 1:
					tmp = tmp1 + tmp2;
					minibr.add("=" + tmp);
					textPane.setText(listToString(minibr));
					break;
				case 2:
					tmp = tmp1.replaceAll(tmp2, "");
					minibr.add("=" + tmp);
					textPane.setText(listToString(minibr));
					break;
				case 3:
					//tmp = tmp1.replaceAll(tmp2, "");
					//tmp = tmp1.replaceAll(tmp, "");
					minibr.add("=" + tmp);
					textPane.setText(listToString(minibr));
					break;
				}

			}
		});
	}
}
