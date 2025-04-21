package com.cadastro.aplicativojavafx.repositorio;

import com.cadastro.aplicativojavafx.model.Estudante;

import java.util.List;

public interface EstudanteRepositorio {

    public void porId(Long id);
    public List<Estudante> buscarTodos();
    public void inserir(Estudante estudante);
    public void apagar(long id);
    public void editar(Estudante estudante, long id);
}
