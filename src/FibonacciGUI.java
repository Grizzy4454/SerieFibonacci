import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import javax.swing.*;

public class FibonacciGUI extends JFrame {

    private JTextField textField;
    private JTextArea textArea;

    public FibonacciGUI() {
        setTitle("Calculadora de Fibonacci");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Número de elementos:"));
        textField = new JTextField(10);
        inputPanel.add(textField);

        JButton calculateButton = new JButton("Calcular");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateFibonacci();
            }
        });
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private void calculateFibonacci() {
        try {
            int limite = Integer.parseInt(textField.getText());

            StringBuilder resultBuilder = new StringBuilder();
            Main.Fibonacci fibonacci = new Main.FibonacciRecursivo();
            for (int i = 0; i < limite; i++) {
                BigInteger resultado = fibonacci.calcularFibonacci(i);
                resultBuilder.append(resultado).append(", ");
            }
            textArea.setText(resultBuilder.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FibonacciGUI gui = new FibonacciGUI();
                gui.setVisible(true);
            }
        });
    }
}

