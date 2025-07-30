/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;
import Task2.InventoryItem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InventoryManager extends JFrame {
    private ArrayList<InventoryItem> inventory = new ArrayList<>();
    private DefaultTableModel model;
    private JTable table;
    private JTextField nameField, quantityField, priceField;

    public InventoryManager() {
        setTitle("Inventory Management System");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // GUI layout
        setLayout(new BorderLayout());

        // Table model
        model = new DefaultTableModel(new Object[]{"Item Name", "Quantity", "Price"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Input fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();

        inputPanel.add(new JLabel("Item Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        inputPanel.add(addBtn);
        inputPanel.add(updateBtn);
        inputPanel.add(deleteBtn);

        add(inputPanel, BorderLayout.SOUTH);

        // Event Handlers
        addBtn.addActionListener(e -> addItem());
        updateBtn.addActionListener(e -> updateItem());
        deleteBtn.addActionListener(e -> deleteItem());

        // Show GUI
        setVisible(true);
    }

    private void addItem() {
        try {
            String name = nameField.getText();
            int qty = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            InventoryItem item = new InventoryItem(name, qty, price);
            inventory.add(item);
            model.addRow(new Object[]{name, qty, price});

            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Enter valid data!");
        }
    }

    private void updateItem() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            try {
                String name = nameField.getText();
                int qty = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());

                InventoryItem item = inventory.get(row);
                item.setName(name);
                item.setQuantity(qty);
                item.setPrice(price);

                model.setValueAt(name, row, 0);
                model.setValueAt(qty, row, 1);
                model.setValueAt(price, row, 2);

                clearFields();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid update values!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to update!");
        }
    }

    private void deleteItem() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            inventory.remove(row);
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete!");
        }
    }

    private void clearFields() {
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryManager::new);
    }
}
