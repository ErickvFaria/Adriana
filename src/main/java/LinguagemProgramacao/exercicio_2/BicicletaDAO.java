package LinguagemProgramacao.exercicio_2;

import LinguagemProgramacao.exercicio_2.database.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BicicletaDAO {

    public void salvar(Bicicleta bicicleta) {
        String sql = "INSERT INTO bicicleta (modelo, marchas) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, bicicleta.getModelo());
            pst.setInt(2, bicicleta.getMarchas());
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Bicicleta> listar() {
        List<Bicicleta> lista = new ArrayList<>();
        String sql = "SELECT * FROM bicicleta";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Bicicleta(
                        rs.getInt("id"),
                        rs.getString("modelo"),
                        rs.getInt("marchas")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
