package config;

public class DatabaseConfig {
    public static final String DATABASE_HOST = "localhost";
    public static final int DATABASE_PORT = 5432;
    public static final String DATABASE_NAME = "postgres";
    public static final String DATABASE_USER = "postgres";
    public static final String DATABASE_PASSWORD = "password";

    public static String getConnectionURL() {
        return "jdbc:postgresql://"+DATABASE_HOST+":"+DATABASE_PORT+"/"+DATABASE_NAME;
    }
}
