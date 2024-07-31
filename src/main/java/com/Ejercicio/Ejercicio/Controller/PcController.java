package com.Ejercicio.Ejercicio.Controller;


import com.Ejercicio.Ejercicio.Service.PcService;
import com.Ejercicio.Ejercicio.dto.PcDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pc")


public class PcController {
    @Autowired
    private PcService pcService;


    @GetMapping("/")
    public ResponseEntity<List<PcDto>> findAll(){
        List<PcDto> lista = this.pcService.getAll();
        return  ResponseEntity.ok(lista);
    }

@GetMapping("/{id}")
    public  ResponseEntity <PcDto> findById(@PathVariable("id")Long id){
        PcDto pc = this.pcService.getById(id);
        return ResponseEntity.ok(pc);
}
    @PostMapping("/")
    public  ResponseEntity <PcDto> save(@RequestBody PcDto pcDto){
        PcDto saved = this.pcService.save(pcDto);
        return ResponseEntity.ok(saved);
    }
    @PutMapping ("/{id}")
    public  ResponseEntity <PcDto> update(@RequestBody PcDto pcDto, @PathVariable("id")Long id){
        PcDto updated = this.pcService.update(pcDto,id);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            this.pcService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}

