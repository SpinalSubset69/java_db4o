package DataAccess;

import com.db4o.*;

public class DataAccessLayer {

    //Primero se abre la base de datos
    public ObjectContainer db;

    public DataAccessLayer() {
    }

    public void openConnection() {
        this.db = Db4o.openFile("uat.yap");
    }

    public void closeConnection() {
        this.db.close();
    }
}
