/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.Usuario;
import sys.ConnectionFactory;

/**
 *
 * @author nmp
 */
public class alunosPaneController {
    Aluno objAluno;
    JTable jtbAlunos = null;
    
    public alunosPaneController (Aluno objAluno, JTable jtbAlunos) {
        this.objAluno = objAluno;
    }
    public void mostrarAlunos() {
        ConnectionFactory.abreConexao();
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Curso");
        cabecalhos.add("Nome");
        
        ResultSet result = null;
        try
        {
            String SQL = "";
            SQL = " SELECT id, curso, nome ";
            SQL+=" FROM alunos ";
            SQL+=" WHERE COALESCE{dataExclusao,''} = '' ";
            SQL+= " ORDER BY nome DESC ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                dadosTabela.add(linha);
            }
        } catch (Exception e) {
            System.out.println("problema ao popular tabela");
            System.out.println(e);
        }

   }

}
