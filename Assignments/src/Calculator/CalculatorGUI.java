package Calculator;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CalculatorGUI implements ActionListener{
	
	double num1 = 0, num2 = 0, result = 0;
	int calculation;
	
	JFrame frame = new JFrame("Calculator");
	JLabel label = new JLabel();
	JTextField textField = new JTextField();
	JRadioButton onRadioButton = new JRadioButton("on");
	JRadioButton offRadioButton = new JRadioButton("off");
	JButton buttonZero = new JButton("0");
	JButton buttonOne = new JButton("1");
	JButton buttonTwo = new JButton("2");
	JButton buttonThree = new JButton("3");
	JButton buttonFour = new JButton("4");
	JButton buttonFive = new JButton("5");
	JButton buttonSix = new JButton("6");
	JButton buttonSeven = new JButton("7");
	JButton buttonEight = new JButton("8");
	JButton buttonNine = new JButton("9");
	JButton buttonDot = new JButton(".");
	
	JButton buttonClear = new JButton("C");
	JButton buttonDelete = new JButton("Del");
	
	JButton buttonEqual = new JButton("=");
	JButton buttonMul = new JButton("x");
	JButton buttonDiv = new JButton("/");
	JButton buttonAdd = new JButton("+");
	JButton buttonSub = new JButton("-");
	JButton buttonSquare = new JButton("x\u00B2");
	JButton buttonReciprocal = new JButton("1/x");
	JButton buttonSqrt = new JButton("\u221A");
	
	// Short Version put all the button in Array
	JButton[] buttons = {buttonOne, buttonTwo, buttonThree, buttonFour, 
			buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, 
			buttonZero, buttonClear, buttonDelete, buttonDot, buttonAdd,
			buttonSub, buttonMul, buttonDiv, buttonSquare, buttonSqrt,
			buttonReciprocal, buttonEqual};
	


	public CalculatorGUI() {
		
		isEmptyBtn();
		
		textField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				isEmptyBtn();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				isEmptyBtn();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				isEmptyBtn();
				
			}
		});
		
		prepareGui();
		addComponents();
		addActionEvent();
	}
	
	public void prepareGui() {
		frame.setSize(305, 510);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addComponents() {
		label.setBounds(250, 0, 50, 50);
		label.setForeground(Color.white);
		frame.add(label);
		
		textField.setBounds(10, 40, 270, 40);
		textField.setFont(new Font("Ariel", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.add(textField);
		
		onRadioButton.setBounds(10, 95, 60, 40);
		onRadioButton.setSelected(true);
		onRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
		onRadioButton.setBackground(Color.black);
		onRadioButton.setForeground(Color.white);
		frame.add(onRadioButton);
		
		offRadioButton.setBounds(10, 120, 60, 40);
		offRadioButton.setSelected(true);
		offRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
		offRadioButton.setBackground(Color.black);
		offRadioButton.setForeground(Color.white);
		frame.add(offRadioButton);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(onRadioButton);
		buttonGroup.add(offRadioButton);
		
		
		for (JButton button : buttons) {
			button.setFont(new Font("Arial", Font.BOLD, 20));
			button.setFocusable(false);
			frame.add(button);
		}
		
		// Seven 7
		buttonSeven.setBounds(10, 230, 60, 40);

		// Eight 8
		buttonEight.setBounds(80, 230, 60, 40);

		// Nine 9
		buttonNine.setBounds(150, 230, 60, 40);

		// Four 4
		buttonFour.setBounds(10, 290, 60, 40);

		// Five 5
		buttonFive.setBounds(80, 290, 60, 40);

		// Six 6
		buttonSix.setBounds(150, 290, 60, 40);

		// One 1
		buttonOne.setBounds(10, 350, 60, 40);

		// Two 2
		buttonTwo.setBounds(80, 350, 60, 40);

		// Three 3
		buttonThree.setBounds(150, 350, 60, 40);

		// Zero 0
		buttonZero.setBounds(10, 410, 130, 40);
		
		// Dot
		buttonDot.setBounds(150, 410, 60, 40);

		
		// Equal
		buttonEqual.setBounds(220, 350, 60, 100);
		buttonEqual.setBackground(new Color(239, 188, 2));

		
		// Division
		buttonDiv.setBounds(220, 110, 60, 40);
		buttonDiv.setBackground(new Color(239, 188, 2));

		
		// Square root
		buttonSqrt.setBounds(10, 170, 60, 40);
		buttonSqrt.setBackground(new Color(239, 188, 2));

		
		// Multiplication
		buttonMul.setBounds(220, 230, 60, 40);
		buttonMul.setBackground(new Color(239, 188, 2));

		
		// Subtraction
		buttonSub.setBounds(220, 170, 60, 40);
		buttonSub.setBackground(new Color(239, 188, 2));

		
		// Addition
		buttonAdd.setBounds(220, 290, 60, 40);
		buttonAdd.setBackground(new Color(239, 188, 2));
		
		// Square
		buttonSquare.setBounds(80, 170, 60, 40);
		buttonSquare.setBackground(new Color(239, 188, 2));

		
		// Reciprocal
		buttonReciprocal.setBounds(150, 170, 60, 40);
		buttonReciprocal.setFont(new Font("Arial", Font.BOLD, 14));
		buttonReciprocal.setBackground(new Color(239, 188, 2));

		// Delete
		buttonDelete.setBounds(150, 110, 60, 40);
		buttonDelete.setFont(new Font("Arial", Font.BOLD, 14));
		buttonDelete.setBackground(Color.red);
		buttonDelete.setForeground(Color.white);
		
		// Clear
		buttonClear.setBounds(80, 110, 60, 40);
		buttonClear.setBackground(Color.red);
		buttonClear.setForeground(Color.white);

	}
	
	public void addActionEvent() {
		onRadioButton.addActionListener(this);
		offRadioButton.addActionListener(this);

		for (JButton button : buttons) {
			button.addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		
		if (source == onRadioButton) {
			enable();
		} else if (source == offRadioButton) {
			disable();
		} else if (source == buttonClear) {
			label.setText(null);
			textField.setText(null);
		} else if (source == buttonDelete) {
			int length = textField.getText().length();
			int number = length - 1;
			if (length > 0) {
				StringBuilder back = new StringBuilder(textField.getText());
				back.deleteCharAt(number);
				textField.setText(back.toString());
			}
			if (textField.getText().endsWith("")) {
				label.setText("");
			}
		} else if (source == buttonZero) {
			if (textField.getText().equals("0")) {
				return;
			} else {
				textField.setText(textField.getText() + "0");
			}
		} else if (source == buttonOne) {
			textField.setText(textField.getText() + "1");
		} else if (source == buttonTwo) {
			textField.setText(textField.getText() + "2");
		} else if (source == buttonThree) {
			textField.setText(textField.getText() + "3");
		} else if (source == buttonFour) {
			textField.setText(textField.getText() + "4");
		} else if (source == buttonFive) {
			textField.setText(textField.getText() + "5");
		} else if (source == buttonSix) {
			textField.setText(textField.getText() + "6");
		} else if (source == buttonSeven) {
			textField.setText(textField.getText() + "7");
		} else if (source == buttonEight) {
			textField.setText(textField.getText() + "8");
		} else if (source == buttonNine) {
			textField.setText(textField.getText() + "9");
		} else if (source == buttonDot) {
			if (textField.getText().contains(".")) {
				return;
			} else {
				textField.setText(textField.getText() + ".");
			}
		} else if (source == buttonAdd) {
			String str = textField.getText();
			num1 = Double.parseDouble(textField.getText());
			calculation = 1;
			textField.setText("");
			label.setText(str + "+");
		} else if (source == buttonSub) {
			String str = textField.getText();
			num1 = Double.parseDouble(textField.getText());
			calculation = 2;
			textField.setText("");
			label.setText(str + "-");
		} else if (source == buttonMul) {
			String str = textField.getText();
			num1 = Double.parseDouble(textField.getText());
			calculation = 3;
			textField.setText("");
			label.setText(str + "*");
		} else if (source == buttonDiv) {
			String string = textField.getText();
			num1 = Double.parseDouble(textField.getText());
			calculation = 4;
			textField.setText("");
			label.setText(string + "/");
		} else if (source == buttonSquare) {
			num1 = Double.parseDouble(textField.getText());
			double square = Math.pow(num1, 2);
			String string= Double.toString(square);
			if (string.endsWith(".0")) {
				textField.setText(string.replace(".0", ""));
			} else {
				textField.setText(string);
			}
		} else if (source == buttonSqrt) {
			num1 = Double.parseDouble(textField.getText());
			double sqrt = Math.sqrt(num1);
			textField.setText(Double.toString(sqrt));
		} else if (source == buttonReciprocal) {
			num1 = Double.parseDouble(textField.getText());
			double reciprocal = 1/num1;
			String string = Double.toString(reciprocal);
			if(string.endsWith(".0")) {
				textField.setText(string.replace(".0", ""));
			} else {
				textField.setText(string);
			}
		} else if (source == buttonEqual) {
			num2 = Double.parseDouble(textField.getText());
			
			switch(calculation) {
			case 1:
				result = num1 + num2;
				break;
			case 2:
				result = num1 - num2;
				break;
			case 3:
				result = num1 * num2;
				break;
			case 4:
				result = num1 / num2;
				break;
			}

			if (Double.toString(result).endsWith(".0")) {
				textField.setText(Double.toString(result).replace(".0",""));
			} else {
				textField.setText(Double.toString(result));
			}
			label.setText("");
			num1 = result;
		}
	}
	
	public void enable() {
		onRadioButton.setEnabled(false);
		offRadioButton.setEnabled(true);
		label.setEnabled(true);
		// all button loop to setEnable(true)
		for (JButton button : buttons) {
			button.setEnabled(true);
		}
	}
	
	public void disable() {
		onRadioButton.setEnabled(true);
		offRadioButton.setEnabled(false);
		label.setEnabled(false);
		label.setText("");
		textField.setText("");
		// all button loop to setEnable(false)
		for (JButton button : buttons) {
			button.setEnabled(false);
		}

	}
	
	public void isEmptyBtn() {
		if (textField.getText().equals("")) {
			buttonAdd.setEnabled(false);
			buttonSub.setEnabled(false);
			buttonMul.setEnabled(false);
			buttonDiv.setEnabled(false);
			buttonSquare.setEnabled(false);
			buttonSqrt.setEnabled(false);
			buttonReciprocal.setEnabled(false);
			buttonEqual.setEnabled(false);
		} else {
			buttonAdd.setEnabled(true);
			buttonSub.setEnabled(true);
			buttonMul.setEnabled(true);
			buttonDiv.setEnabled(true);
			buttonSquare.setEnabled(true);
			buttonSqrt.setEnabled(true);
			buttonReciprocal.setEnabled(true);
			buttonEqual.setEnabled(true);
		}
	}
}

