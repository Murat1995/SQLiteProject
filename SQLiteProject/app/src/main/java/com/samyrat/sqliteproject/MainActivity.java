package com.samyrat.sqliteproject;

import static java.sql.Types.VARCHAR;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.sql.SQLDataException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase database = this.openOrCreateDatabase
                    ("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians " +
                    "(id INTEGER PRIMARY KEY , name VARCHAR,age INTEGER)");

            //database.execSQL("INSERT INTO musicians(name,age) VALUES ('JAMES',50)");
            //database.execSQL("INSERT INTO musicians(name,age) VALUES ('LARS',60)");
            //database.execSQL("INSERT INTO musicians(name,age) VALUES ('BAG',55)");

            //database.execSQL(" UPDATE musicians SET age = 61 WHERE name  = 'LARS'");
            //database.execSQL(" UPDATE musicians SET name = 'KIRK HAMMET' WHERE id = 3");
            //database.execSQL("DELETE FROM musicians WHERE id = 2 ");

            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name = 'LARS'",null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE 'B%' ",null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE '%s' ",null);

            Cursor cursor = database.rawQuery("SELECT * FROM musicians ",null);




            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){

                System.out.println("Name: " + cursor.getString(nameIx));
                System.out.println("Age: " + cursor.getInt(ageIx));
                System.out.println("id" + cursor.getInt(idIx));

            }
            cursor.close();


        }catch (Exception e){
            e.printStackTrace();

        }


    }
}