/**
 * 
 */
package Negocio.Impresora;

import java.util.ArrayList;

import Integración.Factoria.FactoriaDAO;
import Integración.Impresora.DAOImpresora;
import Integración.Usuario.DAOUsuario;
import Negocio.Usuario.TUsuario;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Marina
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAImpresoraImp implements SAImpresora {
	/** 
	 * (sin Javadoc)
	 * @see SAImpresora#alta(TImpresora tImpresora)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int alta(TImpresora tImpresora) {
		// begin-user-code
		int id_impresora = -1;
		
		if (tImpresora != null) {	
			DAOUsuario usuarioDAO = FactoriaDAO.getInstance().generateDAOUsuario();

			TUsuario usuario = usuarioDAO.buscarIdUsuario(tImpresora.getUsuario());
			if(usuario != null){
				if(usuario.getActivo()){
					DAOImpresora impresoraDAO = FactoriaDAO.getInstance().generateDAOImpresora();
					tImpresora.setActivo(true);
					id_impresora = impresoraDAO.alta(tImpresora);
				}
			}
		}
		
		return id_impresora;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAImpresora#buscarId(int idImpresora)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TImpresora buscarId(int idImpresora) {
		// begin-user-code
		TImpresora tImpresora = null;
		DAOImpresora impresoraDAO = FactoriaDAO.getInstance().generateDAOImpresora();
		tImpresora = impresoraDAO.buscarId(idImpresora);
		return tImpresora;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAImpresora#buscarPorUsuario(int idUsuario)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TImpresora> buscarPorUsuario(int idUsuario) {
		// begin-user-code
		ArrayList<TImpresora> listaImpresora = null;
		
		//Comprobar que el usuario existe y está activo
		DAOUsuario usuarioDAO = FactoriaDAO.getInstance().generateDAOUsuario();
		TUsuario usu = usuarioDAO.buscarIdUsuario(idUsuario);
		if(usu != null){
			if(usu.getActivo()){
				DAOImpresora impresoraDAO = FactoriaDAO.getInstance().generateDAOImpresora();
				listaImpresora = impresoraDAO.buscarPorUsuario(idUsuario);
			}
		}
		
		return listaImpresora;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAImpresora#listarTodo()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TImpresora> listarTodo() {
		// begin-user-code
		DAOImpresora impresoraDAO = FactoriaDAO.getInstance().generateDAOImpresora();
		ArrayList<TImpresora> listaImpresora = impresoraDAO.listarTodo();
		return listaImpresora;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAImpresora#modificar(TImpresora tImpresora)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificar(TImpresora tImpresora) {
		// begin-user-code
		int id = -1;
		if (tImpresora != null) {

			DAOImpresora impresoraDAO = FactoriaDAO.getInstance().generateDAOImpresora();
			if (tImpresora != null) {
				id = impresoraDAO.modificar(tImpresora);
			}
		}
		return id;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAImpresora#baja(int idImpresora)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int baja(int idImpresora) {
		// begin-user-code
		int id = -1;

		DAOImpresora impresoraDAO = FactoriaDAO.getInstance().generateDAOImpresora();
		
		TImpresora tImpresora;
		tImpresora = impresoraDAO.buscarId(idImpresora);
		if (tImpresora != null) {
			if (tImpresora.getActivo()) {
				id = impresoraDAO.baja(idImpresora);
			}
		}

		return id;
		// end-user-code
	}
}