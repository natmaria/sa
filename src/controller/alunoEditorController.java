/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Aluno;
import sys.ConnectionFactory;

/**
 *
 * @author nmpetry
 */
public class alunoEditorController {
   static Aluno objAluno;
    
    public  static Aluno buscar(String id)
    {
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT mat_alu, nom_alu, email, cod_curso ";
            SQL += " FROM alunos ";
            SQL += " WHERE mat_alu = '" + id + "'";
            //stm.executeQuery(SQL);

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar visitante");

                objAluno= new Aluno();
                
                if(rs.next() == true)
                {
                    objAluno.setMat_aluno(rs.getInt(1));
                    objAluno.setNom_aluno(rs.getString(2));
                    objAluno.setEmail(rs.getString(3));
                    objAluno.setCod_curso(rs.getInt(4));
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar aluno com sucesso");
        return objAluno;
    }
}
