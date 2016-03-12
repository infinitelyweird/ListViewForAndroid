package com.example.dustinflegel.myapplication;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // The first step to populating a list item
    // is to create an object to store data that
    // will be use for each row in the list.
    private ArrayList<String> listViewItems;

    // Next, we'll want to create a reference to
    // our List Adapter.  We'll pass our current
    // activity as 'this' and the object we just
    // created to store our items called 'listViewItems'
    private ListAdapter listAdapter = new ListAdapter(this, listViewItems);

    // We want this available throughout this class
    // so we'll declare our myBasicListView object
    // here.
    private ListView myBasicListView;

    /*
        This method is where we're going to initialize our listView
        You'll find the ListView object under layout > content_main.xml.
        The list view's name is myBasicListView
        Note that the ListView is not setup to be anything fancy.  This
        is just a simple demonstration of how to populate a list view,
        and I'll expand on it in another project later.

        BEFORE YOU ADD THIS CODE, MAKE SURE YOU HAVE A ListAdapter created
        AND A LAYOUT FOR YOUR ROW.

        (see ListAdapter class and single_column_list.xml)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // For the sake of this demo, we don't care about this.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // For the sake of this demo, we don't care about this, either.
        setSupportActionBar(toolbar);

        // For our first trick, we'll initialize
        // the ArrayList we declared above so we
        // can add data to it.
        listViewItems = new ArrayList<String>();

        // Now, we'll put some simple dummy data into our ArrayList
        // to populate our ListView.  If you don't know how for loops
        // work, then I think you're at a stopping point where you need
        // to read up on basic Java language syntax.
        for (int i = 0; i < 5; i++) // Let's create 5 numbered items to put in our list.
        {                           // If you want to see the list scroll, then make the number
                                    // something like 150, just for grins.
            listViewItems.add("Item Index #" + i);
        }

        // Now that we've got 5 records to display, let's take our ArrayList
        // and assign it to the adapter class that we prepared an ArrayList for.
        listAdapter.list = listViewItems;

        // Let's find our myBasicListView item and set the variable we declared above
        // so we can populate the data later.
        myBasicListView = (ListView)findViewById(R.id.myBasicListView);

        // Next, we'll assign our ListAdapter class ('listAdapter') to
        // our myBasicListView adapter property.
        myBasicListView.setAdapter(listAdapter);

        // Now, how do we handle 'touch' events, you say?  Well, surprisingly
        // it's not a touch event, but it's an OnItemClick event.
        // You don't have to memorize this code, but you should note a quick
        // shortcut where you can type new OnClickLi and then pressing Tab on your keyboard
        // should generate the @Override event.
        myBasicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // So, how do we know what the data is on the item we just "clicked"?  We'll
                // take the "position" variable, and find the item in our ArrayList.

                // To keep things simple, I'm just going to print the value out to the
                // debug window.
                System.out.println(listViewItems.get(position));

                // THE BELOW LINE IS OPTIONAL AND JUST FOR FUN!
                // For fun, we'll use Snackbar to display a message at the bottom
                // of the screen with the item you selected.
                Snackbar.make(view, listViewItems.get(position), Snackbar.LENGTH_SHORT).show();
            }
        });

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
