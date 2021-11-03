package es.system.daniel.zoo.dao.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import es.system.daniel.zoo.dao.contracts.AnimalContract;
import es.system.daniel.zoo.dao.contracts.SpeciesContract;
import es.system.daniel.zoo.dao.contracts.ZooContract;

public class CommonDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "zoodbb.db";

    public CommonDbHelper(Context context) {
        super(context, DATABASE_NAME,
                null, DATABASE_VERSION);
    }

    public CommonDbHelper(Context context, String table,
                          SQLiteDatabase.CursorFactory factory, int tableVersion) {
        super(context, table, factory, tableVersion);
    }

    /**
     * Metodo encargado en crear la tabla de la BBDD
     * @param sqLiteDatabase BBDD SqLite
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + SpeciesContract.SpeciesEntry.TABLE_NAME + " ("
                + SpeciesContract.SpeciesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SpeciesContract.SpeciesEntry.VULGAR_NAME + " TEXT NOT NULL,"
                + SpeciesContract.SpeciesEntry.SCIENTIFIC_NAME + " TEXT NOT NULL,"
                + SpeciesContract.SpeciesEntry.FAMILY + " TEXT NOT NULL,"
                + SpeciesContract.SpeciesEntry.ENDANGERED + " INTEGER NOT NULL DEFAULT 0,"
                + "UNIQUE (" + SpeciesContract.SpeciesEntry.VULGAR_NAME + "))");
        sqLiteDatabase.execSQL("CREATE TABLE " + ZooContract.ZooEntry.TABLE_NAME + " ("
                + ZooContract.ZooEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ZooContract.ZooEntry.NAME + " TEXT NOT NULL,"
                + ZooContract.ZooEntry.CITY + " TEXT NOT NULL,"
                + ZooContract.ZooEntry.COUNTRY + " TEXT NOT NULL,"
                + ZooContract.ZooEntry.SIZE + " INTEGER NOT NULL,"
                + ZooContract.ZooEntry.YEARLY_INCOME + " INTEGER NOT NULL,"
                + "UNIQUE (" + ZooContract.ZooEntry.NAME + "))");
        sqLiteDatabase.execSQL("CREATE TABLE " + AnimalContract.AnimalEntry.TABLE_NAME + " ("
                + AnimalContract.AnimalEntry._ID + " INTEGER PRIMARY KEY,"
                + AnimalContract.AnimalEntry.SEX + " TEXT NOT NULL,"
                + AnimalContract.AnimalEntry.COUNTRY + " TEXT NOT NULL,"
                + AnimalContract.AnimalEntry.CONTINENT + " TEXT NOT NULL,"
                + AnimalContract.AnimalEntry.BIRTH_YEAR + " INTEGER NOT NULL,"
                + AnimalContract.AnimalEntry.SPECIES_ID + " INTEGER NOT NULL REFERENCES "
                + SpeciesContract.SpeciesEntry.TABLE_NAME + "(" + SpeciesContract.SpeciesEntry._ID + "),"
                + AnimalContract.AnimalEntry.ZOO_ID + " INTEGER NOT NULL REFERENCES "
                + ZooContract.ZooEntry.TABLE_NAME + "(" + ZooContract.ZooEntry._ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // No hay operaciones
    }

    /**
     * Metodo encargado de realizar la operacion de insercion en la tabla
     * @param table
     * @param values
     * @return
     */
    public long save(String table, ContentValues values) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                table,
                null,
                values);
    }

    /**
     * Funcion encargada de retornar todos los elementos de la BBDD
     * @param table Tabla sobre la que se realiza la operacion
     * @param columns Lista de Columnas a consultar
     * @param selection Columnas para la clausula WHERE
     * @param selectionArgs Valores a comparar con las columnas del WHERE
     * @param groupBy Agrupar con GROUP BY
     * @param having Condición HAVING para GROUP BY
     * @param orderBy Clausula ORDER BY
     * @return
     */
    public Cursor getAll(String table, String[] columns,
                         String selection,
                         String[] selectionArgs,
                         String groupBy,
                         String having,
                         String orderBy) {

        return getReadableDatabase()
                .query(
                        table,
                        columns,
                        selection,
                        selectionArgs,
                        groupBy,
                        having,
                        orderBy
                );
    }

    /**
     * Funcion encargada de realizar la eleminancion de un elemento de la BBDD
     * @param table sobre la que se realiza la operacion
     * @param clausulaWhere clausula where
     * @param whereCampos campos de la clausula
     * @return entero con el resultado de la operacion
     */
    public int delete(String table,
                      String clausulaWhere,
                      String[] whereCampos) {
        return getWritableDatabase().delete(
                table,
                clausulaWhere,
                whereCampos
        );
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento de la BBDD
     * @param table sobre la que se realiza la operacion
     * @param contentValues valores a actualizar
     * @param clausulaWhere clausula where
     * @param whereCampos campos de la clausula
     * @return entero con el resultado de la operacion
     */
    public int update(String table, ContentValues contentValues,
                      String clausulaWhere,
                      String[] whereCampos) {
        return getWritableDatabase().update(
                table,
                contentValues,
                clausulaWhere,
                whereCampos
        );
    }

}
