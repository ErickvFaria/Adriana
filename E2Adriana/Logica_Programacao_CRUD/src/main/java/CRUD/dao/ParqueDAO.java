package CRUD.dao;

import CRUD.config.ConnectionFactory;
import CRUD.interfaces.Listavel;
import CRUD.model.Parque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParqueDAO implements Listavel<Parque> {

    public void inserir(Parque parque) {
        String sql = "INSERT INTO parque (nome, localizacao, tipo_terreno, foto) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, parque.getNome());
            stmt.setString(2, parque.getLocalizacao());
            stmt.setString(3, parque.getTipoTerreno());
            stmt.setString(4, parque.getFoto());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Parque parque) {
        String sql = "UPDATE parque SET nome=?, localizacao=?, tipo_terreno=?, foto=? WHERE id=?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, parque.getNome());
            stmt.setString(2, parque.getLocalizacao());
            stmt.setString(3, parque.getTipoTerreno());
            stmt.setString(4, parque.getFoto());
            stmt.setInt(5, parque.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM parque WHERE id=?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Parque> listarTodos() {
        List<Parque> lista = new ArrayList<>();
        String sql = "SELECT * FROM parque";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Parque p = new Parque();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setLocalizacao(rs.getString("localizacao"));
                p.setTipoTerreno(rs.getString("tipo_terreno"));
                p.setFoto(rs.getString("foto"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Parque> buscarPorNome(String termo) {
        List<Parque> lista = new ArrayList<>();
        String sql = "SELECT * FROM parque WHERE nome LIKE ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + termo + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Parque p = new Parque();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setLocalizacao(rs.getString("localizacao"));
                    p.setTipoTerreno(rs.getString("tipo_terreno"));
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
