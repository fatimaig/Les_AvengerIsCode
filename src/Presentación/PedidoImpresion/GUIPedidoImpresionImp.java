/**
 * 
 */
package Presentaci�n.PedidoImpresion;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Fatimuskii
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Negocio.Dise�o.TDise�o;
import Negocio.Impresora.TImpresora;
import Negocio.Local.TLocal;
import Negocio.Usuario.TUsuario;
import Presentaci�n.GUIMensaje;
import Presentaci�n.Controlador.Controlador;
import Presentaci�n.Controlador.Events;

import java.awt.Font;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GUIPedidoImpresionImp extends GUIPedidoImpresion {

	private JPanel contentPane;
	private GUIAltaPedidoImpresionSeleccion GUIDatos;

	private TUsuario usuarioSol;

	private GUIMensaje res_mensaje;

	/**
	 * Create the frame.
	 */
	public GUIPedidoImpresionImp(TUsuario Log) {
		super();
		this.contentPane = new JPanel();
		this.res_mensaje = new GUIMensaje();
		this.usuarioSol = Log;
		// guiAltaPedidoImpresion = new GUIAltaPedidoImpresion();
		initGUI();
	}

	// Plataforma me pasara: TUsuario usuario, TImpresora impresora, TDise�o
	// dise�o, TLocal local

	public void setUsurio(TUsuario user) {
		this.usuarioSol = user;
	}


	private void initGUI() {

		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		this.setLayout(new BorderLayout());
		this.add(contentPane, BorderLayout.CENTER);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 587, 40);
		contentPane.add(menuBar);

		

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("imagenes\\logoUsu.png"));
		menuBar.add(lblLogo);

		JLabel lbld = new JLabel("");
		lbld.setBounds(12, 53, 288, 304);
		contentPane.add(lbld);
		ImageIcon fot1 = new ImageIcon("imagenes\\3d-printer.png");
		Icon icono1 = new ImageIcon(fot1.getImage().getScaledInstance(
				lbld.getWidth(), lbld.getHeight(), Image.SCALE_DEFAULT));
		lbld.setIcon(icono1);

		JButton btnHacerPedido = new JButton("HACER PEDIDO");
		btnHacerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIDatos = new GUIAltaPedidoImpresionSeleccion(usuarioSol);
				GUIDatos.setVisible(true);
				
				Controlador.getInstance().accion(Events.ALTA_PEDIDO_IMPRESION_LISTADISENIOS, usuarioSol.getIdUsuario());
				Controlador.getInstance().accion(Events.ALTA_PEDIDO_IMPRESION_LISTAIMPRESORAS,null);
				Controlador.getInstance().accion(Events.ALTA_PEDIDO_IMPRESION_LISTALOCALES, null);
				
			}
		});
		btnHacerPedido.setBounds(312, 53, 263, 65);
		btnHacerPedido.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(btnHacerPedido);

		JButton btnBajaPedido = new JButton("CANCELAR PEDIDO\r\n");
		btnBajaPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				res_mensaje.showMessage("Opci�n no implementada. ",
						"CANCELAR PEDIDO", false);
			}
		});
		btnBajaPedido.setBounds(312, 131, 263, 65);
		btnBajaPedido.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(btnBajaPedido);

		JButton btnModificarPedido = new JButton("MODIFICAR PEDIDO\r\n");
		btnModificarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res_mensaje.showMessage("Opci�n no implementada. ",
						"MODIFICAR PEDIDO", false);
			}
		});
		btnModificarPedido.setBounds(312, 292, 263, 65);
		btnModificarPedido.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(btnModificarPedido);

		JButton btnBuscarPedido = new JButton("BUSCAR PEDIDO\r\n");
		btnBuscarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				res_mensaje.showMessage("Opci�n no implementada. ",
						"BUSCAR PEDIDO", false);
			}
		});
		btnBuscarPedido.setBounds(312, 214, 263, 65);
		btnBuscarPedido.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(btnBuscarPedido);
		this.repaint();

	}

	
	
	@Override
	public void update(int event, Object res) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		switch (event) {
		case Events.ALTA_PEDIDO_IMPRESION_LISTADISENIOS_OK:
			GUIDatos.update(event, (ArrayList<TDise�o>) res);
			break;
		case Events.ALTA_PEDIDO_IMPRESION_LISTADISENIOS_KO:
			GUIDatos.update(event, (ArrayList<TDise�o>) res);
			break;
		case Events.ALTA_PEDIDO_IMPRESION_LISTAIMPRESORAS_OK:
			GUIDatos.update(event, (ArrayList<TImpresora>) res);
			break;
		case Events.ALTA_PEDIDO_IMPRESION_LISTAIMPRESORAS_KO:
			GUIDatos.update(event, (ArrayList<TImpresora>) res);
			break;
		case Events.ALTA_PEDIDO_IMPRESION_LISTALOCALES_OK:
			GUIDatos.update(event, (ArrayList<TLocal>) res);
			break;
		case Events.ALTA_PEDIDO_IMPRESION_LISTALOCALES_KO:
			GUIDatos.update(event, (ArrayList<TLocal>) res);
			break;
		
		case Events.ALTA_PEDIDO_IMPRESION_OK:
			res_mensaje.showMessage(
					"Se ha creado un pedido con id: "
							+ (int) res, "REALIZAR PEDIDO", false);
			GUIDatos.dispose();
	
			break;
		case Events.ALTA_PEDIDO_IMPRESION_KO:
			res_mensaje.showMessage("Error en la creaci�n del Pedido :( .",
					"REALIZAR PEDIDO", false);
			GUIDatos.dispose();
			break;
		
		}
				
	}

}
