/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nmp
 */
public class Aluno {
   private int mat_aluno;
   private int cod_curso;
   private String dt_nasc;
   private String nom_aluno;
   private String email;

    public int getMat_aluno() {
        return mat_aluno;
    }

    public void setMat_aluno(int mat_aluno) {
        this.mat_aluno = mat_aluno;
    }

    public int getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(int cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(String dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getNom_aluno() {
        return nom_aluno;
    }

    public void setNom_aluno(String nom_aluno) {
        this.nom_aluno = nom_aluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
}
