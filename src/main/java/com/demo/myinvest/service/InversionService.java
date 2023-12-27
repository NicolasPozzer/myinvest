package com.demo.myinvest.service;

import com.demo.myinvest.model.Inversion;
import com.demo.myinvest.repository.iInversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InversionService implements iInversionService{

    @Autowired
    private iInversionRepository repoInversion;

    @Override
    public List<Inversion> getInversiones() {
        List<Inversion> listaInversiones = repoInversion.findAll();
        return listaInversiones;
    }

    @Override
    public void saveInversion(Inversion inversion) {
        repoInversion.save(inversion);
    }

    @Override
    public void deleteInversion(Long id) {
        repoInversion.deleteById(id);
    }

    @Override
    public Inversion findInversion(Long id) {
        Inversion inversion = repoInversion.findById(id).orElse(null);
        return inversion;
    }

    @Override
    public void editInversion(Inversion inversion) {
        this.saveInversion(inversion);
    }

    @Override
    public Double totalInversionEnCartera() {
        Double acumTotal = 0.0;

        for (Inversion inversion : getInversiones()){
            acumTotal = acumTotal + inversion.getCantInvertida();
        }
        return acumTotal;
    }

    @Override
    public Double precioEntradaPromedio(String nombreMoneda) {
        Double acumMonto = 0.0;
        Double acumPrecioPonderado = 0.0;

        for (Inversion inversion : getInversiones()) {
            if (nombreMoneda.toUpperCase().equals(inversion.getNombre())) {
                acumMonto += inversion.getCantInvertida();
                acumPrecioPonderado += inversion.getPrecioEntrada() * inversion.getCantInvertida();
            }
        }

        if (acumMonto == 0.0) {
            // Manejar el caso donde no hay inversiones para la moneda dada
            return 0.0; // o puedes devolver null u otro valor según tu lógica
        }

        return acumPrecioPonderado / acumMonto;
    }
}
