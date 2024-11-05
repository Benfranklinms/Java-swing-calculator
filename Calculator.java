import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {
    private JFrame frame;
    private JTextField display;
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnMul, btnDiv, btnC, btnEQ;
    private String operator;
    private double num1, num2, result;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        display = new JTextField(100);
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 40));
        display.setBackground(Color.decode("#333333"));
        display.setForeground(Color.WHITE);
        display.setPreferredSize(new Dimension(300, 80));
        frame.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.decode("#444444"));
        frame.add(panel, BorderLayout.CENTER);

        btn0 = createButton("0");
        btn1 = createButton("1");
        btn2 = createButton("2");
        btn3 = createButton("3");
        btn4 = createButton("4");
        btn5 = createButton("5");
        btn6 = createButton("6");
        btn7 = createButton("7");
        btn8 = createButton("8");
        btn9 = createButton("9");
        btnAdd = createButton("+");
        btnSub = createButton("-");
        btnMul = createButton("x");
        btnDiv = createButton("/");
        btnC = createButton("C");
        btnEQ = createButton("=");

        btnAdd.setBackground(Color.decode("#e69b00"));
        btnSub.setBackground(Color.decode("#e69b00"));
        btnMul.setBackground(Color.decode("#e69b00"));
        btnDiv.setBackground(Color.decode("#e69b00"));
        btnEQ.setBackground(Color.decode("#e69b00"));
        btnC.setBackground(Color.decode("#e69b00"));

        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btnAdd);

        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btnSub);

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btnMul);

        panel.add(btn0);
        panel.add(btnC);
        panel.add(btnEQ);
        panel.add(btnDiv);

        frame.setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setBackground(Color.decode("#FAFAFA"));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.addActionListener(new ButtonClickListener());
        return button;
    }

  private class ButtonClickListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Character.isDigit(command.charAt(0))) {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
            operator = "";  
            num1 = num2 = result = 0;
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            calculate();
            display.setText(String.valueOf(result));
            operator = "";  
        } else {
            if (operator != null && !operator.isEmpty()) return;
            operator = command;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        }
    }
}

private void calculate() {
    switch (operator) {
        case "+":
            result = num1 + num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "x":
            result = num1 * num2;
            break;
        case "/":
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                display.setText("ERROR");
                return;
            }
            break;
        default:
            break;
    }
}


    public static void main(String[] args) {
        new Calculator();
    }
}
