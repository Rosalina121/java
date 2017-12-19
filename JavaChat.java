import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class JavaChat {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaChat window = new JavaChat();
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
	public JavaChat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	String message = "";
	String userName = "";
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(10, 306, 346, 76);
		textArea.setBorder(border);
		frame.getContentPane().add(textArea);	
		textArea.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode() == 10) {
				if(textArea.getText()=="") {
					
				}else {
					message = textArea.getText();
					message.replaceAll("\n", "");
					System.out.println(message);
					textArea.setText("");
				}
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JTextArea
		textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 11, 346, 284);
		textArea_1.setBorder(border);
		frame.getContentPane().add(textArea_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(366, 79, 58, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnLeave = new JButton("Lea.");
		btnLeave.setBounds(366, 45, 58, 23);
		frame.getContentPane().add(btnLeave);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText() != "") userName = textField.getText();
			}
		});
		btnJoin.setBounds(366, 11, 58, 23);
		frame.getContentPane().add(btnJoin);
		
		JButton btnReg = new JButton("Reg.");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReg.setBounds(366, 325, 58, 23);
		frame.getContentPane().add(btnReg);
		
		JButton btnUnr = new JButton("Unr.");
		btnUnr.setBounds(366, 359, 58, 23);
		frame.getContentPane().add(btnUnr);
		
		textField = new JTextField();
		textField.setBounds(366, 294, 58, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(366, 269, 58, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
