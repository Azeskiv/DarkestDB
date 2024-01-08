import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "darkest_db.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla de Personajes
        String SQL_CREATE_PERSONAJES_TABLE = "CREATE TABLE " + Contract.PersonajeEntry.TABLE_NAME + " (" +
                Contract.PersonajeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.PersonajeEntry.COLUMN_NOMBRE + " TEXT NOT NULL, " +
                Contract.PersonajeEntry.COLUMN_TIPO + " TEXT NOT NULL, " +
                Contract.PersonajeEntry.COLUMN_NIVEL + " INTEGER NOT NULL, " +
                Contract.PersonajeEntry.COLUMN_EXP + " INTEGER NOT NULL, " +
                Contract.PersonajeEntry.COLUMN_IMAGEN + " TEXT);";

        // Crear la tabla de Encuentros
        String SQL_CREATE_ENCUENTROS_TABLE = "CREATE TABLE " + Contract.EncuentroEntry.TABLE_NAME + " (" +
                Contract.EncuentroEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.EncuentroEntry.COLUMN_NUMERO + " INTEGER NOT NULL, " +
                Contract.EncuentroEntry.COLUMN_SEMANA + " TEXT NOT NULL, " +
                Contract.EncuentroEntry.COLUMN_PERSONAJE1 + " TEXT NOT NULL, " +
                Contract.EncuentroEntry.COLUMN_PERSONAJE2 + " TEXT NOT NULL, " +
                Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE1 + " INTEGER NOT NULL, " +
                Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE2 + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_PERSONAJES_TABLE);
        db.execSQL(SQL_CREATE_ENCUENTROS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Manejar la actualización de la base de datos si es necesario
    }
}
