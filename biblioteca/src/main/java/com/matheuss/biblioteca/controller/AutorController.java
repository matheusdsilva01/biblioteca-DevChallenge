package com.matheuss.biblioteca.controller;

import com.matheuss.biblioteca.model.Autor;
import com.matheuss.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private AutorRepository autorRepository;

    @Autowired
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping
    public List<Autor> getAutor(){
        return autorRepository.findAll();
    }

    @PostMapping
    public Autor postAutor(@RequestBody Autor autor){
        return autorRepository.save(autor);
    }
}
