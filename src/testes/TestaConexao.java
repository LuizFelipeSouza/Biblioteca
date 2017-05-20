package testes;

import java.sql.Connection;
import java.sql.SQLException;

import biblioteca.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		try {
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
