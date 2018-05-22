import java.sql.*;
import java.util.Date;

public class test {
    public static void main(String[] args){

        MySQL mySQL = new MySQL();
        Connection conn = null;
        try {
            conn = mySQL.getConnection("jdbc:mysql://localhost:3306/xs","root","miller0924");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Statement statement;
        ResultSet rs;

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
