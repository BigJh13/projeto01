package telas;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;


public class ConnectionFactory {
    private String usuario = "covid";
    private String senha = "Covid2021";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "projeto_teste";

    public Connection obtemConexao() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd,
                    usuario,
                    senha
            );
            return c;
            
        }catch(SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch(Exception e){

             e.printStackTrace();
             return null;
        }   
    }
}
