package edu.local.CursoProyecto.service;

import edu.local.CursoProyecto.dao.entity.CursoEntity;
import java.util.List;

public interface CursoService {

    public List<CursoEntity> listarTodos();

    public CursoEntity obtenerUno(int codigo);

    public void insertar(CursoEntity ce);

    public void modificar(CursoEntity ce);

    public void eliminar(int codigo);
}
