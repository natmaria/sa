/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Component;
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
public class usuariosPaneController {
    Usuario objUsuario;
    JTable jtbUsuarios = null;
    
      public usuariosPaneController (Usuario objUsuario, JTable jtbUsuarios) {
        this.objUsuario = objUsuario;
        this.jtbUsuarios = jtbUsuarios;
    }
      
      public void mostrarUsuarios() {
        ConnectionFactory.abreConexao();
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Nome");
        cabecalhos.add("Login");
        
        ResultSet result = null;
        try
        {
            String SQL = "";
            SQL = " SELECT nome, login ";
            SQL+=" FROM usuarios ";
            SQL+= " ORDER BY nome ";
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next()) {
              Vector<Object> linha = new Vector<Object>();
              linha.add(result.getString(1));
              linha.add(result.getString(2));
              dadosTabela.add(linha);
            }
        } catch (SQLException e) {
            System.out.println("problema ao popular tabela");
            System.out.println(e);
        }
        
        jtbUsuarios.setModel(new DefaultTableModel(dadosTabela,cabecalhos) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    });
    
        jtbUsuarios.setSelectionMode(0);
        
        TableColumn column = null;
        for (int i=0; i<3; i++) 
        {
            column = jtbUsuarios.getColumnModel().getColumn(i);
            switch (i)
            {
                case 0:
                    column.setPreferredWidth(200);
                    break;
                case 1:
                    column.setPreferredWidth(100);
                    break;
            }
        }
        
        jtbUsuarios.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
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
