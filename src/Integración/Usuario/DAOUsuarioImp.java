package Integraci�n.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Negocio.Usuario.TUsuario;

import Integraci�n.Conexion.ConexionDAO;

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
		// TODO Ap�ndice de m�todo generado autom�ticamente

		int idUsuario = -100;
		ConexionDAO con = ConexionDAO.getInstance();
		Connection connection = con.getConexion();

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String pattern = "YYYY-MM-DD";
		        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		        String mysqlFechaNac= formatter.format(datos.getFechaNacimiento());
		        String mysqlFechaCad= formatter.format(datos.getFechaCaducidad());
				String query = "INSERT INTO usuario (nombre, apellidos, email, fechaNacimiento, direccion, contrasenna, titularCuenta, cuentaBancaria, fechaCaducidad, activo)"
						+ " VALUES ('"
						+ datos.getNombre()
						+ "', '"
						+ datos.getApellidos()
						+ "', '"
						+ datos.getEmail()
						+ "', '"
						+ mysqlFechaNac
						+ "', '"
						+ datos.getDireccion()
						+ "', '"
						+ datos.getContrase�a()
						+ "', '"
						+ datos.getTitularCuenta()
						+ "', '"
						+ datos.getNumeroCuenta()
						+ "', '"
						+ mysqlFechaCad
						+ "', '"
						+ (datos.getActivo() ? 1 : 0) + "');";

				statement.executeUpdate(query);
				query = "SELECT last_insert_id() as last_id from usuario";
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					idUsuario = resultSet.getInt("last_id");
				}
				//connection.close();

			} catch (SQLException e) {
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
				String query = "SELECT * FROM usuario WHERE idUsuario="
						+ idUsuario;
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					tUsuario = new TUsuario(idUsuario,
							resultSet.getString("nombre"),
							resultSet.getString("apellidos"),
							resultSet.getString("email"),
							resultSet.getDate("fechaNacimiento"),
							resultSet.getString("direccion"),
							resultSet.getString("contrase�a"),
							resultSet.getString("titularCuenta"),
							resultSet.getString("numeroCuenta"),
							resultSet.getDate("fechaCaducidad"),
							resultSet.getBoolean("activo"));
				}
			} catch (SQLException e) {
				tUsuario = null;
			}
		}

		return tUsuario;
	}

	public TUsuario acceso(TUsuario tUsuario) {

		return tUsuario;
	}

	public ArrayList<TUsuario> listarUsuarios() {

		ArrayList<TUsuario> listaUsuarios = new ArrayList<>();
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM usuario";
				ResultSet resultSet = statement.executeQuery(query);
				TUsuario tUsuario = null;

				while (resultSet.next()) {
					tUsuario = new TUsuario(resultSet.getInt("idUsuario"),
							resultSet.getString("nombre"),
							resultSet.getString("apellidos"),
							resultSet.getString("email"),
							resultSet.getDate("fechaNacimiento"),
							resultSet.getString("direccion"),
							resultSet.getString("contrase�a"),
							resultSet.getString("titularCuenta"),
							resultSet.getString("numeroCuenta"),
							resultSet.getDate("fechaCaducidad"),
							resultSet.getBoolean("activo"));
				}
				listaUsuarios.add(tUsuario);

			} catch (SQLException e) {
				e.printStackTrace();
				listaUsuarios = null;
			}
		}

		return listaUsuarios;
		// end-user-code
	}

	public int modificarUsuario(TUsuario tUsuario) {

		Integer idUsuario = 0;
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection conect = connectionDAO.getConexion();

		if (conect != null) {

			try {
				Statement statement = conect.createStatement();
				String query = "UPDATE usuario SET " + "nombre='"
						+ tUsuario.getNombre() + "', " + "apellidos='"
						+ tUsuario.getApellidos() + "', " + "direccion='"
						+ tUsuario.getDireccion() + "', " + "fechaNacimiento='"
						+ tUsuario.getFechaNacimiento() + "', " + "email='"
						+ tUsuario.getEmail() + "', " + "titularCuenta='"
						+ tUsuario.getTitularCuenta() + ",' " + "numerCuenta='"
						+ tUsuario.getNumeroCuenta() + ",' "
						+ "fechaCaducidad='" + tUsuario.getFechaCaducidad()
						+ "WHERE idDise�o=" + tUsuario.getIdUsuario();

				statement.executeUpdate(query);
				idUsuario = tUsuario.getIdUsuario();

			} catch (SQLException e) {
				idUsuario = -1;
			}

		}

		return idUsuario;
	}
}
