/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task3;
import Task3.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentManagementGUI extends JFrame {
    private JTextField tfRoll, tfName, tfCourse;
    private JButton btnAdd, btnUpdate, btnDelete, btnClear;
    private JTable table;
    private DefaultTableModel tableModel;

    private java.util.List<Student> studentList = new ArrayList<>();

    public StudentManagementGUI() {
        setTitle("Student Information System");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tfRoll = new JTextField(10);
        tfName = new JTextField(10);
        tfCourse = new JTextField(10);

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");

        tableModel = new DefaultTableModel(new String[]{"Roll No", "Name", "Course"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Roll No:"));
        inputPanel.add(tfRoll);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(tfName);
        inputPanel.add(new JLabel("Course:"));
        inputPanel.add(tfCourse);
        inputPanel.add(btnAdd);
        inputPanel.add(btnUpdate);

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnDelete);
        btnPanel.add(btnClear);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        // Event Listeners
        btnAdd.addActionListener(e -> addStudent());
        btnUpdate.addActionListener(e -> updateStudent());
        btnDelete.addActionListener(e -> deleteStudent());
        btnClear.addActionListener(e -> clearFields());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                tfRoll.setText(tableModel.getValueAt(row, 0).toString());
                tfName.setText(tableModel.getValueAt(row, 1).toString());
                tfCourse.setText(tableModel.getValueAt(row, 2).toString());
            }
        });
    }

    private void addStudent() {
        String roll = tfRoll.getText();
        String name = tfName.getText();
        String course = tfCourse.getText();

        if (roll.isEmpty() || name.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill all fields!");
            return;
        }

        for (Student s : studentList) {
            if (s.getRollNo().equals(roll)) {
                JOptionPane.showMessageDialog(this, "Roll No already exists!");
                return;
            }
        }

        Student student = new Student(roll, name, course);
        studentList.add(student);
        tableModel.addRow(new Object[]{roll, name, course});
        clearFields();
    }

    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a student to update.");
            return;
        }

        String roll = tfRoll.getText();
        String name = tfName.getText();
        String course = tfCourse.getText();

        for (Student s : studentList) {
            if (s.getRollNo().equals(roll)) {
                s.setName(name);
                s.setCourse(course);
                break;
            }
        }

        tableModel.setValueAt(name, selectedRow, 1);
        tableModel.setValueAt(course, selectedRow, 2);
        clearFields();
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a student to delete.");
            return;
        }

        String roll = tableModel.getValueAt(selectedRow, 0).toString();

        studentList.removeIf(s -> s.getRollNo().equals(roll));
        tableModel.removeRow(selectedRow);
        clearFields();
    }

    private void clearFields() {
        tfRoll.setText("");
        tfName.setText("");
        tfCourse.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentManagementGUI().setVisible(true);
        });
    }
}

