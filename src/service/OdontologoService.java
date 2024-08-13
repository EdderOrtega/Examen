package service;

import dao.IDao;
import model.Odontologo;

import java.sql.SQLException;
import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> OdontologoIDao;

    public OdontologoService(IDao<Odontologo> OdontologoIDao){
        this.OdontologoIDao = OdontologoIDao;
    }
    public Odontologo guardar(Odontologo odontologo) throws SQLException {
        return OdontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> buscarTodos(){
        return OdontologoIDao.buscarTodos();
    }
}
