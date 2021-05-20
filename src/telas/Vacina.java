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
public class Vacina {

    private int id;
    private String fornecedor;
    private String nomeVacina;
    private String quantidadeVacinas;
    private String quantidadeDoses;
    private String imunidade;
    private String vacinaData;
    private String vacinaHora;
    private String validade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getQuantidadeVacinas() {
        return quantidadeVacinas;
    }

    public void setQuantidadeVacinas(String quantidadeVacinas) {
        this.quantidadeVacinas = quantidadeVacinas;
    }

    public String getQuantidadeDoses() {
        return quantidadeDoses;
    }

    public void setQuantidadeDoses(String quantidadeDoses) {
        this.quantidadeDoses = quantidadeDoses;
    }

    public String getImunidade() {
        return imunidade;
    }

    public void setImunidade(String imunidade) {
        this.imunidade = imunidade;
    }

    public String getVacinaData() {
        return vacinaData;
    }

    public void setVacinaData(String vacinaData) {
        this.vacinaData = vacinaData;
    }

    public String getVacinaHora() {
        return vacinaHora;
    }

    public void setVacinaHora(String vacinaHora) {
        this.vacinaHora = vacinaHora;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void inseir() {
        String sql = "INSERT INTO Vacina(fornecedor,"
                + " nomeVacina, quantidadeVacinas, quantidadeDoses, imunidade,"
                + " vacinaData, vacinaHora, validade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
//3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
            ps.setString(1, fornecedor);
            ps.setString(2, nomeVacina);
            ps.setString(3, quantidadeVacinas);
            ps.setString(4, quantidadeDoses);
            ps.setString(5, imunidade);
            ps.setString(6, vacinaData);
            ps.setString(7, vacinaHora);
            ps.setString(8, validade);

//5: Executa o comando
            ps.execute();
            JOptionPane.showMessageDialog(null, "Vacina cadastrada", "Vacina cadastrada com sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar", "Banco de Dados não conectado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void alterar() {
        String sql = "UPDATE Vacina SET fornecedor = ?, nomeVacina = ?, quantidadeVacinas = ?, quantidadeDoses = ?,"
                + "imunidade = ?, vacinaData = ?, vacinaHora = ?, validade = ?"
                + "WHERE id = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, fornecedor);
            ps.setString(2, nomeVacina);
            ps.setString(3, quantidadeVacinas);
            ps.setString(4, quantidadeDoses);
            ps.setString(5, imunidade);
            ps.setString(6, vacinaData);
            ps.setString(7, vacinaHora);
            ps.setString(8, validade);
            ps.setInt(9, id);

            ps.execute();

            JOptionPane.showMessageDialog(null, "Vacina Alterada", "Vacina alterada com sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar", "Banco de Dados não conectado", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void excluir() {
        String sql = "DELETE FROM Vacina WHERE id = ?";

        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();
            JOptionPane.showMessageDialog(null, "Vacina Excluida", "Vacina excluida com sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar", "Banco de Dados não conectado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Vacina listar() {
        Vacina vacina = null;

        String sql = "SELECT * FROM Vacina WHERE id = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            //while(true){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vacina = new Vacina();

                vacina.setId(rs.getInt("id"));
                vacina.setFornecedor(rs.getString("fornecedor"));
                vacina.setNomeVacina(rs.getString("nomeVacina"));
                vacina.setQuantidadeVacinas(rs.getString("quantidadeVacinas"));
                vacina.setQuantidadeDoses(rs.getString("quantidadeDoses"));
                vacina.setImunidade(rs.getString("imunidade"));
                vacina.setVacinaData(rs.getString("vacinaData"));
                vacina.setVacinaHora(rs.getString("vacinaHora"));
                vacina.setValidade(rs.getString("validade"));

                //break;
                //}
            }

        } catch (Exception e) {

        }

        return vacina;
    }

//LISTA O COMBOBOX EM VETOR DE STRINGS COM AS VACINAS
    public String[] listarVacinas() {
        ArrayList<String> vacinas = new ArrayList<String>();

        String sql = "SELECT nomeVacina FROM Vacina";

        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vacinas.add(rs.getString("nomeVacina"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //convert ArrayList para vetor[]
        return vacinas.toArray(new String[vacinas.size()]);
    }

}
