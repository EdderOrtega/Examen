package test;

import dao.impl.DaoH2Odontologo;
import model.Odontologo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

        Odontologo OdontologoDb = odontologoService.guardar(odontologo);

        assertNotNull(OdontologoDb);
    }

}