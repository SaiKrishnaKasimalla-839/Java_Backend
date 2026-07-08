import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOorder{

    public void getAllOrders(){

        String sql = "SELECT * FROM techmOrders";

        try {

            Connection con = DbC.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        rs.getInt("order_id") + " "
                        + rs.getString("customer_name") + " "
                        + rs.getString("product_name") + " "
                        + rs.getInt("quantity") + " "
                        + rs.getDouble("price") + " "
                        + rs.getString("status") + " "
                        + rs.getDate("order_date"));

            }

            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void getById() {
        String sql = "SELECT * FROM techmOrders WHERE order_id = ?";
        try {

            Connection con = DbC.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 101);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getInt("order_id") + " "
                        + rs.getString("customer_name") + " "
                        + rs.getString("product_name") + " "
                        + rs.getInt("quantity") + " "
                        + rs.getDouble("price") + " "
                        + rs.getString("status") + " "
                        + rs.getDate("order_date"));

            } else {

                System.out.println("Order not found.");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }


        public void insertData() {

    String sql = "INSERT INTO techmOrders VALUES(?,?,?,?,?,?,?)";

    try {

        Connection con = DbC.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, 111);
        ps.setString(2, "Vaishu");
        ps.setString(3, "Lipstick");
        ps.setInt(4, 4);
        ps.setDouble(5, 457.5);
        ps.setString(7, "Shipped");
        ps.setDate(6, java.sql.Date.valueOf("2026-07-27"));

        int rows = ps.executeUpdate();

        System.out.println(rows + " row inserted successfully.");

        ps.close();
        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
        }




        public void updateData() {

    String sql = "UPDATE techmOrders SET product_name = ? WHERE order_id = ?";

    try {

        Connection con = DbC.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, "Washing Machine");
        ps.setInt(2, 111);

        int rows = ps.executeUpdate();

        System.out.println(rows + " row updated successfully.");

        ps.close();
        con.close();

    } catch (SQLException e) {

        e.printStackTrace();

    }
}
public void deleteOrder(int orderId) {

    String sql = "DELETE FROM techmOrders WHERE order_id = ?";

    try {

        Connection con = DbC.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, orderId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Order deleted successfully.");
        } else {
            System.out.println("Order ID not found.");
        }

        ps.close();
        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

        }

