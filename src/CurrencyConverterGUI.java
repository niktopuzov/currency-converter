import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverterGUI extends JFrame {
	
	JButton btnCalculate = new JButton("Calculate");
	JButton btnDelete = new JButton("Delete");
	
	JTextField textFieldEURO = new JTextField();
	JTextField textFieldUSD = new JTextField();
	JTextField textFieldExchangeRate = new JTextField("0.95");
	
	JLabel euroL = new JLabel("Euro");
	JLabel usdL = new JLabel("USD");
	JLabel exchangeRateL = new JLabel("Exchange Rate");
	
	JPanel panel = new JPanel();
	JPanel panelBTN = new JPanel();
	
	public CurrencyConverterGUI() {
		
		// Set up the frame
		this.setSize(400,250);
		this.setLayout(new BorderLayout());
		
		panel.setLayout(new GridLayout(3, 2));
		panel.add(euroL);
		panel.add(textFieldEURO);
		panel.add(usdL);
		panel.add(textFieldUSD);
		panel.add(exchangeRateL);
		panel.add(textFieldExchangeRate);
		
		panelBTN.add(btnCalculate);
		panelBTN.add(btnDelete);
		
		// Add panels to the frame
		this.add(panel, BorderLayout.CENTER);
		this.add(panelBTN, BorderLayout.SOUTH);
		
		btnCalculate.addActionListener(new CalculateButton());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	class CalculateButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(textFieldUSD.getText().equals("")) {
				textFieldUSD.setText("" + Float.parseFloat(textFieldEURO.getText()) / Float.parseFloat(textFieldExchangeRate.getText()));
			}
			else {
				textFieldEURO.setText("" + Float.parseFloat(textFieldUSD.getText()) * Float.parseFloat(textFieldExchangeRate.getText()));
			}
		}
	}
	
	
}
