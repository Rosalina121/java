import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class kalkulator {
	
	class MyMouseListener extends MouseAdapter {
		  public void mouseClicked(MouseEvent evt) {
		    if (evt.getClickCount() == 3) {
		      System.out.println("triple-click");
		    } else if (evt.getClickCount() == 2) {
		      System.out.println("double-click");
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
					kalkulator window = new kalkulator();
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
	public kalkulator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	String tmpString;
	ArrayList<String> stringList = new ArrayList<String>();
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 260, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(10, 136, 224, 45);
		frame.getContentPane().add(textArea2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 224, 114);
		frame.getContentPane().add(textArea);
		
		JButton abc = new JButton("abc");
		abc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			

			}
		});
		abc.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 3) {
					tmpString = "c";
					System.out.println(tmpString);
				} else if (evt.getClickCount() == 2) {
					tmpString = "b";
					System.out.println(tmpString);
				} else if (evt.getClickCount() == 1) {
					tmpString = "a";
					System.out.println(tmpString);
				}
			}
		});
				

		
		abc.setBounds(10, 226, 77, 23);
		frame.getContentPane().add(abc);
		
		JButton def = new JButton("def");
		def.setBounds(97, 226, 77, 23);
		frame.getContentPane().add(def);
		def.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		JButton ghi = new JButton("ghi");
		ghi.setBounds(10, 260, 77, 23);
		frame.getContentPane().add(ghi);
		
		JButton jkl = new JButton("jkl");
		jkl.setBounds(97, 260, 77, 23);
		frame.getContentPane().add(jkl);
		
		JButton mno = new JButton("mno");
		mno.setBounds(10, 294, 77, 23);
		frame.getContentPane().add(mno);
		
		JButton pqr = new JButton("pqr");
		pqr.setBounds(97, 294, 77, 23);
		frame.getContentPane().add(pqr);
		
		JButton stuv = new JButton("stuv");
		stuv.setBounds(10, 328, 77, 23);
		frame.getContentPane().add(stuv);
		
		JButton wxyz = new JButton("wxyz");
		wxyz.setBounds(97, 328, 77, 23);
		frame.getContentPane().add(wxyz);
		
		JButton dm = new JButton("D/M");
		dm.setBounds(97, 192, 77, 23);
		frame.getContentPane().add(dm);
		
		JButton cButton = new JButton("C");
		cButton.setBounds(10, 192, 77, 23);
		frame.getContentPane().add(cButton);
		
		JButton minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		minusButton.setBounds(184, 226, 50, 23);
		frame.getContentPane().add(minusButton);
		
		JButton divideButton = new JButton("/");
		divideButton.setBounds(184, 260, 50, 23);
		frame.getContentPane().add(divideButton);
		
		JButton equalsButton = new JButton("=");
		equalsButton.setBounds(184, 294, 50, 57);
		frame.getContentPane().add(equalsButton);
		
		JButton plusButton = new JButton("+");
		plusButton.setBounds(184, 192, 50, 23);
		frame.getContentPane().add(plusButton);


	}
}
