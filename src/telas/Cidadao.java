/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class Cidadao {

    private int id;
    private String nome;
    private String endereco;
    private String dataNascimento;
    private String email;
    private String celular;
    private String cpf;
    private String associado_saude;
    private String nomeVacina;
    private String dosesTomadas;
    private String dataVacinacao;

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

    public String getAssociado_saude() {
        return associado_saude;
    }

    public void setAssociado_saude(String associado_saude) {
        this.associado_saude = associado_saude;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getDosesTomadas() {
        return dosesTomadas;
    }

    public void setDosesTomadas(String dosesTomadas) {
        this.dosesTomadas = dosesTomadas;
    }

    public String getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(String dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    public void inserir() {
        //1: Definir o comando SQL
        String sql = "INSERT INTO Cidadao(nome, endereco,"
                + " dataNascimento, email, celular, cpf,"
                + "associado_saude, nomeVacina, dosesTomadas, dataVacinacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
//3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, endereco);
            ps.setString(3, dataNascimento);
            ps.setString(4, email);
            ps.setString(5, celular);
            ps.setString(6, cpf);
            ps.setString(7, associado_saude);
            ps.setString(8, nomeVacina);
            ps.setString(9, dosesTomadas);
            ps.setString(10, dataVacinacao);

//5: Executa o comando
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cidadão Cadastrado", "Cidadão cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar", "Banco de Dados não conectado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void alterar() {
        String sql = "UPDATE Cidadao SET nome = ?, endereco = ?, dataNascimento = ?, email = ?,"
                + "celular = ?, associado_saude = ?, nomeVacina = ?, dosesTomadas = ?, dataVacinacao = ?"
                + "WHERE cpf = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setString(2, endereco);
            ps.setString(3, dataNascimento);
            ps.setString(4, email);
            ps.setString(5, celular);
            ps.setString(6, associado_saude);
            ps.setString(7, nomeVacina);
            ps.setString(8, dosesTomadas);
            ps.setString(9, dataVacinacao);
            ps.setString(10, cpf);

            ps.execute();

            JOptionPane.showMessageDialog(null, "Cidadão Alterado", "Cidadão alterado com sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar", "Banco de Dados não conectado", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void excluir() {
        String sql = "DELETE FROM Cidadao WHERE cpf = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, cpf);

            ps.execute();
            JOptionPane.showMessageDialog(null, "Cidadão Excluido", "Cidadão excluido com sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar", "Banco de Dados não conectado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Cidadao listar() {
        Cidadao cidadao = null;

        String sql = "SELECT * FROM Cidadao WHERE cpf = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            //ps.setString(1, cpf);
            //ResultSet rs = ps.executeQuery();
            while (true) {
                ps.setString(1, cpf);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    cidadao = new Cidadao();

                    cidadao.setNome(rs.getString("nome"));
                    cidadao.setEndereco(rs.getString("endereco"));
                    cidadao.setDataNascimento(rs.getString("dataNascimento"));
                    cidadao.setEmail(rs.getString("email"));
                    cidadao.setCelular(rs.getString("celular"));
                    cidadao.setCpf(rs.getString("cpf"));
                    cidadao.setAssociado_saude(rs.getString("associado_saude"));
                    cidadao.setNomeVacina(rs.getString("nomeVacina"));
                    cidadao.setDosesTomadas(rs.getString("dosesTomadas"));
                    cidadao.setDataVacinacao(rs.getString("dataVacinacao"));
                    break;

                }
            }
        } catch (Exception e) {
        }

        return cidadao;
    }
    
    

    
    /*public String[] listarCidadao() {
        ArrayList<String> cidadao = new ArrayList<String>();

        String sql = "SELECT nome, email, celular FROM Cidadao";

        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cidadao.add(rs.getString("nome"));
                cidadao.add(rs.getString("email"));
                cidadao.add(rs.getString("celular"));
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //convert ArrayList para vetor[]
        return cidadao.toArray(new String[cidadao.size()]);
    }*/
}
