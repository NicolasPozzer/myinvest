package com.demo.myinvest.service;

import com.demo.myinvest.model.Inversion;

import java.util.List;

public interface iInversionService {
    public List<Inversion> getInversiones();

    public void saveInversion(Inversion inversion);

    public void deleteInversion(Long id);

    public Inversion findInversion(Long id);

    public void editInversion(Inversion inversion);

    public Double totalInversionEnCartera();

    public Double precioEntradaPromedio(String nombreMoneda);
}
