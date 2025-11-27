package LinguagemProgramacao.exercicio_2;

import LinguagemProgramacao.exercicio_2.database.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParqueDAO {

    public void salvar(Parque parque) {
        String sql = "INSERT INTO parque (nome, cidade) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, parque.getNome());
            pst.setString(2, parque.getCidade());
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Parque> listar() {
        List<Parque> lista = new ArrayList<>();
        String sql = "SELECT * FROM parque";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Parque(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cidade")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
