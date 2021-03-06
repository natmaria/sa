/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.alunoEditorController.objAluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.text.DateFormatter;
import model.Usuario;
import sys.ConnectionFactory;

/**
 *
 * @author nmp
 */
public class usuarioEditorController 
{
 static Usuario objUsuario;
    public usuarioEditorController(Usuario objUsuario) 
    {
    this.objUsuario = objUsuario;
    }
    public  static Usuario buscar(String login)
    {
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT nome, login, senha ";
            SQL += " FROM usuarios ";
            SQL += " WHERE login = '" + login + "'";
            //stm.executeQuery(SQL);

            try
            {
                System.out.println("Vai Executar Conexão em buscar usuário");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar usuário");

                objUsuario= new Usuario();
                
                if(rs.next() == true)
                {
                    objUsuario.setNome(rs.getString(1));
                    objUsuario.setLogin(rs.getString(2));
                    objUsuario.setSenha(rs.getString(3));
                }
            }
            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } 
        catch (Exception e) 
        {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar aluno com sucesso");
        return objUsuario;
    }

    
    public boolean incluirUsuario()
    {
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO usuarios (nome, login, senha)VALUES(?,?,?)");
            stmt.setString(1, objUsuario.getNome());
            stmt.setString(2, objUsuario.getLogin());
            stmt.setString(3, objUsuario.getSenha());
            
            stmt.executeUpdate();
            
            return true;
            
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
            return false;
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt);
        } 
    }
    
    public boolean alterar()
    {
 
    ConnectionFactory.abreConexao();
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
 
    try 
    {
        stmt = con.prepareStatement("UPDATE usuarios SET nome=?, senha=? WHERE login=?");
        stmt.setString(1, objUsuario.getNome());
        stmt.setString(2, objUsuario.getSenha());
        stmt.setString(3, objUsuario.getLogin());
        
        stmt.executeUpdate();
 
        return true;
 
        } 
    catch (SQLException ex) 
    {
        System.out.println(ex.getMessage());
        return false;
    }
    finally
    {
    ConnectionFactory.closeConnection(con, stmt);
    }
 }
        
    public boolean excluir(String login)
    {
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
 
        try{
            stmt = con.prepareStatement("DELETE from usuarios where login='"+ login +"'");
            //stmt = con.prepareStatement("UPDATE aluno SET dataExclusao=? WHERE mat_alu=?");
            //stmt.setString(1, objAluno.getDataExclusao());
            //stmt.setInt(2, objAluno.getMat_aluno());
                        
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}
