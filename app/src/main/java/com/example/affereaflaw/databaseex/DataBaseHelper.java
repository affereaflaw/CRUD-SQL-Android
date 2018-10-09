package com.example.affereaflaw.databaseex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Affe Reaflaw on 7/19/2017.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "Presensi";
    private static final String TABLE_NAME = "Persons";
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "Name";
    private static final String KEY_KELAS = "Kelas";
    private static final String KEY_TELP = "Telp";
    private static final String KEY_NO = "No";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (_id integer primary key autoincrement, Name text not null, Kelas text not null, Telp text not null, No text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS "+TABLE_NAME);
        onCreate(db);
    }

    public void addPerson (Person person){
        SQLiteDatabase dtb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,person.getName());
        values.put(KEY_KELAS,person.getKelas());
        values.put(KEY_TELP,person.getTelp());
        values.put(KEY_NO,person.getNo());

        dtb.insert(TABLE_NAME,null,values);
        dtb.close();
    }

    public int updatePerson (Person person){
        SQLiteDatabase dtb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,person.getName());
        values.put(KEY_KELAS,person.getKelas());
        values.put(KEY_TELP,person.getTelp());
        values.put(KEY_NO,person.getNo());

        return dtb.update(TABLE_NAME,values,KEY_ID+" =?",new String[]{String.valueOf(person.getId())});
    }

    public void deletePerson (Person person){
        SQLiteDatabase dtb = this.getWritableDatabase();
        dtb.delete(TABLE_NAME,KEY_ID+" =?",new String[]{String.valueOf(person.getId())});
        dtb.close();
    }

    public Person getPerson (int id){
        SQLiteDatabase dtb = this.getReadableDatabase();
        Cursor cursor = dtb.query(TABLE_NAME,new String[]{KEY_ID,KEY_NAME,KEY_NO},KEY_ID+"-?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        return new Person(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
    }

    public List<Person> getAllPerson(){
        List<Person> lstPerson = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase dtb = this.getWritableDatabase();
        Cursor cursor = dtb.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do{
                Person person = new Person();
                person.setId(cursor.getInt(0));
                person.setName(cursor.getString(1));
                person.setKelas(cursor.getString(2));
                person.setTelp(cursor.getString(3));
                person.setNo(cursor.getString(4));

                lstPerson.add(person);
            }
            while (cursor.moveToNext());
        }
        return lstPerson;
    }
}