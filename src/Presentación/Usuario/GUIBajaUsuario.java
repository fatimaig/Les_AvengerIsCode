/**
 * 
 */
package Presentaci�n.Usuario;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Fatimuskii
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIBajaUsuario extends JFrame{
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public GUIBajaUsuario(JPanel contentPane, JTextField textField,
			JPasswordField passwordField) throws HeadlessException {
		super();
		this.contentPane = contentPane;
		this.textField = textField;
		this.passwordField = passwordField;
		initGUI();
	}

	public void initGUI(){
		setTitle("Baja Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIBajaUsuario.class.getResource("/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUIBajaUsuario.class.getResource("/log2.png")));
		lblNewLabel.setBounds(169, 11, 94, 86);
		panel.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("ID");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(62, 120, 46, 14);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(135, 117, 162, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(62, 153, 73, 14);
		panel.add(lblContrasea);
		
		JButton btnConfirmarBaja = new JButton("Confirmar baja");
		btnConfirmarBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showOptionDialog(new JFrame(), "�Est�s seguro?" , "Quit",
						JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, null, null, null);
			}
		});
		btnConfirmarBaja.setBounds(152, 196, 123, 23);
		panel.add(btnConfirmarBaja);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 150, 162, 20);
		panel.add(passwordField);
	}
	
}