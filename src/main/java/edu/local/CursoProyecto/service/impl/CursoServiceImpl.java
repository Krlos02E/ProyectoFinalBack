package edu.local.CursoProyecto.service.impl;

import edu.local.CursoProyecto.dao.entity.CursoEntity;
import edu.local.CursoProyecto.dao.repository.CursoRepository;
import edu.local.CursoProyecto.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> listarTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public CursoEntity obtenerUno(int codigo) {
        return cursoRepository.findById(codigo).get();
    }

    @Override
    public void insertar(CursoEntity ce) {
        cursoRepository.save(ce);
    }

    @Override
    public void modificar(CursoEntity ce) {
        cursoRepository.save(ce);
    }

    @Override
    public void eliminar(int codigo) {
        cursoRepository.deleteById(codigo);
    }

}
