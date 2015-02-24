package com.example.olle.grafiskdel;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * This class implements the interfaces OnTouchListener and OnDragListener
 * This means that the textviews and layouts can be implicitly assigned to View actions
 */
public class Home extends Activity implements View.OnTouchListener, View.OnDragListener
{

    final String LOGCAT = "debug";
    View.DragShadowBuilder shadowBuilder;
    TextView[] _textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.absoluthome);
        /**
         * This is a really nifty way of assigning View events without locking it in.
         */

        findViewById(R.id.contac1).setOnTouchListener(this);
      //  findViewById(R.id.contac2).setOnTouchListener(this);
     //   findViewById(R.id.contac3).setOnTouchListener(this);
      //  findViewById(R.id.contac4).setOnTouchListener(this);
      //  findViewById(R.id.button).setOnDragListener(this);

    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            //view.setVisibility(View.INVISIBLE);
            changeAct(view);
            return true;
        } else {
            return false;
        }
    }

    private void changeAct(View view) {

        shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(null, shadowBuilder, view, 0);

        Intent changeAct;
        changeAct = new Intent(this, touchcontact.class);
        changeAct.putExtra("name", "igor");

        startActivity(changeAct);
    }

    public boolean onDrag(View layoutview, DragEvent dragevent) {
        int action = dragevent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(LOGCAT, "Drag event started");

                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(LOGCAT, "Drag event entered into "+layoutview.toString());
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(LOGCAT, "Drag event exited from "+layoutview.toString());
                break;
            case DragEvent.ACTION_DROP:

                Log.d(LOGCAT, "Dropped");
                View view = (View) dragevent.getLocalState();

                TextView call = (TextView)findViewById(R.id.Call);
                call.setText("Bajs");
                ((View)dragevent.getLocalState()).setVisibility(View.VISIBLE);

                break;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(LOGCAT, "Drag ended");
               // ((TextView) findViewById(R.id.button)).setText("Från Main");
               // ((View)dragevent.getLocalState()).setVisibility(View.VISIBLE);

                break;
            default:
                break;
        }
        return true;
    }

    public void me(View view) {
            Intent changeAct;
        changeAct = new Intent(this, justNewAct.class);
        startActivity(changeAct);

    }

    public void startListActivity(View view)
    {
        startActivity(new Intent(this, ContactListActivity.class));
    }
}
