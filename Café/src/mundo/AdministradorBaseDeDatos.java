package mundo;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

/**
 * Clase que permite administrar la conexión con la base de datos de juveniles
 *
 */
public class AdministradorBaseDeDatos 
{
	/**
	 * Conexión con la base de datos
	 */
	private Connection conexion;

	/**
	 * Conjunto de propiedades que contienen la configuración de la aplicación
	 */
	private Properties config;

	/**
	 * Formato de las fechas que son aceptadas por la base de datos.
	 */
	private final static SimpleDateFormat FORMAT_FECHA_BASE_DATOS=new SimpleDateFormat("yyyy-MM-dd");

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye el administrador de resultados y lo deja listo para conectarse a la base de datos
	 * @param propiedades Las propiedades para la configuración del administrador - Debe tener las propiedades "admin.db.path", "admin.db.driver", "admin.db.url" y
	 *        "admin.db.shutdown"
	 */
	public AdministradorBaseDeDatos( Properties propiedades )
	{
		config = propiedades;

		// Establecer la ruta donde va a estar la base de datos.
		// Derby utiliza la propiedad del sistema derby.system.home para saber donde estón los datos
		File data = new File( config.getProperty( "admin.db.path" ) );
		System.setProperty( "derby.system.home", data.getAbsolutePath( ) );

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Conecta el administrador a la base de datos
	 * @throws SQLException Se lanza esta excepción si hay problemas realizando la operación
	 * @throws Exception Se lanza esta excepción si hay problemas con los controladores
	 */
	public void conectarABD( ) throws SQLException, Exception
	{
		//Define el driver (programa) que se encarga de hacer la conexión entre java y la base de datos
		Locale.setDefault(new Locale("ln", "CO"));
		String driver = config.getProperty( "admin.db.driver" );
		Class.forName( driver ).newInstance( );

		//Define el nombre que tendrá la base de datos
		String url = config.getProperty( "admin.db.url" );
		conexion = DriverManager.getConnection( url );
	}

	/**
	 * Desconecta el administrador de la base de datos y la detiene
	 * @throws SQLException Se lanza esta excepción si hay problemas realizando la operación
	 */
	public void desconectarABD( ) throws SQLException
	{ 
		//Cierra la conexión con la base de datos
		conexion.close( );
		String down = config.getProperty( "admin.db.shutdown" );
		try
		{
			DriverManager.getConnection( down );
		}
		catch( SQLException e )
		{
			// Al bajar la base de datos se produce siempre una excepción
		}
	}

	/**
	 * Crea las tablas necesaria para guardar los juveniles. Si la tabla ya estaba creada entonces no hace nada. <br>
	 * @throws SQLException Se lanza esta excepción si hay problemas creando la tabla
	 */
	public void inicializarTablas( ) throws SQLException
	{
		Statement s = conexion.createStatement( );

		boolean crearTabla = false;
		try
		{
			//Verifica si la tabla juveniles existe. Si existe esta consulta devolverá una respuesta vacía, de lo contrario se generará una excepción
			//TODO Realizar una consulta cualquiera sobre la tabla. Si no existe la tabla lanzará SQLException
			String consulta = "SELECT * FROM juveniles WHERE 1=1";
			ResultSet rs = s.executeQuery(consulta);
		}
		catch( SQLException se )
		{

			crearTabla = true;
		}


		if( crearTabla )
		{
			//TODO Crear la tabla
			String consulta2 = "CREATE TABLE juveniles (id varchar(255), nombre varchar(255), apellido varchar(255), deporte varchar(255), numero_convocatorias int, fecha_nacimiento Date, genero varchar(3), PRIMARY KEY (id))";
			s.execute(consulta2);
		}


		s.close( );
	}

	/**
	 * Devuelve una lista con todos los juveniles registrados en la base de datos
	 * @return lista con los juveniles registrados en la base de datos
	 * @throws SQLException se lanza en caso que se genere un problema consultando la base de datos
	 */
	public List<Juvenil> darJuveniles() throws SQLException
	{
		//TODO Completar de acuerdo a la documentación.
		List<Juvenil> lista = new ArrayList<Juvenil>();
		Statement s = conexion.createStatement( );
		ResultSet rs = s.executeQuery("SELECT * from juveniles WHERE 1=1");
		while(rs.next())
		{
			String id = rs.getString(1);
			String nombre = rs.getString(2);
			String apellido = rs.getString(3);
			String deporte = rs.getString(4);

			Date fecha = rs.getDate(6);
			Calendar paraUsar = Calendar.getInstance();
			paraUsar.setTime(fecha);

			String genero = rs.getString(7);
			int convocatorias = rs.getInt(5);

			lista.add(new Juvenil(id, nombre, apellido, deporte, convocatorias, paraUsar, (genero.equals("M")? Genero.M: Genero.F)));
		}
		s.close();
		return lista;
	}

	/**
	 * Devuelve un juvenil a partir de su identificador
	 * @param id el número de identificación del juvenil. id != null && id != ""
	 * @return el juvenil o null en caso que no se encuentre registrado en la base de datos
	 * @throws SQLException se lanza en caso que ocurra algún error consultando la base de datos
	 */
	public Juvenil darJuvenil(String id) throws SQLException
	{
		//TODO Completar de acuerdo a la documentación.
		Juvenil respuesta = null;
		Statement s = conexion.createStatement();
		String consulta = "Select * from juveniles WHERE id = '" + id + "'";
		ResultSet rs = s.executeQuery(consulta);
		if(rs.next())
		{
			String nombre = rs.getString(2);
			String apellido = rs.getString(3);
			String deporte = rs.getString(4);

			Date fecha = rs.getDate(6);
			Calendar paraUsar = Calendar.getInstance();
			paraUsar.setTime(fecha);

			String genero = rs.getString(7);
			int convocatorias = rs.getInt(5);
			respuesta = new Juvenil(id, nombre, apellido, deporte, convocatorias, paraUsar, (genero.equals("M")? Genero.M: Genero.F));
		}
		s.close();
		return respuesta;
	}

	/**
	 * Indica si un juvenil se encuentra registrado en la base de datos o no
	 * @param id el número de identificación del juvenil. id != null && id != ""
	 * @return true en caso que el juvenil exista o false en caso contrario
	 * @throws SQLException se lanza en caso que ocurra algún error al consultar la base de datos
	 */
	public boolean existeJuvenil(String id) throws SQLException
	{
		//TODO Completar de acuerdo a la documentación.
		boolean respuesta = false;
		Statement s = conexion.createStatement();
		String consulta = "Select * from juveniles WHERE id = '" + id + "'";
		ResultSet rs = s.executeQuery(consulta);
		respuesta = rs.next();
		s.close();
		return respuesta;
	}


	/**
	 * Permite registrar un juvenil en la base de datos
	 * @param juvenil el juvenil que se desea registrar. juvenil != null
	 * @throws ElementoExisteException se lanza en caso que ya exista un juvenil con el id del juvenil que se desea registrar. 
	 * @throws SQLException se lanza en caso que se genere algún error consultando la base de datos
	 */
	public void registrarJuvenil(Juvenil juvenil) throws ElementoExisteException, SQLException
	{
		//TODO Completar de acuerdo a la documentación.
		if(!existeJuvenil(juvenil.darId()))
		{
			Statement s = conexion.createStatement();
			String id = juvenil.darId();
			String nombre = juvenil.darNombre();
			String apellido = juvenil.darApellido();
			String deporte = juvenil.darDeporte();

			Calendar fecha = juvenil.darFechaNacimiento();
			Date paraUsar = new Date(fecha.getTimeInMillis());
			String genero = juvenil.darGenero() == Genero.M? "M": "F";
			int convocatorias = juvenil.darNumeroConvocatorias();
			String consulta = "INSERT INTO juveniles VALUES ( '" + id + "', '" + nombre + "', '" + apellido + "', '" + deporte + "', "
					+ convocatorias + ", '" + paraUsar + "', '" +  genero + "' )";

			s.execute(consulta);
			s.close();
		}
		else
		{
			throw new ElementoExisteException("Ya existe el juvenil", Tipo.JUVENIL_REPETIDO, juvenil.darId());
		}

	}

	/**
	 * Permite eliminar un juvenil de la base de datos
	 * @param id el identificador del juvenil que se desea eliminar. Es el id de un juvenil que existe en la base de datos
	 * @throws SQLException se lanza en caso que ocurra algún error consultando la base de datos
	 */
	public void eliminarJuvenil(String id) throws SQLException
	{
		//TODO Completar de acuerdo a la documentación.
		Statement s = conexion.createStatement();
		String consulta = "DELETE FROM juveniles WHERE id = '" + id + "'";
		s.execute(consulta);
		s.close();
	}

	/**
	 * Permite registrar que un juvenil ha sido convocado por una selección juvenil
	 * <b>post:</b> la cantidad de convocatorias del juvenil ha aumentado en 1 en la base de datos
	 * @param id el identificador del juvenil al que se le desea registrar que ha sido convocado. 
	 * Corresponde al id de un juvenil registrado en la base de datos
	 * @throws SQLException se lanza en caso que se genere algún error consultando la base de datos
	 */
	public void registrarConvocatoriaJuvenil(String id)throws SQLException
	{
		//TODO Completar de acuerdo a la base de datos.
		Statement s = conexion.createStatement();
		String consulta = "UPDATE juveniles SET numero_convocatorias = numero_convocatorias + 1 WHERE ID = '" + id + "'";
		s.execute(consulta);
		s.close();
	}

}
