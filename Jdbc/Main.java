import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        String username = "XXXXXX";
        String password = "XXXXXXXXXXX";

        try {
            Connection con=DriverManager.getConnection(url, username, password);

            String sql="SELECT * FROM techmOrders";

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery(sql);

            while (rs.next()){

                System.out.println(
                        rs.getInt("order_id") + " | " +
                        rs.getString("customer_name") + " | " +
                        rs.getString("product_name") + " | " +
                        rs.getInt("quantity") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getDate("order_date") + " | " +
                        rs.getString("status"));
            }

            rs.close();
            st.close();
            con.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}