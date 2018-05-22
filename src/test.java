import java.sql.*;
import java.util.Date;

public class test {
    public static void main(String[] args){

        MySQL mySQL = new MySQL();
        Connection conn = mySQL.getConnection();
        Statement statement;
        ResultSet rs;
        try {
            mySQL.getConnection("jdbc:mysql://localhost:3306/xs","root","miller0924");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql  = "select * from xs";
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                Date birth= rs.getDate("birth");

                System.out.print("ID: " + id);
                System.out.print(", name: " + name);
                System.out.print(" birth " + birth);
                System.out.print("\n");

            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
