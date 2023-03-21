package jdbc;

import lombok.var;
import metier.ICreditMetier;
import model.Credit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Bankati",
                userName = "bankerUser",
                password = "banker";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;

        PreparedStatement ps = null;
        List<Credit> credits = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Le driver de MySql a été chargé avec succés");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connexion établit à la BD Bankati");


            /*ps = connection.prepareStatement("select * FROM  crédit where  id = ? and Capitale = ?");
            ps.setLong(1,1L);
            ps.setDouble(2,300000);*/

            ps = connection.prepareStatement("select * from crédit");
            resultSet = ps.executeQuery();

            statement = connection.createStatement();
            //resultSet = statement.executeQuery("SELECT  * FROM crédit");

            resultSetMetaData = resultSet.getMetaData();
            System.out.println("-----------------------------------------------");


        while (resultSet.next()){
            var id = resultSet.getLong("id");
            var capitale = resultSet.getDouble("Capitale");
            var nbrM = resultSet.getInt("nbrM");
            var taux = resultSet.getDouble("Taux");
            var nom = resultSet.getString("Nom_Demandeur");
            var mensualite = resultSet.getDouble("Mensualité");

            Credit credit = new Credit(id,capitale,nbrM,taux,nom,mensualite);

            credits.add(credit);
        }
        credits.forEach(System.out::println);

            /*while (resultSet.next()) {
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
                    System.out.println("\t" + resultSetMetaData.getColumnName(i).toUpperCase()
                            + " : " + resultSet.getObject(i).toString() + "\t |");

                System.out.println("-----------------------------------------------"); }*/
            }
        catch(SQLException e){
                System.err.println("BD introuvable");
            }
        catch(ClassNotFoundException e){
                System.err.println("driver introuvable");
            }
        finally{
                if (connection == null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (statement == null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (resultSet == null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}