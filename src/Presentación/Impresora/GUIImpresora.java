/**
 * 
 */
package Presentación.Impresora;

import javax.swing.JFrame;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Fatimuskii
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@SuppressWarnings("serial")
public abstract class GUIImpresora extends JFrame{
	private static GUIImpresora instance;
	public abstract void initGUI();
	
	public static GUIImpresora getInstance() {
		if(instance == null)
			instance = new GUIImpresoraImp();
		instance.setVisible(true);
		return instance;
	}
}