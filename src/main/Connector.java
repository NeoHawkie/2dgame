/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.sql.*;
/**
 *
 * @author Aluno
 */
public class Connector {
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static String saveScore = "insert into scores value (null, ? )";
    private static String showScore = "select score from scores order by score asc limit 5";
    
    //CONEXAO
    
    /* private static String DRIVER = "org.sqlite.JDBC";
    private static String BD = "jdbc:sqlite:resources/bdclientes.db";
    private static Connection conexao;*/
    
    //Variáveis para os detalhes de conexão
    private static final String url = "jdbc:mysql://localhost:3306/2dgame";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection conexao;     
    private static Connector conn; //instancia

    private Connector() {}

    public static synchronized Connector getConn() {
        if(conn == null) {
            conn = new Connector();
        }
        return conn;
    }

    public Connection abrirConexao() {
       try {
            // Carregar o driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection(url, user, password);
            conexao.setAutoCommit(false); 
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage()); 
        }
        return conexao;
    }

    public void fecharConexao() {
        try {
            if(conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexao: "+e.getMessage());
        } finally {
            conexao = null;
        }
    }
    
    
    //BD
    public static void main(String[] args) {
        try {
            Connector.getConn().abrirConexao();
            System.out.println("Conectado a base com sucesso");
            Connector.getConn().fecharConexao();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println("Erro: " + e.getMessage());
            System.exit(0);
        }
    }
    
    
    public void updateScore(double playTime){
        try {
            Connection connection = abrirConexao();
            preparedStatement = connection.prepareStatement(saveScore);
            preparedStatement.setDouble(1, playTime);
            
            preparedStatement.execute();
            conexao.commit();
            
            System.out.println("Score table updated.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao atualizar a pontuação: "+ e.getMessage());
        }
    }
    
    public double[] showScore(){
        double[] highscore = new double[5];
        try {
            Connection connection = abrirConexao();
            preparedStatement = connection.prepareStatement(showScore);
            resultSet = preparedStatement.executeQuery();
            
            int i = 0;
            while (resultSet.next()) {
                highscore[i++] = resultSet.getDouble("score");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar as pontuações: " + e.getMessage());
        }
        return highscore;
        
    }
}
