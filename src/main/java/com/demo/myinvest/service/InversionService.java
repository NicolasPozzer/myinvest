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
}
