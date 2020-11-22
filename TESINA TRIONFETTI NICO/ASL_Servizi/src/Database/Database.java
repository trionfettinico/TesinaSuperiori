package Database;


import java.sql.DriverManager; // librerie utilizzate
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Database {

    private String _Host = "localhost"; // nome del host per accedere al database
    private String _Port = "3306"; // porta per accedere al database
    private String _Username = "root"; // username per accedere al database
    private String _Password = "root"; // password per accedere al database 
    private String _Database = "itisjesi-asl"; // nome del database

    static Connection _conn = null; // variabile per creare la connessione
    static public Boolean _Connected = false; // variabile per il controllo della avvenuta connessione
    static java.sql.Statement stmt = null; // oggetto utilizzato per eseguire una istruzione SQL


    public Database() {
        connect("jdbc:mysql://" + _Host + ":" + _Port + "/" + _Database, _Username, _Password); // metodo per la connessione, trasferisce la stringa di connessione 
    }

    private void connect(String DB_URL, String User, String Password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // apro la connessione
            System.out.println("Connecting to database...");
            _conn = (Connection) DriverManager.getConnection(DB_URL, User, Password); // eseguo la connessione
            if (_conn != null) {
                System.out.println("Connessione Riuscita"); // se _conn è diverso da null vuol dire che la connessione è riuscita
                _Connected = true;
                return; // esco dal try
            }

        } catch (Exception e) // vari errori possibili 
        {
            System.out.println("Connessione fallita");
            _Connected = false;
        }
    }

    public String executeUpdateTOJSON(String sql, String methodName, String className) // metodo utilizzato per i servizi di POST DELETE e PUT 
    {
        System.out.println("E' stato utilizzato il metodo : " + methodName + " della classe :" + className);
        StringBuilder json = new StringBuilder("[ "); //
        if (_Connected) // controllo se è stata fatta la connessione al database 
        {
            try {
                stmt = _conn.createStatement(); // 
                int rs = stmt.executeUpdate(sql); // il comando executeUpdate mi permette di far eseguire un query che permette di modificare / cancellare / inserire gli attributi di una tabella
                if (rs != 0) // il comando executeUpdate restituisce un valore intero , e nel caso che la query non è stata eseguita restituisce il valore 0
                {
                    return json.append("{ \"risultato\":\"riuscito\" } ]").toString();
                } else {
                    return json.append("{ \"risultato\":\"fallito\" } ]").toString();
                }

            } catch (SQLException e) {
                return json.append("{ \"risultato\":\"errore query\" } ]").toString();
            }

        } else {
            return json.append("{ \"risultato\":\"errore connessione\" } ]").toString();
        }
    }

    public String executeQueryTOJSON(String sql, String methodName, String className) // metodo utilizzato per eseguire i servizi di GET
    {
        String error = "";
        System.out.println("E' stato utilizzato il metodo : " + methodName + " della classe :" + className);
        StringBuilder json = new StringBuilder("[ ");
        if (_Connected) // controllo l'avvenuta connessione
        {
            try {
                stmt = _conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql); // executeQuery è un comando che permette di eseguire le query di selezione e restituisce le righe del risultato della query
                java.sql.ResultSetMetaData rsmd = rs.getMetaData(); // oggetto rsmd con il comando getMetaData() viene utilizzato per scoprire le colonne dell'oggetto rs 
                int cols = rsmd.getColumnCount(); // il comando getColumnCount() serve per calcolare il numero di colonne dell'oggetto rsmd
                int count = 0; // variabile di appoggio per controllare se si trasferisce un valore nullo
                while (rs.next()) 
                { // ciclo che si ripette in base alle righe di rs{ 
                    count++;
                    json.append("{ ");
                    for (int i = 1; i <= cols; i++) // ciclo che si ripete per il numero oggetti situati nella tabella
                    {
                        boolean check = false;
                        json.append("\"" + rs.getMetaData().getColumnName(i) + "\":");
                        switch (rsmd.getColumnType(i)) {
                            case java.sql.Types.VARCHAR:
                                {
                                    json.append("\"" + rs.getString(i) + "\"");
                                }
                                break;
                            case java.sql.Types.NULL:
                                {
                                    json.append("null");
                                }
                                break;
                            case java.sql.Types.DATE:
                                {
                                    json.append("\"" + rs.getDate(i) + "\"");
                                    check = true;
                                }
                                break;
                            case java.sql.Types.INTEGER:
                                { //4
                                    json.append("\"" + rs.getInt(i) + "\"");
                                    check = true;
                                }
                                break;

                            default:
                                {
                                    if (check == false)
                                        json.append(rs.getObject(i).toString());
                                }
                                break;
                        }
                        json.append(" , ");
                    } //End For 
                    json.setCharAt(json.length() - 2, '}');
                    json.append(" , ");
                }
                if (count == 0) {
                    json.append(" { \"risultato\":\"errore valore nullo\" }   ]");
                }
                else
                {
                json.setCharAt(json.length() - 2, ']');
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                return error = ("{ \"risultato\":\"errore query\" } ]");
            }
            return json.toString();
        } else {
            return error = ("{ \"risultato\":\"errore connessione\" } ]");
        }
    }
}