package id.ac.telkomuniversity.dph3a4.studentmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SqliteHelper extends SQLiteOpenHelper {

    // db version
    private static final int DATABASE_VERSION = 1;

    // db name
    private static final String DATABASE_NAME = "organisasi.db";

    // User table name
    private static final String TABLE_MAHASISWA = "mahasiswa";
    private static final String TABLE_PENGURUS = "pengurus";

    // Column name
//    private static final String COLUMN_ID = "id";
//    private static final String COLUMN_USERNAME = "username";
//    private static final String COLUMN_PASSWORD = "password";
//    private static final String COLUMN_EMAIL = "email";
//    private static final String COLUMN_NAMALENGKAP = "namaLengkap";
//    private static final String COLUMN_NOHP = "noHp";
//    private static final String COLUMN_IDLINE = "idLine";
//    private static final String COLUMN_JENISKELAMIN = "jenisKelamin";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NIM = "nim";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_NOHP = "noHp";
    private static final String COLUMN_IDLINE = "idLine";
    private static final String COLUMN_FOTO = "foto";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    // CREATE TABLE PENGURUS
    private String CREATE_TABLE_PENGURUS = "CREATE TABLE " + TABLE_PENGURUS + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NIM + " TEXT," +
            COLUMN_NAMA + " TEXT," +
            COLUMN_NOHP + " TEXT," +
            COLUMN_IDLINE + " TEXT," +
            COLUMN_FOTO + " TEXT," +
            COLUMN_EMAIL + " TEXT," +
            COLUMN_PASSWORD + " TEXT )";

    // create table sql query
//    private String CREATE_TB_MHS = "CREATE TABLE " + TABLE_MAHASISWA + "(" +
//            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//            COLUMN_USERNAME + " TEXT," +
//            COLUMN_PASSWORD + " TEXT," +
//            COLUMN_EMAIL + " TEXT," +
//            COLUMN_NAMALENGKAP + " TEXT," +
//            COLUMN_NOHP + " TEXT," +
//            COLUMN_IDLINE + " TEXT," +
//            COLUMN_JENISKELAMIN + " TEXT )";

    // DROP TABLE SQL QUERY
    private String DROP_TB_MHS = "DROP TABLE IF EXISTS " + TABLE_MAHASISWA;
    private String DROP_TABLE_PENGURUS = "DROP TABLE IF EXISTS " + TABLE_PENGURUS;

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    public void createAdmin(){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USERNAME, "admin");
//        values.put(COLUMN_PASSWORD, "admin");
//        values.put(COLUMN_EMAIL, "admin@admin.com");
//        values.put(COLUMN_NAMALENGKAP, "Muhammad Luqman");
//        values.put(COLUMN_NOHP, "087821043037");
//        values.put(COLUMN_IDLINE, "admin");
//        values.put(COLUMN_JENISKELAMIN, "Laki-laki");
//
//        db.insert(TABLE_MAHASISWA, null, values);
//        db.close();
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PENGURUS);
        createAdmin(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // DROP TABLE MHS IF EXISTS
        db.execSQL(DROP_TB_MHS);
        db.execSQL(DROP_TABLE_PENGURUS);

        // CREATE TABLE AGAIN
        onCreate(db);
    }

    // CREATE NEW DATA MAHASISWA
//    public void createMahasiswa(Mahasiswa mhs){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USERNAME, mhs.getUsername());
//        values.put(COLUMN_PASSWORD, mhs.getPassword());
//        values.put(COLUMN_EMAIL, mhs.getEmail());
//        values.put(COLUMN_NAMALENGKAP, mhs.getNamaLengkap());
//        values.put(COLUMN_NOHP, mhs.getNoHp());
//        values.put(COLUMN_IDLINE, mhs.getIdLine());
//        values.put(COLUMN_JENISKELAMIN, mhs.getJenisKelamin());
//
//        db.insert(TABLE_MAHASISWA, null, values);
//        db.close();
//    }

    public void createAdmin(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NIM, "admin");
        values.put(COLUMN_NAMA, "Muhammad Luqman");
        values.put(COLUMN_NOHP, "087821043037");
        values.put(COLUMN_IDLINE, "admin");
        values.put(COLUMN_FOTO, "foto");
        values.put(COLUMN_EMAIL, "admin@admin.com");
        values.put(COLUMN_PASSWORD, "admin");
        db.insert(TABLE_PENGURUS, null, values);

        values = new ContentValues();
        values.put(COLUMN_NIM, "admin2");
        values.put(COLUMN_NAMA, "Muhammad Luqman 2");
        values.put(COLUMN_NOHP, "087821043037");
        values.put(COLUMN_IDLINE, "admin");
        values.put(COLUMN_FOTO, "foto");
        values.put(COLUMN_EMAIL, "admin@admin.com");
        values.put(COLUMN_PASSWORD, "admin2");

        db.insert(TABLE_PENGURUS, null, values);
    }

    // RETURN ALL DATA MAHASISWA
//    public List<Mahasiswa> getAllMhs() {
//        // ARRAY OF COLUMN
//        String[] columns = {
//                COLUMN_ID,
//                COLUMN_USERNAME,
//                COLUMN_PASSWORD,
//                COLUMN_EMAIL,
//                COLUMN_NAMALENGKAP,
//                COLUMN_NOHP,
//                COLUMN_IDLINE,
//                COLUMN_JENISKELAMIN
//        };
//
//        // SORTING
//        String sortOrder = COLUMN_USERNAME + " ASC";
//        List<Mahasiswa> listMhs = new ArrayList<Mahasiswa>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_MAHASISWA,
//                columns, // COLUMN YANG DIKEMBALIKAN
//                null, // KLAUSA WHERE
//                null, // VALUE KLAUSA WHERE
//                null, // GROUP BY
//                null, // HAVING (GROUP BY FILTER)
//                sortOrder);
//
//        if (cursor.moveToFirst()){
//            do {
//                Mahasiswa mhs = new Mahasiswa();
//                mhs.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_ID))));
//                mhs.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
//                mhs.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
//                mhs.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
//                mhs.setNamaLengkap(cursor.getString(cursor.getColumnIndex(COLUMN_NAMALENGKAP)));
//                mhs.setNoHp(cursor.getString(cursor.getColumnIndex(COLUMN_NOHP)));
//                mhs.setIdLine(cursor.getString(cursor.getColumnIndex(COLUMN_IDLINE)));
//                mhs.setJenisKelamin(cursor.getString(cursor.getColumnIndex(COLUMN_JENISKELAMIN)));
//
//                // ADD MHS RECORD TO LIST
//                listMhs.add(mhs);
//            }while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//
//        return listMhs;
//    }

    // UPDATE MHS
//    public void updateMahasiswa(Mahasiswa mhs) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USERNAME, mhs.getUsername());
//        values.put(COLUMN_PASSWORD, mhs.getPassword());
//        values.put(COLUMN_EMAIL, mhs.getEmail());
//        values.put(COLUMN_NAMALENGKAP, mhs.getNamaLengkap());
//        values.put(COLUMN_NOHP, mhs.getNoHp());
//        values.put(COLUMN_IDLINE, mhs.getIdLine());
//        values.put(COLUMN_JENISKELAMIN, mhs.getJenisKelamin());
//
//        db.update(TABLE_MAHASISWA, values, COLUMN_ID + " = ?",
//                new String[]{String.valueOf(mhs.getId())});
//        db.close();
//    }
//
//    // DELETE MAHASISWA
//    public void deleteMahasiswa(Mahasiswa mhs) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        // DELETE BY ID
//        db.delete(TABLE_MAHASISWA, COLUMN_ID + " = ?",
//                new String[]{String.valueOf(mhs.getId())});
//        db.close();
//    }

    // CHECK MAHASISWA EXISTS
//    public boolean checkRegister(String username) {
//
//        String[] columns = {
//                COLUMN_ID};
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        String selection = COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
//        String[] selectionArgs = {username};
//
//        // QUERY TABLE MAHASISWA WITH CONDITIOn
//        Cursor cursor = db.query(TABLE_MAHASISWA,
//                columns, // kolom yang dikembalikan
//                selection, // where
//                selectionArgs, // where value
//                null, //group by
//                null, // group filter
//                null); // order by
//
//        int cursorCount = cursor.getCount();
//        cursor.close();
//        db.close();
//
//        if (cursorCount > 0) {
//            return true;
//        }
//
//        return false;
//    }

//    public boolean checkLogin(String username, String password) {
//
//        // array of columns to fetch
//        String[] columns = {
//                COLUMN_ID
//        };
//        SQLiteDatabase db = this.getReadableDatabase();
//        // selection criteria
//        String selection = COLUMN_USERNAME + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
//
//        // selection arguments
//        String[] selectionArgs = {username, password};
//
//        // query user table with conditions
//        Cursor cursor = db.query(TABLE_MAHASISWA, //Table to query
//                columns,                    //columns to return
//                selection,                  //columns for the WHERE clause
//                selectionArgs,              //The values for the WHERE clause
//                null,                       //group the rows
//                null,                       //filter by row groups
//                null);                      //The sort order
//
//        int cursorCount = cursor.getCount();
//
//        cursor.close();
//        db.close();
//        if (cursorCount > 0) {
//            return true;
//        }
//
//        return false;
//    }

    public int checkLogin(String nim, String password) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_ID,
                COLUMN_NIM
        };

        SQLiteDatabase db = this.getReadableDatabase();
        // SELECTION CRITERIA
        String selection = COLUMN_NIM + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        // SELECTION ARGUMENT
        String[] selectionArgs = {nim, password};

        // QUERY
        Cursor cursor = db.query(TABLE_PENGURUS, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();
        int id = 0;

        while (cursor.moveToNext()){
            id = cursor.getInt(0);
        }
        Log.d("GET USER", "checkLogin: " + id);

        cursor.close();
        db.close();
        return id;
    }
}
