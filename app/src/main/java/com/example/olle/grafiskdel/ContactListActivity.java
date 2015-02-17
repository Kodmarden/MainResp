package com.example.olle.grafiskdel;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.HashSet;


public class ContactListActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    ArrayAdapter<String> mAdapter;

    static final String[] PROJECTION = new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.DATA};

    static final String SELECTION = "((" +
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " NOTNULL) AND (" +
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " != '' ) )";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        setListAdapter(mAdapter);
        getLoaderManager().initLoader(0, null, this);
    }

    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                PROJECTION, SELECTION, null, null);
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        HashSet<String> list=new HashSet<>();
        for(String s:data.getColumnNames())
        {
            System.out.println(s);
        }
        if(data!=null)
        {
            if(data.moveToFirst())
            {
                do{
                    String phone=data.getString(data.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DATA));
                    String name=data.getString(data.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    if(phone!=null&&phone.trim().matches("\\d+-*\\d+.*"))
                    {
                        Contact contact=new Contact(name,phone.trim());
                        list.add(contact.toString());
                    }
                }while(data.moveToNext());
            }
            System.out.println(list.size());
        }



        mAdapter.addAll(list);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.clear();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }
}
