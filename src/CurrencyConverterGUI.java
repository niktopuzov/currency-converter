import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverterGUI extends JFrame {

	JButton btnCalculate = new JButton("Calculate");
	JButton btnDelete = new JButton("Delete");

	JTextField textFieldAmount = new JTextField();
	JTextField textFieldConvertAmount = new JTextField();
	
	JLabel amountLabel = new JLabel("Amount");
	JLabel convertedAmountLabel = new JLabel("Converted Amount");
	
	JComboBox<String> comboBoxFromCurrency = new JComboBox<String>();
	JComboBox<String> comboBoxToCurrency = new JComboBox<String>();

	JPanel panel = new JPanel();
	JPanel panelBTN = new JPanel();

	public CurrencyConverterGUI() {

		// Set up the frame
		this.setSize(400, 250);
		this.setLayout(new BorderLayout());

		panel.setLayout(new GridLayout(4, 2));
		
		panel.add(amountLabel);
		panel.add(textFieldAmount);
		panel.add(new JLabel("From Currency"));
		panel.add(comboBoxFromCurrency);
		panel.add(new JLabel("To Currency"));
		panel.add(comboBoxToCurrency);
		panel.add(convertedAmountLabel);
		panel.add(textFieldConvertAmount);
		
		panelBTN.add(btnCalculate);
		panelBTN.add(btnDelete);

		// Add panels to the frame
		this.add(panel, BorderLayout.CENTER);
		this.add(panelBTN, BorderLayout.SOUTH);
		
		comboBoxFromCurrency.addItem("Euro (EUR)");
		comboBoxFromCurrency.addItem("US Dollar (USD)");
		comboBoxFromCurrency.addItem("Bulgarian Lev (BGN)");
		
		comboBoxToCurrency.addItem("Euro (EUR)");
		comboBoxToCurrency.addItem("US Dollar (USD)");
		comboBoxToCurrency.addItem("Bulgarian Lev (BGN)");

		btnCalculate.addActionListener(new CalculateButton());
		btnDelete.addActionListener(new DeleteButton());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	class CalculateButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String fromCurrency = (String) comboBoxFromCurrency.getSelectedItem();
			String toCurrency = (String) comboBoxToCurrency.getSelectedItem();
			
			float amount = 0f;
			
			try {
				amount = Float.parseFloat(textFieldAmount.getText());
			} catch (NumberFormatException ex) {
				textFieldConvertAmount.setText("Invalid Input");
				return;
			}
			
			
		}
	}

	class DeleteButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// textFieldEURO.setText("");
			// textFieldUSD.setText("");
		}
	}
}
