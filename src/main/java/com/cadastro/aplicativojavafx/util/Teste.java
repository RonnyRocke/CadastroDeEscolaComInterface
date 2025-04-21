package com.cadastro.aplicativojavafx.util;

import com.cadastro.aplicativojavafx.dao.EstudanteDao;
import com.cadastro.aplicativojavafx.model.Estudante;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws SQLException {

        // INSERIR
       // Estudante estudante = new Estudante();

        //estudante.setNome("Andre");
        //estudante.setSexo("Masculino");
        //estudante.setIdade(38);

        //EstudanteDao estudanteDao = new EstudanteDao();
        //estudanteDao.inserir(estudante);


        // BUSCAR
        //EstudanteDao estudanteDao = new EstudanteDao();
        //List<Estudante> estudantes = new ArrayList<>();
        //estudantes = estudanteDao.buscarTodos();

        //for (int i = 0; i < estudantes.size(); i++) {

          //  System.out.println("ID: " + estudantes.get(i).getID());
          //  System.out.println("Nome " + estudantes.get(i).getNome());
          //  System.out.println("Sexo: " + estudantes.get(i).getSexo());
          //  System.out.println("Idade: " + estudantes.get(i).getIdade());


        // ATUALIZAR
      //  EstudanteDao estudanteDao = new EstudanteDao();
        //Estudante estudante = new Estudante();

       // estudante.setNome("Carlos");
        //estudante.setSexo("M");
        //estudante.setIdade(64);

        //estudanteDao.editar(estudante,3);

        //EstudanteDao estudanteDao = new EstudanteDao();
        //Estudante estudante = new Estudante();
        //estudante = estudanteDao.porId(1L);

        //System.out.println("Nome: "+estudante.getNome());
        //System.out.println("Sexo: "+estudante.getSexo());


        // APAGAR
        EstudanteDao estudanteDao = new EstudanteDao();

        estudanteDao.apagar(4);


    }
    }

