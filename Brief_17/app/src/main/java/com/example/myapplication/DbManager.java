package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "briefDB";
    private static final String TABLE_NAME = "condidat";

    private static final String KEY_ID = "id";
    private static final String KEY_NOM = "nom";
    private static final String KEY_PRENOM = "prenom";
    private static final String KEY_EMAIL = "shop_address";

    public DbManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_NOM, KEY_PRENOM, KEY_EMAIL);
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /*
     *
     */
    public void insert(Candidat candidat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,candidat.getId());
        values.put(KEY_NOM, candidat.getNom());
        values.put(KEY_PRENOM, candidat.getPrenom());
        values.put(KEY_EMAIL, candidat.getEmail());
        //

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Candidat get(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NOM, KEY_PRENOM, KEY_EMAIL}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Candidat candidat = new Candidat(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return candidat;
    }

    public List<Candidat> getAll() {
        List<Candidat> listCandidat = new ArrayList<Candidat>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Candidat candidat = new Candidat();

                candidat.setId(Integer.parseInt(cursor.getString(0)));
                candidat.setNom(cursor.getString(1));
                candidat.setPrenom(cursor.getString(2));
                candidat.setEmail(cursor.getString(3));

                listCandidat.add(candidat);
            } while (cursor.moveToNext());
        }

        return listCandidat;
    }

    public int update(Candidat candidat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NOM, candidat.getNom());
        values.put(KEY_PRENOM, candidat.getPrenom());
        values.put(KEY_EMAIL, candidat.getEmail());

        return db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[]{String.valueOf(candidat.getId())});
    }

    public void delete(Candidat candidat) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]{String.valueOf(candidat.getId())});
        db.close();
    }
}
