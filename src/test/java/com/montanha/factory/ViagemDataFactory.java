package com.montanha.factory;

import com.montanha.pojo.Viagem;

public class ViagemDataFactory {

    public Viagem criarViagemValidaSul(){
        Viagem viagemValida = new Viagem();

        viagemValida.setLocalDeDestino("Paraiba");
        viagemValida.setAcompanhante("diego");
        viagemValida.setDataPartida("2020-05-02");
        viagemValida.setDataRetorno("2020-10-02");
        viagemValida.setRegiao("Norte");

        return viagemValida;
    }

}
