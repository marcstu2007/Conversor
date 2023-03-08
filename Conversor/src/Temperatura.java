import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Temperatura extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Temperatura dialog = new Temperatura(4);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Temperatura(double temp) {
		setBounds(100, 100, 364, 153);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 379, 34);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		JComboBox comboBox = new JComboBox();
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Elije una conversión de temperatura");
			lblNewLabel.setBounds(84, 11, 173, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 78, 338, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String factor="";
						switch(comboBox.getSelectedIndex()) {
						case 0:
							factor=Math.round( (temp-32)*5/9*100.0)/100.0 + " grados Celcius";
							break;
						case 1:
							factor=Math.round( temp-273.15)/100.0 + " grados Celcius";
							break;
						case 2:
							factor=Math.round((temp - 491.67) * 5/9)/100.0 + " grados Celcius";
							break;
						case 3:
							factor=Math.round((temp * 9/5) + 32)/100.0 +" grados Fahrenheit";
							break;
						case 4:
							factor= Math.round(temp + 273.15)/100.0+ " grados Kelvin";
							break;
						case 5:
							factor=Math.round(temp * 9/5 + 491.67)/100.0+" grados Rankine"; 
							break;
						}
						dispose();
						JOptionPane.showMessageDialog(null, "Tienes: " + factor);
						int input = JOptionPane.showConfirmDialog(null, "Desea continuar?");
				        // 0=yes, 1=no, 2=cancel
						if (input==0) {
							conversor conversor = new conversor();
							conversor.setVisible(rootPaneCheckingEnabled);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Programa terminado");
							System.exit(0);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"De Fahrenheit a Celcius", "De Kelvin a Celcius", "De Rankine a Celcius", "De Celcius a Fahrenheit", "De Celcius a Kelvin", "De Celcius a Rankine"}));
			comboBox.setBounds(27, 45, 303, 22);
			getContentPane().add(comboBox);
		}
	}
}
