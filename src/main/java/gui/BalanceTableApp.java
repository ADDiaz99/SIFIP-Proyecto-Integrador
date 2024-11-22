/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class BalanceTableApp {
    private JFrame frame;
    private JTextField amountField;
    private JTextField descriptionField;
    private JTable transactionsTable;
    private DefaultTableModel tableModel;
    private JLabel balanceLabel;
    private double balance = 0.0;
    private final String DATA_FILE = "transactions.csv"; // Cambia aquí si necesitas una ruta absoluta

    public BalanceTableApp() {
        // Crear la ventana principal
        frame = new JFrame("Balance con Historial");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Crear el modelo de tabla
        tableModel = new DefaultTableModel(new String[]{"Fecha", "Descripción", "Monto", "Tipo"}, 0);
        transactionsTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(transactionsTable);

        // Crear el panel superior para entradas
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        inputPanel.add(new JLabel("Monto:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        inputPanel.add(new JLabel("Descripción:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        JButton addIncomeButton = new JButton("Agregar Ingreso");
        JButton addExpenseButton = new JButton("Agregar Gasto");

        inputPanel.add(addIncomeButton);
        inputPanel.add(addExpenseButton);

        // Crear el panel inferior para mostrar el balance
        JPanel balancePanel = new JPanel();
        balanceLabel = new JLabel("Balance: $0.0");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balancePanel.add(balanceLabel);

        // Cargar los datos del archivo
        loadTransactions();

        // Agregar acción a los botones
        addIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction("Ingreso");
            }
        });

        addExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction("Gasto");
            }
        });

        // Agregar los paneles a la ventana principal
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(balancePanel, BorderLayout.SOUTH);

        // Guardar los datos al cerrar la ventana
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                saveTransactions();
            }
        });

        frame.setVisible(true);
    }

    private void addTransaction(String type) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String description = descriptionField.getText();

            if (amount <= 0) {
                JOptionPane.showMessageDialog(frame, "El monto debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (description.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "La descripción no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar el balance
            if (type.equals("Ingreso")) {
                balance += amount;
            } else {
                balance -= amount;
            }

            updateBalanceLabel();

            // Agregar la transacción a la tabla
            tableModel.addRow(new Object[]{
                    java.time.LocalDate.now().toString(),
                    description,
                    String.format("%.2f", amount),
                    type
            });

            // Limpiar campos de texto
            amountField.setText("");
            descriptionField.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Por favor ingrese un número válido para el monto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateBalanceLabel() {
        if (balanceLabel != null) {
            balanceLabel.setText("Balance: $" + String.format("%.2f", balance));
        }
    }
    
    private void saveTransactions() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
        // Guardar cada fila de la tabla en el archivo
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String date = tableModel.getValueAt(i, 0).toString();      // Fecha
            String description = tableModel.getValueAt(i, 1).toString(); // Descripción
            String amount = tableModel.getValueAt(i, 2).toString();    // Monto
            String type = tableModel.getValueAt(i, 3).toString();      // Tipo (Ingreso/Gasto)
            writer.println(date + "," + description + "," + amount + "," + type);
        }
        // Guardar el balance actual al final del archivo
        writer.println("Balance," + balance);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(frame, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void loadTransactions() {
    try (Scanner scanner = new Scanner(new File(DATA_FILE))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 4) {
                // Es una transacción: Fecha, Descripción, Monto, Tipo
                tableModel.addRow(parts);
            } else if (parts.length == 2 && parts[0].equals("Balance")) {
                // Es el balance: "Balance,<valor>"
                balance = Double.parseDouble(parts[1]);
            }
        }
        updateBalanceLabel();
    } catch (FileNotFoundException e) {
        // No hacer nada si el archivo no existe
    } catch (Exception e) {
        JOptionPane.showMessageDialog(frame, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(BalanceTableApp::new);
    }
}
