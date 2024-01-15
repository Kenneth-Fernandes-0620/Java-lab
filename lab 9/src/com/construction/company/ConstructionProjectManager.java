package com.construction.company;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.*;

import javax.swing.table.DefaultTableModel;

import com.construction.utility.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConstructionProjectManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private List<ConstructionTask> site_A;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ConstructionProjectManager frame = new ConstructionProjectManager();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ConstructionProjectManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Task No", "Task Type", "Hours", "Task Related Data" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(66);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(174);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 53, 416, 199);
		
		contentPane.add(scrollPane);
		contentPane.add(table.getTableHeader());
		
		JButton addConcreteTask = new JButton("Add Concrete Task");
		addConcreteTask.addActionListener((e) -> {

		});
		addConcreteTask.setBounds(36, 268, 148, 27);
		contentPane.add(addConcreteTask);

		JButton addExcavationTaskButton = new JButton("Add Excavation Task");
		addExcavationTaskButton.addActionListener((e) -> {
			createEvacuationTask();
		});
		addExcavationTaskButton.setBounds(247, 268, 160, 27);
		contentPane.add(addExcavationTaskButton);

		JLabel headingLabel = new JLabel("Construction Tasks");
		headingLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		headingLabel.setBounds(119, 16, 160, 27);
		contentPane.add(headingLabel);

		site_A = new ArrayList<>();
	}

	public void createEvacuationTask() {
		TaskCreationDialog dialog = new TaskCreationDialog(this, "New Excavation Task", true);
		dialog.setVisible(true);

		// Get user input after the dialog is closed
		int hours = dialog.getHours();
		float hourlyRate = dialog.getHourlyRate();
		if (hours != -1 && hourlyRate != -1) {
			JOptionPane.showMessageDialog(this, "User entered: " + hours + "hours and " + hourlyRate + " hourly Rate");
			site_A.add(new ExcavationTask(10, 5));
		} else {
			JOptionPane.showMessageDialog(this, "User canceled input.");
		}
	}

	public void createConcreteTask() {

	}
}
