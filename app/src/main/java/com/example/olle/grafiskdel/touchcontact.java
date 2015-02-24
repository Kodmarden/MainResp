package com.example.olle.grafiskdel;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class touchcontact extends ActionBarActivity implements View.OnTouchListener, View.OnDragListener {

    final String LOGCAT = "debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchcontact);
        /**
         * This is a really nifty way of assigning View events without locking it in.
         */
        findViewById(R.id.testAct).setOnTouchListener(this);
        findViewById(R.id.Call).setOnDragListener(this);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder2 = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder2, view, 0);
           // view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }


    public boolean onDrag(View layoutview, DragEvent dragevent) {
        int action = dragevent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                  Log.d(LOGCAT, "Drag event started");
                System.out.println("Stoff");
                //  setVisibility(View.VISIBLE);

                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                System.out.println("Stoff");
                Log.d(LOGCAT, "Drag event entered into "+layoutview.toString());
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                System.out.println("Stoff");
                Log.d(LOGCAT, "Drag event exited from "+layoutview.toString());
                break;
            case DragEvent.ACTION_DROP:
                System.out.println("Stoff");
                Log.d(LOGCAT, "Dropped");
                View view = (View) dragevent.getLocalState();


                TextView call = (TextView)findViewById(R.id.Call);

                String value ="#";
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    value = extras.getString("name");
                }

              //  findViewById(R.id.touchcontact).setBackgroundColor(Color.BLACK);
                ((TextView) findViewById(R.id.Call)).setText(value);
                ((View)dragevent.getLocalState()).setVisibility(View.VISIBLE);

                break;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(LOGCAT, "Drag ended");
                System.out.println("Stoff");
                break;
            default:
                break;
        }
        return true;
    }

}
