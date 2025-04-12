package DAO;

import Model.Cliente;
import Utils.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, email, telefone) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}