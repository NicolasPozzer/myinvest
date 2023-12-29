package com.demo.myinvest.controller;

import com.demo.myinvest.model.Inversion;
import com.demo.myinvest.service.InversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InversionController {
    @Autowired
    private InversionService inversionServ;

    /* EndPoints */

    @GetMapping("/inversiones/traertodo")
    public List<Inversion> getInversiones(){
        return inversionServ.getInversiones();
    }

    @PostMapping("/inversiones/crear")
    public String saveInversion(@RequestBody Inversion inversion){
        inversionServ.saveInversion(inversion);
        return "Guardado Correctamente!";
    }

    @DeleteMapping("/inversiones/borrar/{id}")
    public String deleteInversion(@PathVariable Long id){
        inversionServ.deleteInversion(id);
        return "Inversion Eliminada!";
    }

    @GetMapping("/inversiones/traer/{id}")
    public Inversion findInversion(@PathVariable Long id){
        return inversionServ.findInversion(id);
    }

    @PutMapping("/inversiones/edit")
    public String editInversion(@RequestBody Inversion inversion){
        inversionServ.editInversion(inversion);
        return "Activo Editado Correctamente!";
    }

    //Other methods...

    @GetMapping("/inversiones/total")
    public Double totalInversionEnCartera(){
        return inversionServ.totalInversionEnCartera();
    }

    @GetMapping("/inversiones/totalmoneda/{nombreMoneda}")
    public Double totalInversionPorMoneda(@PathVariable String nombreMoneda){
        return inversionServ.totalInversionPorMoneda(nombreMoneda);
    }

    @GetMapping("/inversiones/promentrada/{nombreMoneda}")
    public Double precioEntradaPromedio(@PathVariable String nombreMoneda){
        return inversionServ.precioEntradaPromedio(nombreMoneda);
    }
}
