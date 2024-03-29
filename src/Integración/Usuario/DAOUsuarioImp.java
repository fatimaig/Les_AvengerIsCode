package Integración.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.JOptionPane;

import Negocio.Usuario.TUsuario;

import Integración.Conexion.ConexionDAO;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Stephani
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@SuppressWarnings("unused")
public class DAOUsuarioImp implements DAOUsuario {
	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOUsuario#create()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int altaUsuario(TUsuario datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		int idUsuario = -100;
		ConexionDAO con = ConexionDAO.getInstance();
		Connection connection = con.getConexion();

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();				
//				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//				SimpleDateFormat formatter_1 = new SimpleDateFormat("MM/yyyy");
//				String mysqlFechaNac = formatter.format(datos
//						.getFechaNacimiento());
//				String mysqlFechaCad = formatter_1.format(datos
//						.getFechaCaducidad());
				
				String query = "INSERT INTO usuario (nombre, apellidos, email, fechaNacimiento, direccion, contrasenna, titularCuenta, cuentaBancaria, fechaCaducidad, activo)"
						+ " VALUES ('"
						+ datos.getNombre()
						+ "', '"
						+ datos.getApellidos()
						+ "', '"
						+ datos.getEmail()
						+ "', '"
						+ datos.getFechaNacimiento()
						+ "', '"
						+ datos.getDireccion()
						+ "', '"
						+ datos.getContraseña()
						+ "', '"
						+ datos.getTitularCuenta()
						+ "', '"
						+ datos.getNumeroCuenta()
						+ "', '"
						+ datos.getFechaCaducidad()
						+ "', '" + (datos.getActivo() ? 1 : 0) + "');";

				statement.executeUpdate(query);
				query = "SELECT last_insert_id() as last_id from usuario";
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					idUsuario = resultSet.getInt("last_id");
				}
				// connection.close();

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
				e.printStackTrace();
				idUsuario = -100;
			}
		}
		return idUsuario;
		// end-user-code
	}

	public int bajaUsuario(int idUsuario) {
		// begin-user-code
		int result = 00000;
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion(); // conexion SQL

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "UPDATE usuario SET activo=0 WHERE idUsuario="
						+ idUsuario;
				statement.executeUpdate(query);
				result = idUsuario;
				connection.close();
			} catch (SQLException e) {
				result = 00000;
			}
		}
		return result;

	}

	public TUsuario buscarIdUsuario(int idUsuario) {

		TUsuario tUsuario = null;
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM usuario WHERE activo =1 AND idUsuario="
						+ idUsuario;
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					tUsuario = new TUsuario(idUsuario,
							resultSet.getString("nombre"),
							resultSet.getString("apellidos"),
							resultSet.getString("email"),
							resultSet.getString("fechaNacimiento"),
							resultSet.getString("direccion"),
							resultSet.getString("contrasenna"),
							resultSet.getString("titularCuenta"),
							resultSet.getString("cuentaBancaria"),
							resultSet.getString("fechaCaducidad"),
							resultSet.getBoolean("activo"));
				}
			} catch (SQLException e) {
				tUsuario = null;
			}
		}

		return tUsuario;
	}

	public int acceso(String nombre) {
		int idUsu = -100;
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT idUsuario FROM usuario WHERE nombre="
						+ "'"+nombre+"'";
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					idUsu = Integer.parseInt(resultSet.getString("idUsuario"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				idUsu = -100;
			}
		}

		return idUsu;
	}

	public ArrayList<TUsuario> listarUsuarios() {

		ArrayList<TUsuario> listaUsuarios = new ArrayList<>();
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM usuario WHERE activo =1";
				ResultSet resultSet = statement.executeQuery(query);
				TUsuario tUsuario = null;

				while (resultSet.next()) {
					tUsuario = new TUsuario(resultSet.getInt("idUsuario"),
							resultSet.getString("nombre"),
							resultSet.getString("apellidos"),
							resultSet.getString("email"),
							resultSet.getString("fechaNacimiento"),
							resultSet.getString("direccion"),
							resultSet.getString("contrasenna"),
							resultSet.getString("titularCuenta"),
							resultSet.getString("cuentaBancaria"),
							resultSet.getString("fechaCaducidad"),
							resultSet.getBoolean("activo"));
					listaUsuarios.add(tUsuario);
				}
				

			} catch (SQLException e) {
				e.printStackTrace();
				listaUsuarios = null;
			}
		}

		return listaUsuarios;
		// end-user-code
	}

	public TUsuario modificarUsuario(TUsuario tUsuario) {

		//Integer idUsuario = -100;
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection conect = connectionDAO.getConexion();
//		String pattern = "YYYY-MM-DD";
//		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//		String mysqlFechaNac = formatter.format(tUsuario.getFechaNacimiento());
//		String mysqlFechaCad = formatter.format(tUsuario.getFechaCaducidad());
		if (conect != null) {

			try {
				Statement statement = conect.createStatement();
				String query = "UPDATE usuario SET " 
						+ "nombre='" + tUsuario.getNombre() + "', "
						+ "apellidos='" + tUsuario.getApellidos() + "', "
						+ "email='" + tUsuario.getEmail() + "', "
						+ "fechaNacimiento='" + tUsuario.getFechaNacimiento() + "', "
						+ "direccion='" + tUsuario.getDireccion() + "', "
						+ "contrasenna='" + tUsuario.getContraseña() + "', "
						+ "titularCuenta='" + tUsuario.getTitularCuenta() + "', "
						+ "cuentaBancaria='" + tUsuario.getNumeroCuenta() + "', "
						+ "fechaCaducidad='" + tUsuario.getFechaCaducidad() + "', "
						+ "activo=" + (tUsuario.getActivo() ? 1 : 0) + " "
						+ "WHERE idUsuario=" + tUsuario.getIdUsuario();

				statement.executeUpdate(query);// *
				//idUsuario = tUsuario.getIdUsuario();

			} catch (SQLException e) {
				//idUsuario = -100;
				tUsuario = null;
			}

		}

		return tUsuario;
	}
}
