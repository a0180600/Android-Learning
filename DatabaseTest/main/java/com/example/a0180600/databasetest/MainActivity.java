package com.example.a0180600.databasetest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by a0180600 on 16-8-14.
 */
public class MainActivity extends Activity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 3);

        /**
         * 创建数据库
         */
        Button createDataBase = (Button) findViewById(R.id.create_database);
        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        /**
         * 添加数据
         * db.execSQL("insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
         *              new String[] { "The Da Vinici Code", "Dan Brown", "454", "16.96"});
         * db.execSQL("insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
         *              new String[] { "The Lost Symbol", "Dan Brown", "510", "19.95"});
         */
        Button addButton = (Button) findViewById(R.id.add_data);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                // 第一条数据组装
                values.put("name", "The Da Vinici Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book", null, values);
                values.clear();
                // 第二条数据组装
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                db.insert("Book", null, values);
                values.clear();
            }
        });

        /**
         * 更新数据
         * db.execSQL("update Book set price = ? where name = ?",
         *              new String[] { "10.99", "The Da Vinci Code" });
         */
        Button updateButton = (Button) findViewById(R.id.update_data);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                db.update("Book", values, "name = ?", new String[] { "The Da Vinici Code" });

            }
        });

        /**
         * 删除数据
         * db.execSQL("delete from Book where pages > ?", new String[] { "400" });
         */
        Button deleteButton = (Button) findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book", "pages > ?", new String[] { "400" });
            }
        });

        /**
         * 查询数据
         * db.rawQuery("select * from Book", null);
         */
        Button queryButton = (Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        // 遍历并打印数据
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));

                        Log.d("MainActivity", "book name = " + name);
                        Log.d("MainActivity", "book author = " + author);
                        Log.d("MainActivity", "book pages = " + pages);
                        Log.d("MainActivity", "book price = " + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });

    }

}
