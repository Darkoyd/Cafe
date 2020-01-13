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
		//Pergamino
		try
		{
			String consulta = "SELECT * FROM pergamino WHERE 1=1";
			ResultSet rs = s.executeQuery(consulta);
		}
		catch( SQLException se )
		{

			crearTabla = true;
		}

		if( crearTabla )
		{
			String consulta2 = "CREATE TABLE pergamino (fechaPergamino Date, propietario varchar(255), pesoKilos float, PRIMARY KEY (fechaPergamino, propietario))";
			s.execute(consulta2);
		}

		
		//Trillado
		crearTabla = false;
		try
		{
			String consulta = "SELECT * FROM trillado WHERE 1=1";
			ResultSet rs = s.executeQuery(consulta);
		}
		catch( SQLException se )
		{

			crearTabla = true;
		}

		if( crearTabla )
		{
			String consulta2 = "CREATE TABLE trillado (codigoBarras varChar(20), fechaLote Date, fechaTrillado Date, fechaPergamino Date, cantidad int, tostion varChar(20), molienda varChar(20), presentacion varChar(20), PRIMARY KEY (codigoBarras, fechaLote))";
			s.execute(consulta2);
		}

		
		//Inventario
		crearTabla = false;
		try
		{
			String consulta = "SELECT * FROM inventario WHERE 1=1";
			ResultSet rs = s.executeQuery(consulta);
		}
		catch( SQLException se )
		{

			crearTabla = true;
		}

		if( crearTabla )
		{
			String consulta2 = "CREATE TABLE inventario (codigoBarras varChar(20), fechaVenta Date, fechaLote Date, fechaTrillado Date, fechaPergamino Date, cantidad int, tostion varChar(20), molienda varChar(20), presentacion varChar(20), PRIMARY KEY (codigoBarras, fechaVenta))";
			s.execute(consulta2);
		}

		
		//Vendido
		crearTabla = false;
		try
		{
			String consulta = "SELECT * FROM juveniles WHERE 1=1";
			ResultSet rs = s.executeQuery(consulta);
		}
		catch( SQLException se )
		{

			crearTabla = true;
		}

		if( crearTabla )
		{
			String consulta2 = "CREATE TABLE juveniles (id varchar(255), nombre varchar(255), apellido varchar(255), deporte varchar(255), numero_convocatorias int, fecha_nacimiento Date, genero varchar(3), PRIMARY KEY (id))";
			s.execute(consulta2);
		}


		s.close( );
	}
	
	public List<SuperCafe> darCafesPergamino()
	{
		List<SuperCafe> cafes = new ArrayList<SuperCafe>();
		
		
		
		return cafes;
	}

}
