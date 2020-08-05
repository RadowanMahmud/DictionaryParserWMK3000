package sqliteDbPack;

import java.sql.*;

public class Main {

    private Connection connect() {
        String url = "jdbc:sqlite:C://sqlite/db/WMK3000.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewTable(String sql) {
        String url = "jdbc:sqlite:C://sqlite/db/WMK3000.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {

        createNewDatabase("WMK3000.db");

        String Word = "CREATE TABLE IF NOT EXISTS Word (\n"
                + "	word text,\n"
                + "	id int PRIMARY KEY,\n"
                + "	parts_of_speech text,\n"
                + " meaning text\n"
                + ");";

        String SubMeaning = "CREATE TABLE IF NOT EXISTS SubMeaning (\n"
                + "	id int,\n"
                + "	submeaning_id int PRIMARY KEY,\n"
                + "	submeaning text\n"
                + ");";

        String Example = "CREATE TABLE IF NOT EXISTS Example (\n"
                + "	submeaning_id int,\n"
                + "	example text\n"
                + ");";

        String Synonyms = "CREATE TABLE IF NOT EXISTS Synonyms (\n"
                + "	id int,\n"
                + "	synonyms text\n"
                + ");";

        String MoreExample = "CREATE TABLE IF NOT EXISTS MoreExample (\n"
                + "	id int,\n"
                + "	more_example text\n"
                + ");";

        String idioms = "CREATE TABLE IF NOT EXISTS idioms (\n"
                + "	word text,\n"
                + "	idioms text\n"
                + ");";
        String phrases = "CREATE TABLE IF NOT EXISTS phrases (\n"
                + "	word text,\n"
                + "	phrases text\n"
                + ");";

        createNewTable(Word);
        createNewTable(SubMeaning);
        createNewTable(Example);
        createNewTable(Synonyms);
        createNewTable(MoreExample);
        createNewTable(idioms);
        createNewTable(phrases);

        //Main app = new Main();
        // insert three new rows
        //app.insert("Raw Materials", 3000);
        //app.insert("Semifinished Goods", 4000);
        //app.insert("Finished Goods", 5000);
    }
}