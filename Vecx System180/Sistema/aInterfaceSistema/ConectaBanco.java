package aInterfaceSistema;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco{
    public Connection Conecta(){
    	Connection Conecta = null;
    	try{
            String url="jdbc:mysql://localhost:3306/vecxsystembd?autoReconnect=true&useSSL=false";
            String user="root";
            String password="";
            String driver="com.mysql.jdbc.Driver";
            Class.forName(driver);
            Conecta = DriverManager.getConnection(url,user,password);
            return Conecta;
        }
        catch (ClassNotFoundException  e){
            JOptionPane.showMessageDialog(null,"Driver não encontrado","Erro",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    	catch (SQLException e) {
    		JOptionPane.showMessageDialog(null,"Nao foi possivel conectar ao Banco de Dados","Erro",JOptionPane.ERROR_MESSAGE);
    		 return null;
    	}
    }
}