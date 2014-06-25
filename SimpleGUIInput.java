import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class StringTooLongException extends RuntimeException {
	String content;

	StringTooLongException() {
		this.content = "ERROR: invalid input";
	}

	StringTooLongException(String content) {
		this.content = content;
	}

	public String getMessage() {
		return this.content;
	}

}

public class SimpleGUIInput {
	JFrame simple     = new JFrame();
	JTextField text   = new JTextField();
	JTextField output = new JTextField();
	JButton submit    = new JButton("submit");
	JButton quit      = new JButton("quit");

	class MySubmitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			run(text.getText());
		}
	}

	public void run(String str) throws StringTooLongException {
		try{
			if (str.length() > 5) {
				throw new StringTooLongException();
			}else {
				output.setText("Deal.\n");
			}
		}catch(RuntimeException e){
			output.setText(e.getMessage() + "\n");
		}
	}

	class MyQuitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}

	SimpleGUIInput() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					submit.addActionListener(new MySubmitButtonListener());
					quit.addActionListener(new MyQuitButtonListener());
					simple.setLayout(new GridLayout(10, 1));
					simple.add(text);
					simple.add(output);
					simple.add(submit);
					simple.add(submit);
					simple.add(quit);
					simple.setTitle("Just A Simple One.");
					simple.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					simple.setSize(654, 654);
					simple.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		SimpleGUIInput one = new SimpleGUIInput();
	}

}
