import java.math.BigDecimal;
import java.sql.*;

/**
 * Code is from SQLite tutorials
 * Update, Delete, Search, and Add
 * As well as a connection setup to the Database
 */

public class SqlManager {
    /**
     * Connect to the database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\Xavier Naranjo\\IdeaProjects\\inventoryControl_v1.2\\src\\data\\bin";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * select one row in the item table
     */
    public void selectOne(int item_id) {
        String sql = "SELECT item_Id, item_name, price_per_unit, item_type, quantity FROM item WHERE item_id = ?";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            System.out.println(rs.getInt("item_Id") + "\t" +
                    rs.getString("item_name") + "\t" +
                    rs.getBigDecimal("price_per_unit") + "\t" +
                    rs.getString("item_type") + "\t" +
                    rs.getInt("quantity"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new row into the items table
     *
     * @param item_name
     * @param item_Id
     * @param price_per_unit
     * @param item_type
     * @param quantity
     */
    public void add(String item_name, int item_Id, BigDecimal price_per_unit, String item_type, int quantity) {
        String sql = "INSERT INTO item(item_name, item_Id,price_per_unit,item_type,quantity) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item_name);
            pstmt.setInt(2, item_Id);
            pstmt.setBigDecimal(3, price_per_unit);
            pstmt.setString(4, String.valueOf(item_type));
            pstmt.setInt(5, quantity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update data of a item specified by the id
     *
     * @param item_name
     * @param price_per_unit
     * @param item_type
     * @param quantity
     */
    public void update(String item_name, BigDecimal price_per_unit, String item_type, int quantity) {
        String sql = "UPDATE item SET item_name = ? , "
                + "price_per_unit = ? "
                + "item_type = ?"
                + "quantity = ?"
                + "WHERE item_Id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, item_name);
            pstmt.setBigDecimal(2, price_per_unit);
            pstmt.setString(3, item_type);
            pstmt.setInt(4, quantity);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete a item specified by the id
     *
     * @param item_Id
     */
    public void delete(int item_Id) {
        String sql = "DELETE FROM item WHERE item_Id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, item_Id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
