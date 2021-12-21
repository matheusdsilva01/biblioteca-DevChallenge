package com.matheuss.biblioteca.controller;

import com.matheuss.biblioteca.model.Obra;
import com.matheuss.biblioteca.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/obra")
public class ObraController {

    private ObraRepository obraRepository;

    @Autowired
    public ObraController(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @PostMapping
    public ResponseEntity<Obra> postObra(@RequestBody Obra obra){
        return ResponseEntity.ok(obraRepository.save(obra));
    }

    @GetMapping
    public ResponseEntity<List<Obra>> listarTodasAsObras(){
        return ResponseEntity.ok(obraRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> getObrabyId(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(obraRepository.findById(id).get());
        } catch (NoSuchElementException e){
            throw new NoSuchElementException("Autor não encontrado");
        }
        catch (NumberFormatException e){
            e.getMessage();
            throw new NumberFormatException("Id inválido, preencha corretamente");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteObraById(@PathVariable Integer id){
        obraRepository.deleteById(id);
    }

}
