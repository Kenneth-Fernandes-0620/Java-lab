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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

public class ConstructionProjectManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int rowCount = 0;

	private final String CONNECTION_URL = "jdbc:mysql://localhost/";
	private final String DATABASE_NAME = "MCA";
	private final String TABLE_NAME = "constructiontasks";
	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	private final String[] columnNames = { "id", "task_type", "hours", "hourlyRate" };

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
		setBounds(100, 100, 609, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Task No", "Task Type", "Task Related Data 1", "Unit", "Task Related Data 2", "Unit" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, String.class, Object.class,
					Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, true, false, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(66);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setMinWidth(105);
		table.getColumnModel().getColumn(4).setPreferredWidth(174);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));

		DefaultTableModel model = ((DefaultTableModel) table.getModel());
		model.addTableModelListener((e) -> {
			if (table.isEditing()) {
				updateRow((int) table.getValueAt(table.getSelectedRow(), 0),
						(String) table.getValueAt(table.getSelectedRow(), 1),
						(int) table.getValueAt(table.getSelectedRow(), 2),
						(float) table.getValueAt(table.getSelectedRow(), 3));
			}
		});

		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						int id = (int) table.getValueAt(selectedRow, 0);
						if (removeTask(selectedRow, id) > 0) {
							model.removeRow(selectedRow);
							JOptionPane.showMessageDialog(ConstructionProjectManager.this, "Row Deleted");
						} else {
							JOptionPane.showMessageDialog(ConstructionProjectManager.this, "Failed to Delete Row");
						}

					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 53, 575, 199);

		contentPane.add(scrollPane);
		contentPane.add(table.getTableHeader());

		JButton addConcreteTask = new JButton("Add Concrete Task");
		addConcreteTask.addActionListener((e) -> {
			createNewTask("Concrete");
		});
		addConcreteTask.setBounds(36, 268, 148, 27);
		contentPane.add(addConcreteTask);

		JButton addExcavationTaskButton = new JButton("Add Excavation Task");
		addExcavationTaskButton.addActionListener((e) -> {
			createNewTask("Excavation");
		});
		addExcavationTaskButton.setBounds(408, 268, 160, 27);
		contentPane.add(addExcavationTaskButton);

		JLabel headingLabel = new JLabel("Construction Tasks");
		headingLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		headingLabel.setBounds(242, 10, 160, 27);
		contentPane.add(headingLabel);

		initialRead();
	}

	public int updateRow(int taskNo, String taskType, int taskRelatedData, float taskRelatedData2) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL + DATABASE_NAME, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement();) {
			PreparedStatement updateEXP = conn
					.prepareStatement("UPDATE constructiontasks SET hours = ?, hourlyRate = ? where id = ? ");
			updateEXP.setInt(1, taskRelatedData);
			updateEXP.setFloat(2, taskRelatedData2);
			updateEXP.setInt(3, taskNo);
			return updateEXP.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return -1;
		}
	}

	public void createNewTask(String taskType) {
		TaskCreationDialog dialog = new TaskCreationDialog(this, "New " + taskType + " Task", true);
		dialog.setVisible(true);

		int hours = dialog.getHours();
		float hourlyRate = dialog.getHourlyRate();

		System.out.println(taskType);

		if (hours != -1 && hourlyRate != -1) {
			JOptionPane.showMessageDialog(this, "User entered: " + hours + " hours and " + hourlyRate + " hourly Rate");
			if (insertIntoDb(taskType + " Task", hours, hourlyRate)) {
				((DefaultTableModel) table.getModel()).addRow(new Object[] { rowCount, taskType + " Task", hours,
						taskType.equals("Excavation") ? "Hours" : "m³", hourlyRate,
						taskType.equals("Excavation") ? "Hourly Rate" : "Cost/m³" });
			} else {
				JOptionPane.showMessageDialog(this, "Failed to add to database");
			}
		} else {
			JOptionPane.showMessageDialog(this, "User canceled input.");
		}
	}

	public void initialRead() {
		final String QUERY = "SELECT id, task_type, hours, hourlyRate FROM constructiontasks";
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL + DATABASE_NAME, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			while (rs.next()) {
				rowCount = rs.getInt("id");
				((DefaultTableModel) table.getModel()).addRow(new Object[] { rs.getInt("id"), rs.getString("task_type"),
						rs.getInt("hours"), rs.getString("task_type").equals("Excavation Task") ? "Hours" : "m³",
						rs.getFloat("hourlyRate"),
						rs.getString("task_type").equals("Excavation Task") ? "Hourly Rate" : "Cost/m³" });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertIntoDb(String task_type, int hours, float hourlyRate) {
		String sql = "INSERT INTO ConstructionTasks(" + columnNames[1] + ", " + columnNames[2] + ", " + columnNames[3]
				+ ")" + " VALUES (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(CONNECTION_URL + DATABASE_NAME, USERNAME, PASSWORD)) {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, task_type);
			preparedStmt.setInt(2, hours);
			preparedStmt.setFloat(3, hourlyRate);
			int updatedRows = preparedStmt.executeUpdate();
			if (updatedRows > 0) {
				rowCount++;
				JOptionPane.showMessageDialog(this, "Data Updated");
				return true;
			} else {
				JOptionPane.showMessageDialog(this, "Failed to add Data");
				return false;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;

	}

	public int removeTask(int rowId, int id) {
		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
		try (Connection connection = DriverManager.getConnection(CONNECTION_URL + DATABASE_NAME, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
