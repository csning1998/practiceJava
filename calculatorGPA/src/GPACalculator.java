import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GPACalculator {
    private JFrame frame;
    private JTextField gradeField;
    private JTextField creditField;
    private JTextArea resultArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GPACalculator window = new GPACalculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GPACalculator() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(gradeLabel);

        gradeField = new JTextField();
        gradeField.setBounds(66, 8, 86, 20);
        frame.getContentPane().add(gradeField);
        gradeField.setColumns(10);

        JLabel creditLabel = new JLabel("Credit:");
        creditLabel.setBounds(10, 36, 46, 14);
        frame.getContentPane().add(creditLabel);

        creditField = new JTextField();
        creditField.setBounds(66, 33, 86, 20);
        frame.getContentPane().add(creditField);
        creditField.setColumns(10);

        JButton calculateButton = new JButton("Calculate GPA");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double grade = Double.parseDouble(gradeField.getText());
                    double credit = Double.parseDouble(creditField.getText());
                    double gpa = calculateGPA(grade, credit);
                    resultArea.setText("GPA: " + gpa);
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input. Please enter numeric values for Grade and Credit.");
                }
            }
        });
        calculateButton.setBounds(10, 61, 142, 23);
        frame.getContentPane().add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setBounds(10, 95, 414, 155);
        frame.getContentPane().add(resultArea);
    }

    private double calculateGPA(double grade, double credit) {
        // Conversion logic here
        if (grade >= 90) {
            return 4.0 * credit;
        } else if (grade >= 80) {
            return 3.0 * credit;
        } else if (grade >= 70) {
            return 2.0 * credit;
        } else if (grade >= 60) {
            return 1.0 * credit;
        } else {
            return 0.0;
        }
    }
}
