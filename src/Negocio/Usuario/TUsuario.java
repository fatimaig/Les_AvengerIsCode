package Negocio.Usuario;

import java.util.ArrayList;
import java.util.Date;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Stephani
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TUsuario {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int idUsuario;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String nombre;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String apellidos;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String direccion;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String contraseña;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String fechaNacimiento;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	// private Object listaUsuarios;//?
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	private String email;

	private String titularCuenta;

	private String numeroCuenta;

	private String fechaCaducidad;

	//private ArrayList<TUsuario> arrayTUsuario = new ArrayList<>();

	private boolean activo;

	public TUsuario(int idUsuario, String nombre, String apellidos,
			String email, String fechaNacimiento, String direccion,
			String contraseña, String titularCuenta, String numeroCuenta,
			String fechaCaducidad, boolean activo) {

		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.contraseña = contraseña;
		this.titularCuenta = titularCuenta;
		this.numeroCuenta = numeroCuenta;
		this.email = email;
		this.fechaCaducidad = fechaCaducidad;
		this.activo = activo;
	}

	public TUsuario(String nombre, String apellidos, String email,
			String fechaNacimiento, String direccion, String contraseña,
			String titularCuenta, String numeroCuenta, String fechaCaducidad,
			boolean activo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.contraseña = contraseña;
		this.titularCuenta = titularCuenta;
		this.numeroCuenta = numeroCuenta;
		this.email = email;
		this.fechaCaducidad = fechaCaducidad;
		this.activo = activo;

	}

//	public TUsuario(int idUsuario2, String nombre2, String apellidos2,
//			String email2, Date date, String direccion2, String contraseña2,
//			String titularCuenta2, String numeroCuenta2, Date date2,
//			boolean activo2) {
//		// TODO Apéndice de constructor generado automáticamente
//	}

	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	//public ArrayList<TUsuario> getListaUsuarios() {
		//return new ArrayList<TUsuario>(arrayTUsuario);
	//}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param id
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setIdUsuario(int id) {
		this.idUsuario = id;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param nombre
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param apellidos
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param direccion
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param contraseña
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param fechaNacimento
	 * @param fechaNacimiento
	 * @param fechaNacimiento
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param datosBancarios
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	//public void setListaUsuarios(ArrayList<TUsuario> listaUsuarios) {
		//this.arrayTUsuario = listaUsuarios;
	//}

	public String getTitularCuenta() {
		return titularCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;

	}

	public boolean getActivo() {
		return this.activo;

	}

	public void setTitularCuenta(String titularC) {
		this.titularCuenta = titularC;
	}

	public void setNumeroCuenta(String cuentaB) {
		this.numeroCuenta = cuentaB;
	}

	public void setFechaCaducidad(String fechaC) {
		this.fechaCaducidad = fechaC;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}


}