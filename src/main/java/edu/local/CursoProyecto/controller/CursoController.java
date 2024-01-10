package edu.local.CursoProyecto.controller;

import edu.local.CursoProyecto.dao.entity.CursoEntity;
import edu.local.CursoProyecto.dto.ErrorDTO;
import edu.local.CursoProyecto.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @ExceptionHandler(Exception.class)
    private ResponseEntity manejarExcepciones(){
        ErrorDTO err = new ErrorDTO(HttpStatus.CONFLICT.toString(), "Problema interno",
                "Ha ocurrido un error en la aplicacion. Verifique su request");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }
    
    @GetMapping("/cursos")
    public List<CursoEntity> listarTodos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/cursos/{id}")
    public CursoEntity obtenerUno(@PathVariable(value = "id") int codigo) {
        try{
            CursoEntity rpta = cursoService.obtenerUno(codigo);
            return rpta;
        }
        catch(java.util.NoSuchElementException err){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no localizado", err);
        }
    }

    @PostMapping("/cursos")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody CursoEntity ce) {
        cursoService.insertar(ce);
    }

    @PutMapping("/cursos/{id}")
    public void modificar(@RequestBody CursoEntity ce, @PathVariable(value = "id") int codigo) {
        ce.setIdcurso(codigo);
        cursoService.modificar(ce);
    }

    @DeleteMapping("/cursos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable(value = "id") int codigo) {
        cursoService.eliminar(codigo);
    }
}
