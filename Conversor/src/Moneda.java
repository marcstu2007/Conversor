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

public class Moneda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Moneda dialog = new Moneda(4);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Moneda(double cantidad) {
		setBounds(100, 100, 450, 144);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JComboBox comboBox = new JComboBox();
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Elije la moneda para realizar tu conversión");
			lblNewLabel.setBounds(10, 14, 251, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Convertir de la moneda de Quetzal a Dólar", "Convertir de la moneda de Quetzal a Euros", "Convertir de la moneda de Quetzal a Libras Esterlinas", "Convertir de la moneda de Quetzal a Yen Japonés", "Convertir de la moneda de Quetzal a Won sul-coreano", "Convertir de Dólar a la Quetzal", "Convertir de Euros a la Quetzal", "Convertir de Libras Esterlinas a la Quetzal", "Convertir de Yen Japonés a la Quetzal", "Convertir de Won sul-coreano a la Quetzal"}));
			comboBox.setBounds(10, 39, 414, 22);
			contentPanel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						double cambio=0;
						String moneda="";
						switch(comboBox.getSelectedIndex()) {
						case 0:
							cambio=0.13;
							moneda="dolar(es)";
							break;
						case 1:
							cambio=0.12;
							moneda="euros";
							break;
						case 2:
							cambio=0.11;
							moneda="libras esterlinas";
							break;
						case 3:
							cambio=17.60;
							moneda="yen Japonés";
							break;
						case 4:
							cambio=168.56;
							moneda=" won sul-coreano";
							break;
						case 5:
							cambio=7.81;
							moneda="quetzales";
							break;
						case 6:
							cambio=8.24;
							moneda="quetzales";
							break;
						case 7:
							cambio=9.24;
							moneda="quetzales";
							break;
						case 8:
							cambio=0.057;
							moneda="quetzales";
							break;
						case 9:
							cambio=0.0059;
							moneda="quetzales";
							break;
						}
						JOptionPane.showMessageDialog(null, "Tienes: " + (Math.round(cantidad*cambio*100.0)/100.0)  +" "+moneda);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
