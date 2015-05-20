package com.example.edith.ucimenu;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import java.sql;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends ActionBarActivity {

    private class ReadHTMLTask extends AsyncTask<String, String, String>
    {
        //@Override
        protected String doInBackground(String... urls)
        {
            try
            {
                Connection.Response conn = Jsoup.connect("http://uci.campusdish.com/Commerce/Catalog/Menus.aspx?LocationId=3056")
                        .execute();

                Document doc = Jsoup.connect("http://uci.campusdish.com/Commerce/Catalog/Menus.aspx?LocationId=3056").get();
                String title = doc.title();
                //Element div = doc.getElementById("menu-name");

                Elements stations = doc.select(".menu-details-station h2");
               // Elements foodItems = doc.select("#mainform .wrapper .container .content .content .maincontent #WebPartManager1_wpMenuDetails .wp-menus .menu-details .menu-details-station .menu-details-station-item .menu-name a");
                Elements foodItems = doc.select("div.menu-name > a");
                System.out.println("Station: " + stations.toString());
                System.out.println("Items: " + foodItems);
            } catch (IOException e){}

            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //Start task:
        new ReadHTMLTask().execute();

        RecyclerView restaurantList = (RecyclerView) findViewById(R.id.cardList);
        restaurantList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(linearLayout)
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);




        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


