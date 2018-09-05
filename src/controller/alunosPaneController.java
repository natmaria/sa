/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
            SQL = " SELECT mat_aluno, c.nom_curso, nom_aluno ";
            SQL+=" FROM alunos a, cursos c";
            SQL+=" WHERE a.cod_curso=c.cod_curso ";
            SQL+= " ORDER BY nom_aluno ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                dadosTabela.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("problema ao popular tabela");
            System.out.println(e);
        }
        jtbAlunos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
    });
        
        jtbAlunos.setSelectionMode(0);
        
        TableColumn column = null;
        for (int i=0; i<3; i++) 
        {
            column = jtbAlunos.getColumnModel().getColumn(i);
            switch (i)
            {
                case 0:
                    column.setPreferredWidth(80);
                    break;
                case 1:
                    column.setPreferredWidth(200);
                    break;
                case 2:
                    column.setPreferredWidth(150);
                    break;
            }
        }
        
        jtbAlunos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            public Component getTableCellReComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column)
            {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0)
                {
                    setBackground(Color.LIGHT_GRAY);
                } else 
                {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
   }

}
