/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Aluno;
import model.Usuario;
import sys.ConnectionFactory;

/**
 *
 * @author nmp
 */
public class alunosPaneController {
    public Aluno mostrarAlunos() {
        ConnectionFactory.abreConexao();
        Aluno aluno = null; 
        ResultSet rs = null;
        
        StringBuilder comandoSQL = new StringBuilder();
        comandoSQL.append(" SELECT id, nome, cpf, cidade, email, celular");
        comandoSQL.append(" FROM alunos");
        
        try 
        {
          rs = ConnectionFactory.stmt.executeQuery(comandoSQL.toString());
          while (rs.next() == true) {
                aluno = new Aluno();
                aluno.setId(rs.getString("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCelular(rs.getString("celular"));
        }
    } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage().toString());
            return aluno;
        } finally{
            Connection con = ConnectionFactory.getConnection();
            ConnectionFactory.closeConnection(con);
        }
        return aluno;
    }
}
