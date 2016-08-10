package com.example.a0180600.listviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a0180600 on 16-7-18.
 */
public class MainActivity extends Activity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruits() {
        Fruit apple = new Fruit("apple", R.drawable.apple);
        fruitList.add(apple);
        Fruit banana = new Fruit("banana", R.drawable.banana);
        fruitList.add(banana);
        Fruit cherry = new Fruit("cherry", R.drawable.cherry);
        fruitList.add(cherry);
        Fruit grape = new Fruit("grape", R.drawable.grape);
        fruitList.add(grape);
        Fruit orange = new Fruit("orange", R.drawable.orange);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("watermelon", R.drawable.watermelon);
        fruitList.add(watermelon);

    }

}
