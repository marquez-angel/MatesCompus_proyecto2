import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana_p2 extends JPanel implements ActionListener{
	public ArithmeticAnalyzer arAn;
	public GrammarGeneratedArithmetic gga;
	protected JTextField textField;
	protected JTextArea textArea;
	
	public Ventana_p2() {
		super(new GridBagLayout());
		
		textField = new JTextField(20);
		textField.addActionListener(this);
		
		textArea=new JTextArea(30,80);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		
		arAn = new ArithmeticAnalyzer();
		gga= new GrammarGeneratedArithmetic(textArea);

		c.fill = GridBagConstraints.HORIZONTAL;
		add(textField, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		add(scrollPane);
	}

	public void start() {
		JFrame jf= new JFrame("Proyecto segundo parcial");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new Ventana_p2());
		jf.pack();
		jf.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.setText("");
		String ex = textField.getText();
		if(arAn.analyze(ex)) {
			textArea.append("valid \n");
			gga.gen(ex);
			
		}else {
			textArea.append("not valid \n");
		}
		
	}

	public static void main(String[] args) {
		Ventana_p2 v = new Ventana_p2();
		v.start();

	}



}
