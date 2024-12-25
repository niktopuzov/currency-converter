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
		panel.add(new JLabel("From"));
		panel.add(comboBoxFromCurrency);
		panel.add(new JLabel("To"));
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

			float exchangeRate = getExchangeRate(fromCurrency, toCurrency);
			float convertedAmount = amount * exchangeRate;

			textFieldConvertAmount.setText(String.format("%.2f", convertedAmount));
		}
	}

	class DeleteButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			textFieldAmount.setText("");
			textFieldConvertAmount.setText("");
		}
	}

	private float getExchangeRate(String fromCurrency, String toCurrency) {

		if (fromCurrency.equals("Euro (EUR)") && toCurrency.equals("US Dollar (USD)")) {
			return 1.05f;
		} else if (fromCurrency.equals("US Dollar (USD)") && toCurrency.equals("Euro (EUR)")) {
			return 0.95f;
		} else if (fromCurrency.equals("Euro (EUR)") && toCurrency.equals("Bulgarian Lev (BGN)")) {
			return 1.95f;
		} else if (fromCurrency.equals("Bulgarian Lev (BGN)") && toCurrency.equals("Euro (EUR)")) {
			return 0.5f;
		} else if (fromCurrency.equals("US Dollar (USD)") && toCurrency.equals("Bulgarian Lev (BGN)")) {
			return 1.85f;
		} else if (fromCurrency.equals("Bulgarian Lev (BGN)") && toCurrency.equals("US Dollar (USD)")) {
			return 0.55f;
		}
		
		// Default
		return 1.0f;
	}
}
