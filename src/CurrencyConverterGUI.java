import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverterGUI extends JFrame{
	
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
		
		
		
	}
}
