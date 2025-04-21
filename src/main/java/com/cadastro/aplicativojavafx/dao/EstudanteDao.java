package com.cadastro.aplicativojavafx.dao;

import com.cadastro.aplicativojavafx.model.Estudante;
import com.cadastro.aplicativojavafx.repositorio.EstudanteRepositorio;
import com.cadastro.aplicativojavafx.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDao implements EstudanteRepositorio {

    @Override
    public void porId(Long id) {

    }

    @Override
    public List<Estudante> buscarTodos() {


        List<Estudante> estudantes = new ArrayList<>();

        try{

            ResultSet rs = null;
            String sql = "SELECT * from estudante";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){

                Estudante estudante = new Estudante();

                estudante.setID(rs.getLong("id"));
                estudante.setNome(rs.getString("nome"));
                estudante.setSexo(rs.getString("sexo"));
                estudante.setIdade(rs.getInt("idade"));

                estudantes.add(estudante);

            }
        } catch(Exception e){
            System.out.println("ERRO "+ e.getMessage());
        }

        return estudantes;
    }

    @Override
    public void inserir(Estudante estudante) {

        try{

            String sql = "INSERT INTO estudante(nome, sexo, idade) VALUES(?, ?, ?)";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

            ps.setString(1, estudante.getNome());
            ps.setString(2,estudante.getSexo());
            ps.setInt(3,estudante.getIdade());
            ps.execute();


        } catch(Exception e){


            e.printStackTrace();
            System.out.println("Erro "+ e.getMessage());
        }



    }

    @Override
    public void apagar(long id) {

    }

    @Override
    public void editar(Estudante estudante, long id) {

        try{

            String sql = "UPDATE estudante SET nome=?, sexo=?, idade=? where id=?";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

            ps.setString(1,estudante.getNome());
            ps.setString(2,estudante.getSexo());
            ps.setInt(3,estudante.getIdade());
            ps.setLong(4,id);

            ps.executeUpdate();


        } catch(Exception e){

            System.out.println("ERRO "+e.getMessage());
        }

    }
}
