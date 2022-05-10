package com.montanha.factory;

import com.montanha.pojo.Usuario;
import com.montanha.pojo.Viagem;

public class UsuarioDataFactory {

    public Usuario criarUsuarioAdminstrador(){
        Usuario usuarioAdminstrador = new Usuario();

        usuarioAdminstrador.setEmail("admin@email.com");
        usuarioAdminstrador.setSenha("654321");

        return usuarioAdminstrador;
    }

    public Usuario criarUsuarioComum(){
        Usuario usuarioAdminstrador = new Usuario();

        usuarioAdminstrador.setEmail("usuario@email.com");
        usuarioAdminstrador.setSenha("123456");

        return usuarioAdminstrador;
    }

}
