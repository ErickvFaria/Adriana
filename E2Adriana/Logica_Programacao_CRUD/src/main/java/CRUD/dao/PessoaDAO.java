package CRUD.dao;

import CRUD.config.ConnectionFactory;
import CRUD.interfaces.Listavel;
import CRUD.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements Listavel<Pessoa> {

    public void inserir(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, idade, altura, foto) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setDouble(3, pessoa.getAltura());
            stmt.setString(4, pessoa.getFoto());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void atualizar(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome=?, idade=?, altura=?, foto=? WHERE id=?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setDouble(3, pessoa.getAltura());
            stmt.setString(4, pessoa.getFoto());
            stmt.setInt(5, pessoa.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM pessoa WHERE id=?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pessoa> listarTodos() {
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setAltura(rs.getDouble("altura"));
                p.setFoto(rs.getString("foto"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Pessoa> buscarPorNome(String termo) {
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa WHERE nome LIKE ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + termo + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pessoa p = new Pessoa();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setIdade(rs.getInt("idade"));
                    p.setAltura(rs.getDouble("altura"));
                    p.setFoto(rs.getString("foto"));
                    lista.add(p);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
