/**
 * 
 */
package Presentaci�n.PedidoImpresion;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Negocio.Dise�o.TDise�o;
import Negocio.Impresora.TImpresora;
import Negocio.Local.TLocal;
import Negocio.Usuario.TUsuario;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Fatimuskii
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@SuppressWarnings("serial")
public abstract class GUIPedidoImpresion extends JPanel{
	
private static GUIPedidoImpresion instance;
	
	public abstract void update(int event, Object res);
	//public abstract void initGUI();
	
	
	public static GUIPedidoImpresion getInstance(TUsuario userLog) {
		if(instance == null)
			instance = new GUIPedidoImpresionImp(userLog);
		instance.setVisible(true);
		return instance;
	}


}