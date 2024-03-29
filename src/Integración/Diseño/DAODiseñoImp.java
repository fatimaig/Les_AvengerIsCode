/**
 * 
 */
package Integraci�n.Dise�o;

import Integraci�n.Conexion.ConexionDAO;
import Negocio.Dise�o.TDise�o;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Marina
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAODise�oImp implements DAODise�o {
	/** 
	 * (sin Javadoc)
	 * @see DAODise�o#alta(TDise�o tDise�o)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int alta(TDise�o tDise�o) {
		
		int idDise�o = -100;
		ConexionDAO con = ConexionDAO.getInstance();
		Connection connection = con.getConexion();

		if(connection != null){
			try{
				Statement statement = connection.createStatement();
				String query = "INSERT INTO disenos (nombre, descripcion, propietario, alto, ancho, profundidad, precio, archivo, activo)"
						+ "VALUES ('"
						+ tDise�o.getNombre()
						+ "', '"
						+ tDise�o.getDescripcion()
						+ "', '"
						+ tDise�o.getPropietario()
						+ "', '"
						+ tDise�o.getAlto()
						+ "', '"
						+ tDise�o.getAncho()
						+ "', '"
						+ tDise�o.getProfundidad()
						+ "', '"
						+ tDise�o.getPrecio()
						+ "', '"
						+ tDise�o.getArchivo()
						+ "', '"
						+ (tDise�o.getActivo() ? 1 : 0)
						+ "');";
				statement.executeUpdate(query);
				query = "SELECT last_insert_id() as last_id from disenos";
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					idDise�o = resultSet.getInt("last_id");
				}
				connection.close();
			}
			catch(SQLException e){
				idDise�o = -100;
			}
		}
		
		return idDise�o;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAODise�o#baja(int idDise�o)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int baja(int idDise�o) {
		// begin-user-code
		int result = -100;
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();
		
		if(connection !=null){
			try{
				Statement statement = connection.createStatement();
				String query = "UPDATE disenos SET activo=0 WHERE idDiseno=" + idDise�o;
				statement.executeUpdate(query);
				result = idDise�o;
				connection.close();
			}
			catch(SQLException e){
				result =-100;
			}
		}
		return result;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAODise�o#modificar(TDise�o tDise�o)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificar(TDise�o tDise�o) {
		// begin-user-code
		int idDise�o = -100;
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();
		
		if(connection!=null) {
			try {
				Statement statement = connection.createStatement();
				String query = "UPDATE disenos SET "
						+ "nombre='" + tDise�o.getNombre()+ "', "
						+ "descripcion='"+tDise�o.getDescripcion() + "', "
						+ "propietario='" + tDise�o.getPropietario() + "', "
						+ "alto='" +  tDise�o.getAlto() + "', "
						+ "ancho='" +  tDise�o.getAncho() + "', "
						+ "profundidad='" +  tDise�o.getProfundidad() + "', "
						+ "precio='" + tDise�o.getPrecio() + "', "
						+ "archivo='" + tDise�o.getArchivo() + "', "
						+ "activo=" + (tDise�o.getActivo() ? 1 : 0) + " "
						+ "WHERE idDiseno=" + tDise�o.getId_dise�o();
				statement.executeUpdate(query);
				idDise�o = tDise�o.getId_dise�o();
			} catch (SQLException e) {
				idDise�o = -100;
			}
		}
		
		return idDise�o;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAODise�o#buscarPorId(int idDise�o)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TDise�o buscarPorId(int idDise�o) {
		// begin-user-code
		TDise�o tDise�o = null;
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();
		
		if(connection!=null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM disenos WHERE idDiseno=" + idDise�o +" AND activo = 1";
				ResultSet resultSet = statement.executeQuery(query);
				System.out.println("BUSCANDO DISE�O 0");
				if(resultSet.next()) {
					System.out.println("BUSCANDO DISE�O");
					tDise�o = new TDise�o(
							idDise�o,
							resultSet.getString("nombre"),
							resultSet.getString("descripcion"),
							resultSet.getInt("propietario"),
							resultSet.getFloat("alto"),
							resultSet.getFloat("ancho"),
							resultSet.getFloat("profundidad"),
							resultSet.getDouble("precio"),
							resultSet.getString("archivo"),
							resultSet.getBoolean("activo")
							);
				}
			} catch (SQLException e) {
				System.out.println("ERROR BUSCAR DISE�O");
				tDise�o = null;
			}
		}
		
		return tDise�o;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAODise�o#buscarPorPalabraClave(String palabraClave)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TDise�o> buscarPorPalabraClave(String palabraClave) {
		// begin-user-code
		TDise�o tDise�o = null;
		ArrayList<TDise�o>  listaDise�os = new ArrayList<>();
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();
		
		if(connection!=null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM disenos WHERE nombre LIKE '%"+ palabraClave + "%'"  + " AND activo = 1";
				ResultSet resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					tDise�o = new TDise�o(
							resultSet.getInt("idDiseno"),
							resultSet.getString("nombre"),
							resultSet.getString("descripcion"),
							resultSet.getInt("propietario"),
							resultSet.getFloat("alto"),
							resultSet.getFloat("ancho"),
							resultSet.getFloat("profundidad"),
							resultSet.getDouble("precio"),
							resultSet.getString("archivo"),
							resultSet.getBoolean("activo")
							);
					listaDise�os.add(tDise�o);
				}
			} catch (SQLException e) {
				tDise�o = null;
			}
		}
		
		return listaDise�os;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAODise�o#listarTodos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TDise�o> listarTodos() {
		// begin-user-code
		ArrayList<TDise�o>  listaDise�os = new ArrayList<>();
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();
		
		if(connection!=null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM disenos WHERE activo=1";
				ResultSet resultSet = statement.executeQuery(query);
				TDise�o tDise�o;
				while(resultSet.next()) {
					tDise�o = new TDise�o(
							resultSet.getInt("idDiseno"),
							resultSet.getString("nombre"),
							resultSet.getString("descripcion"),
							resultSet.getInt("propietario"),
							resultSet.getFloat("alto"),
							resultSet.getFloat("ancho"),
							resultSet.getFloat("profundidad"),
							resultSet.getDouble("precio"),
							resultSet.getString("archivo"),
							resultSet.getBoolean("activo")
							);
					listaDise�os.add(tDise�o);
				}
			} catch (SQLException e) {
				listaDise�os = null;
			}
		}
		
		return listaDise�os;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAODise�o#listarPorUsuario(int idUsuario)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TDise�o> listarPorUsuario(int idUsuario) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		ArrayList<TDise�o>  listaDise�os = new ArrayList<>();
		ConexionDAO connectionDAO = ConexionDAO.getInstance();
		Connection connection = connectionDAO.getConexion();
		
		if(connection!=null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM disenos WHERE propietario="+idUsuario + " AND activo = 1";
				ResultSet resultSet = statement.executeQuery(query);
				TDise�o tDise�o;
				while(resultSet.next()) {
					tDise�o = new TDise�o(
							resultSet.getInt("idDiseno"),
							resultSet.getString("nombre"),
							resultSet.getString("descripcion"),
							resultSet.getInt("propietario"),
							resultSet.getFloat("alto"),
							resultSet.getFloat("ancho"),
							resultSet.getFloat("profundidad"),
							resultSet.getDouble("precio"),
							resultSet.getString("archivo"),
							resultSet.getBoolean("activo")
							);
					listaDise�os.add(tDise�o);
				}
			} catch (SQLException e) {
				listaDise�os = null;
			}
		}
		
		return listaDise�os;
		// end-user-code
	}
}