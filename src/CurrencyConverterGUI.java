import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CurrencyConverterGUI extends JFrame{
	
	JButton btnCalculate = new JButton("Calculate");
	JButton btnDelete = new JButton("Delete");
	
	JTextField textFieldEURO = new JTextField();
	JTextField textFieldUSD = new JTextField();
	JTextField textFieldExchangeRate = new JTextField("0.95");
}
