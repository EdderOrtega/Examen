package test;

import dao.impl.DaoH2Odontologo;
import model.Odontologo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import service.OdontologoService;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {

    private static final Logger logger = Logger.getLogger(OdontologoServiceTest.class);
    private static OdontologoService odontologoService = new OdontologoService(new DaoH2Odontologo());


    @BeforeAll
    static void crearTabla(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./ExamenBackEndDH:INIT=RUNSCRIPT FROM 'create.sql'", "sa","sa");
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testeando agregar Odontologo a la base de datos")
    public void case1() throws SQLException {
        Odontologo odontologo = new Odontologo(2020,"Ana","Rodriguez" );
        Odontologo odontologo2 = new Odontologo(3320,"Mario","Perez" );
        Odontologo odontologo3 = new Odontologo(44320,"Daniel","Sanchez" );

        Odontologo OdontologoDb = odontologoService.guardar(odontologo);
        Odontologo OdontologoDb2 = odontologoService.guardar(odontologo2);
        Odontologo OdontologoDb3 = odontologoService.guardar(odontologo3);

        assertNotNull(OdontologoDb);
        assertNotNull(OdontologoDb2);
        assertNotNull(OdontologoDb3);

    }

    @Test
    @DisplayName("Testear que se obtengan todos los odontologos")
    public void caso2() throws SQLException {

        List<Odontologo> odontologos = odontologoService.buscarTodos();

        assertTrue(odontologos.size() > 0, "lista de Odontologos " + odontologos);
    }
}