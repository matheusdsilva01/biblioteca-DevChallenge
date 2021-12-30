package com.matheuss.biblioteca.controller;

import com.matheuss.biblioteca.model.Autor;
import com.matheuss.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private AutorRepository autorRepository;

    @Autowired
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<Autor> postAutor(@RequestBody Autor autor){
        return ResponseEntity.ok(autorRepository.save(autor));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAutor(){
        return ResponseEntity.ok(autorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Integer id) throws NoSuchElementException, NumberFormatException {
        try{
            return ResponseEntity.ok(autorRepository.findById(id).get());
        } catch (NoSuchElementException e){
            throw new NoSuchElementException("Autor não encontrado");
        }
        catch (NumberFormatException e){
            e.getMessage();
            throw new NumberFormatException("Id inválido, preencha corretamente");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Integer id){
        autorRepository.deleteById(id);
    }

}
