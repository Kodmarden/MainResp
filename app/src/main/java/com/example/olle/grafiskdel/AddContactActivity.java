package com.example.olle.grafiskdel;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddContactActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

    }


    public void adding() {
        Button knapp = (Button) findViewById(R.id.button4);
        knapp.setOnClickListener(new View.OnClickListener() {
            EditText namnet = (EditText) findViewById(R.id.namn);
            EditText tele = (EditText)findViewById(R.id.telefon);
            EditText mail = (EditText)findViewById(R.id.mailadress);

            @Override
            public void onClick(View v) {

                String namnet1 = namnet.getText().toString();
                String telefonnumret = tele.getText().toString();
                String mailen = mail.getText().toString();
                Contact kontakt;

                    if (namnet1.length()==0 || telefonnumret.length()==0 || mailen.length() == 0)

                    System.out.println("Invalid input");

                    else {
                        kontakt = new Contact(namnet1, telefonnumret, mailen);
                    }


                    }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.addcontactlay, menu);
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
