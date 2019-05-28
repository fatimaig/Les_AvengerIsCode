/**
 * 
 */
package Presentaciķn.Diseņo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import Negocio.Diseņo.TDiseņo;
import Presentaciķn.Controlador.Controlador;
import Presentaciķn.Controlador.Events;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Marina
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@SuppressWarnings("serial")
public class GUIDiseņoImp extends GUIDiseņo {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIAltaDiseņo gUIAltaDiseņo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIBajaDiseņo gUIBajaDiseņo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIModificarDiseņo gUIModificarDiseņo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIListarDiseņos gUIListarDiseņos;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIBuscarPalabraDiseņo gUIBuscarPalabraDiseņo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIListarporUsuarioDiseņo gUIListarporUsuarioDiseņo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIBuscarporIdDiseņo gUIBuscarporIdDiseņo;
	
	private JPanel contentPane;
	private JTextField txtBuscarId;
	private JTextField txtListarIdusuario;
	private JTextField txtBuscarPalabraClave;
	
	public GUIDiseņoImp() {
		super();
		contentPane = new JPanel();
		gUIAltaDiseņo = new GUIAltaDiseņo();
		gUIBajaDiseņo = new GUIBajaDiseņo();
		gUIBuscarPalabraDiseņo = new GUIBuscarPalabraDiseņo();
		gUIBuscarporIdDiseņo = new GUIBuscarporIdDiseņo();
		gUIListarDiseņos = new GUIListarDiseņos();
		gUIListarporUsuarioDiseņo = new GUIListarporUsuarioDiseņo();
		gUIModificarDiseņo = new GUIModificarDiseņo();
		initGUI();
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void initGUI() {
		// begin-user-code
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		this.setLayout(new BorderLayout());
		this.add(contentPane);

		JLabel lblIconoDiseņo = new JLabel("");
		lblIconoDiseņo
				.setIcon(new ImageIcon(
						"imagenes\\IconoDiseņoMenu.png"));

		JButton btnAltaDiseņo = new JButton("Alta Diseņo");
		btnAltaDiseņo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIAltaDiseņo.clearData();
				gUIAltaDiseņo.setVisible(true);
			}
		});

		JButton btnBajaDiseņo = new JButton("Baja Diseņo");
		btnBajaDiseņo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIBajaDiseņo.clearData();
				gUIBajaDiseņo.setVisible(true);
			}
		});

		JButton btnListarDiseos = new JButton("Listar Diseņos");
		btnListarDiseos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIListarDiseņos.clearData();
				gUIListarDiseņos.setVisible(true);
				Controlador.getInstance().accion(Events.LISTAR_DISEŅOS, null);
				gUIListarDiseņos.toFront();
			}
		});

		JButton btnModificarDiseos = new JButton("Modificar Diseņo");
		btnModificarDiseos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIModificarDiseņo.clearData();
				gUIModificarDiseņo.setVisible(true);
			}
		});

		JButton btnListarDiseosPor = new JButton("Listar Diseņos por usuario");
		btnListarDiseosPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(txtListarIdusuario.getText().equals("(idUsuario)")){
						throw new Exception("Introduzca un Usuario");
					}
					int usuario = Integer.parseInt(txtListarIdusuario.getText());
					
					gUIListarporUsuarioDiseņo.clearData();
					gUIListarporUsuarioDiseņo.setVisible(true);
					
					Controlador.getInstance().accion(Events.LISTAR_DISEŅOS_USU, usuario);
					gUIBuscarPalabraDiseņo.toFront();
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnBuscarDiseo = new JButton("Buscar Diseņo");
		btnBuscarDiseo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIBuscarporIdDiseņo.clearData();
				try {
					if(txtBuscarId.getText().equals("(id)")){
						throw new Exception("Introduzca un id");
					}
					int id = Integer.parseInt(txtBuscarId.getText());
					gUIBuscarporIdDiseņo.setVisible(true);
				
					Controlador.getInstance().accion(Events.BUSCAR_DISEŅO_ID, id);
					gUIBuscarporIdDiseņo.toFront();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnBuscarDiseoPor = new JButton(
				"Buscar Diseņos por Palabra Clave");
		btnBuscarDiseoPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(txtBuscarPalabraClave.getText().equals("(palabra clave)")){
						throw new Exception("Introduzca una palabra clave");
					}
					String palabra = txtBuscarPalabraClave.getText();
					gUIBuscarPalabraDiseņo.clearData();
					gUIBuscarPalabraDiseņo.setVisible(true);
					Controlador.getInstance().accion(Events.BUSCAR_DISEŅO_PALABRA_CLAVE, palabra);
					gUIBuscarPalabraDiseņo.toFront();
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		txtBuscarId = new JTextField();
		txtBuscarId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtBuscarId.getText().trim().equals("(id)")) {
					txtBuscarId.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtBuscarId.getText().trim().equals("")) {
					txtBuscarId.setText("(id)");
				}
			}
		});
		txtBuscarId.setText("(id)");
		txtBuscarId.setColumns(10);

		txtListarIdusuario = new JTextField();
		txtListarIdusuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtListarIdusuario.getText().trim().equals("(idUsuario)")) {
					txtListarIdusuario.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtListarIdusuario.getText().trim().equals("")) {
					txtListarIdusuario.setText("(idUsuario)");
				}
			}
		});
		txtListarIdusuario.setText("(idUsuario)");
		txtListarIdusuario.setColumns(10);

		txtBuscarPalabraClave = new JTextField();
		txtBuscarPalabraClave.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtBuscarPalabraClave.getText().trim()
						.equals("(palabra clave)")) {
					txtBuscarPalabraClave.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtBuscarPalabraClave.getText().trim().equals("")) {
					txtBuscarPalabraClave.setText("(palabra clave)");
				}
			}
		});
		txtBuscarPalabraClave.setText("(palabra clave)");
		txtBuscarPalabraClave.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIconoDiseņo, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAltaDiseņo, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(btnListarDiseos, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBajaDiseņo, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(btnModificarDiseos, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
							.addGap(22))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtBuscarId, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnBuscarDiseo, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtListarIdusuario, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnListarDiseosPor, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtBuscarPalabraClave, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(btnBuscarDiseoPor, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))
					.addGap(11))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(btnAltaDiseņo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(btnListarDiseos))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(btnBajaDiseņo)
							.addGap(47)
							.addComponent(btnModificarDiseos))
						.addComponent(lblIconoDiseņo, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtBuscarId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscarDiseo))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtListarIdusuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnListarDiseosPor))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtBuscarPalabraClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscarDiseoPor))
					.addGap(12))
		);
		contentPane.setLayout(gl_contentPane);
				// end-user-code
	}
	
	/** 
	 * (sin Javadoc)
	 * @see GUIDiseņo#update(int event, Object res)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@SuppressWarnings("unchecked")
	public void update(int event, Object res){
		switch (event) {
		case Events.ALTA_DISEŅO_OK:
			gUIAltaDiseņo.update(event, res);
			break;
		case Events.ALTA_DISEŅO_KO:
			gUIAltaDiseņo.update(event, res);
			break;
		case Events.BAJA_DISEŅO_OK:
			gUIBajaDiseņo.update(event, res);
			break;
		case Events.BAJA_DISEŅO_KO:
			gUIBajaDiseņo.update(event, res);
			break;
		case Events.LISTAR_DISEŅOS_OK:
			gUIListarDiseņos.update(event,(ArrayList<TDiseņo>) res);
			break;
		case Events.LISTAR_DISEŅOS_KO:
			gUIListarDiseņos.update(event, (ArrayList<TDiseņo>) res);
			break;
		case Events.BUSCAR_DISEŅO_ID_OK:
			gUIBuscarporIdDiseņo.update(event, (TDiseņo) res);
			break;
		case Events.BUSCAR_DISEŅO_ID_KO:
			gUIBuscarporIdDiseņo.update(event, (TDiseņo) res);
			break;
		case Events.BUSCAR_DISEŅO_PALABRA_CLAVE_OK:
			gUIBuscarPalabraDiseņo.update(event, (ArrayList<TDiseņo>) res);
			break;
		case Events.BUSCAR_DISEŅO_PALABRA_CLAVE_KO:
			gUIBuscarPalabraDiseņo.update(event, (ArrayList<TDiseņo>) res);
			break;
		case Events.MODIFICAR_DISEŅO_OK:
			gUIModificarDiseņo.update(event, res);
			break;
		case Events.MODIFICAR_DISEŅO_KO:
			gUIModificarDiseņo.update(event, res);
			break;
		case Events.MODIFICAR_DISEŅO_COMPROBAR_OK:
			gUIModificarDiseņo.update(event, res);
			break;
		case Events.MODIFICAR_DISEŅO_COMPROBAR_KO:
			gUIModificarDiseņo.update(event, res);
			break;
		case Events.LISTAR_DISEŅOS_USU_OK:
			gUIListarporUsuarioDiseņo.update(event, (ArrayList<TDiseņo>) res);
			break;
		case Events.LISTAR_DISEŅOS_USU_KO:
			gUIListarporUsuarioDiseņo.update(event, (ArrayList<TDiseņo>) res);
			break;
			
		}
		
		
	}
}