package com.cadastro.aplicativojavafx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class Conexao {

    public static Connection obterConexao() throws SQLException {
        try {
            // Carrega o arquivo de propriedades
            Properties props = new Properties();
            InputStream input = Conexao.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                throw new SQLException("Arquivo config.properties não encontrado no classpath.");
            }
            props.load(input);

            // Recupera as propriedades
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Carrega o driver do SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Cria a conexão
            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            throw new SQLException("Erro ao obter conexão: " + e.getMessage(), e);
        }
    }

    public static void fecharConexao(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
