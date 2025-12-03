package CRUD.dao;

import CRUD.config.ConnectionFactory;
import CRUD.interfaces.Listavel;
import CRUD.model.Bicicleta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BicicletaDAO implements Listavel<Bicicleta> {

    public void inserir(Bicicleta bicicleta) {
        String sql = "INSERT INTO bicicleta (cor, tamanho, preco, foto) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, bicicleta.getCor());
            stmt.setString(2, bicicleta.getTamanho());
            stmt.setDouble(3, bicicleta.getPreco());
            stmt.setString(4, bicicleta.getFoto());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Bicicleta bicicleta) {
        String sql = "UPDATE bicicleta SET cor=?, tamanho=?, preco=?, foto=? WHERE id=?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, bicicleta.getCor());
            stmt.setString(2, bicicleta.getTamanho());
            stmt.setDouble(3, bicicleta.getPreco());
            stmt.setString(4, bicicleta.getFoto());
            stmt.setInt(5, bicicleta.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM bicicleta WHERE id=?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bicicleta> listarTodos() {
        List<Bicicleta> lista = new ArrayList<>();
        String sql = "SELECT * FROM bicicleta";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Bicicleta b = new Bicicleta();
                b.setId(rs.getInt("id"));
                b.setCor(rs.getString("cor"));
                b.setTamanho(rs.getString("tamanho"));
                b.setPreco(rs.getDouble("preco"));
                b.setFoto(rs.getString("foto"));
                lista.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Bicicleta> buscarPorNome(String termo) {
        List<Bicicleta> lista = new ArrayList<>();
        String sql = "SELECT * FROM bicicleta WHERE cor LIKE ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + termo + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Bicicleta b = new Bicicleta();
                    b.setId(rs.getInt("id"));
                    b.setCor(rs.getString("cor"));
                    b.setTamanho(rs.getString("tamanho"));
                    b.setPreco(rs.getDouble("preco"));
                    b.setFoto(rs.getString("foto"));
                    lista.add(b);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
