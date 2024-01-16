package com.construction.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskCreationDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField hoursTextField;
	private JTextField hourlyRateTextField;
	private float hourlyRate = -1;
	private int hours = -1;

	public TaskCreationDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		hoursTextField = new JTextField();
		hourlyRateTextField = new JTextField();
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");

		okButton.addActionListener((e) -> {
			String hoursInput = hoursTextField.getText();
			String hourlyRateInput = hourlyRateTextField.getText();

			try {
				float hourlyRateValue = Float.parseFloat(hourlyRateInput);
				int hoursValue = Integer.parseInt(hoursInput);
				if (hoursValue <= 0 || hourlyRateValue <= 0f) {
					throw new NumberFormatException();
				}
				hours = hoursValue;
				hourlyRate = hourlyRateValue;
			} catch (NumberFormatException nex) {
				JOptionPane.showMessageDialog(this, "Invalid Data Inputted!!");
				return;
			}

			dispose();
		});

		cancelButton.addActionListener((e) -> {
			hours = -1;
			hourlyRate = -1f;
			dispose();
		});

		JPanel dialogRootPanel = new JPanel();
		dialogRootPanel.add(new JLabel("Hours: "));
		dialogRootPanel.add(hoursTextField);
		dialogRootPanel.add(new JLabel("Rate: "));
		dialogRootPanel.add(hourlyRateTextField);
		dialogRootPanel.setLayout(new GridLayout(3, 2));

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);

		dialogRootPanel.add(buttonPanel);

		getContentPane().add(dialogRootPanel);
		pack();
		setLocationRelativeTo(parent);
	}

	public int getHours() {
		return hours;
	}

	public float getHourlyRate() {
		return hourlyRate;
	}

//	public static void main(String[] args) {
//		JFrame frame = new JFrame("String Input Dialog Example");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		JButton showDialogButton = new JButton("Show Dialog");
//		showDialogButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				TaskCreationDialog dialog = new TaskCreationDialog(frame, "Enter String", true);
//				dialog.setVisible(true);
//
//				// Get user input after the dialog is closed
//				String userInput = dialog.getUserInput();
//				if (userInput != null) {
//					JOptionPane.showMessageDialog(frame, "User entered: " + userInput);
//				} else {
//					JOptionPane.showMessageDialog(frame, "User canceled input.");
//				}
//			}
//		});
//
//		frame.getContentPane().add(showDialogButton, BorderLayout.CENTER);
//		frame.setSize(300, 200);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
//	}
}
