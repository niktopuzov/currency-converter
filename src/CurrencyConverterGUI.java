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

		/*
		panel.setLayout(new GridLayout(3, 2));
		panel.add(euroL);
		panel.add(textFieldEURO);
		panel.add(usdL);
		panel.add(textFieldUSD);
		panel.add(exchangeRateL);
		panel.add(textFieldExchangeRate);
		*/

		panelBTN.add(btnCalculate);
		panelBTN.add(btnDelete);

		// Add panels to the frame
		this.add(panel, BorderLayout.CENTER);
		this.add(panelBTN, BorderLayout.SOUTH);

		btnCalculate.addActionListener(new CalculateButton());
		btnDelete.addActionListener(new DeleteButton());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	class CalculateButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (textFieldUSD.getText().equals("")) {
				textFieldUSD.setText("$" + String.format("%.2f",
						Float.parseFloat(textFieldEURO.getText()) / Float.parseFloat(textFieldExchangeRate.getText())));
			} else {
				textFieldEURO.setText("" + String.format("%.2f",
						Float.parseFloat(textFieldUSD.getText()) * Float.parseFloat(textFieldExchangeRate.getText())) + "€");
			}
		}
	}

	class DeleteButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textFieldEURO.setText("");
			textFieldUSD.setText("");
		}
	}
}
