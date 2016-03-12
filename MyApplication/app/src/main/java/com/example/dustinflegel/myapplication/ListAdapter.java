package com.example.dustinflegel.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dustinflegel on 3/12/16.
 */
public class ListAdapter extends BaseAdapter {

    // Specify an array list to store
    // the contents you want to display
    public ArrayList<String> list;

    // Create a reference to the calling
    // activity.
    Activity activity;

    public ListAdapter(Activity activity, ArrayList<String> list)
    {
        super();    // Call Super to finish out the initialization.
        this.activity = activity;   // Assign the passed activity to the local activity object.
        this.list = list;           // Assign the passed list object to the local list object.
    }

    @Override
    public int getCount() {
        return list.size(); // Return the size of the list.
    }

    @Override
    public Object getItem(int position) {

        return list.get(position); // Return the item from the list at the specified position.

    }

    @Override
    public long getItemId(int position) {
        return 0;  // Not required unless otherwise specified.  I would use a key / value pair for this.
    }

    /*
        Note: this part of the class is VERY important to get correct, because this is the part that
        will actually inflate the text field we're using as a list item,
        and it will also get the text that should go into this list item.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // It's time to inflate our view.  Let's do that with the following steps:

        // 1. Specify an instance of the ViewHolder class (from below...)
        ViewHolder holder;

        // 2. Specify our layout inflater by getting it from the activity
        //    we passed in earlier.
        LayoutInflater inflater = activity.getLayoutInflater();

        // 3. Check if convertView was specified in this method call.  Initially
        //    this value is going to be null, so we'll have to inflate our objects
        if (convertView == null)
        {
            // 4. inflate an instance of our single_column_list, which is specified
            //    in the single_column_list.xml file found in the res > layout group
            //    in our project.
            convertView = inflater.inflate(R.layout.single_column_list, null);

            // 5. Create a new instance of the ViewHolder class specified below.
            //    because we're going to need to reference our TextView for the
            //    row being created.
            holder = new ViewHolder();

            // 6. Now, we're going to assign the singleColumnText object found in
            //    single_column_list.xml to the local class variable for reference
            //    later.
            holder.listTextField = (TextView)convertView.findViewById(R.id.singleColumnText);

            // 7. We will now go ahead and set the "tag" of our "holder" class object
            //    in case we need to recall it later.
            convertView.setTag(holder);
        } else {
            // 8. Since convertView wasn't null this time around
            //    we'll assign the object we stored in the "tag" of
            //    convertView to the object 'holder', since we don't
            //    have to re-inflate it or reinstantiate it.
            holder = (ViewHolder) convertView.getTag();
        }

        // 9.   This is where we assign text to the list object.
        //      let's get the string value stored in our list
        //      and set the text property of the textField
        //      in the object "holder"
        String listObjectValue = list.get(position);

        // 10.  Assign the String value to the textField.
        holder.listTextField.setText(listObjectValue);

        // 11. Finally, we'll return the either newly instantiated convertView object
        //     or our reused convertView
        return convertView;
    }

    // Create a view holder subclass.
    private class ViewHolder {
        TextView listTextField;     // Since our list view item is just a textview.  We'll specify that
                                    // here.
    }
}
