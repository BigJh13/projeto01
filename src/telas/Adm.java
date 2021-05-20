/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author guimenoci
 */
public class Adm {

    private int id;
    private String nome;
    private String endereco;
    private String dataNascimento;
    private String email;
    private String celular;
    private String cpf;
    private String login;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /*public Adm login() {
        Adm adm = null;

        String sql = "SELECT login = ?, senha = ? FROM Adm";

        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {

            //while (true) {
            PreparedStatement ps = c.prepareStatement(sql);
            // if (rs.next()) {
            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();
            String validaLogin = rs.getString(login);
            String validaSenha = rs.getString(senha);
            //if (rs.next()) {
            if (validaLogin == this.login && validaSenha == this.senha) {
                JOptionPane.showMessageDialog(null, "BEM-VINDO");
                CrudCidadao cidadao = new CrudCidadao();
                cidadao.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario incorreto");
                // }

                // }
                //break;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO COM BANCO");
        }

        return adm;
    }*/
}
