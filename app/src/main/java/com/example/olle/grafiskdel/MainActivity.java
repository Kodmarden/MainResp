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
public class MainActivity extends Activity implements View.OnTouchListener, View.OnDragListener
{

    final String LOGCAT = "debug";
    View.DragShadowBuilder shadowBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * This is a really nifty way of assigning View events without locking it in.
         */
        findViewById(R.id.button3).setOnTouchListener(this);
        findViewById(R.id.button).setOnDragListener(this);

    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//            setContentView(R.layout.activity_touchcontact);
//            View dasView=findViewById(R.id.touchcontact);
            //shadowBuilder = new View.DragShadowBuilder(dasView);
            //dasView.startDrag(null, shadowBuilder, dasView, 0);
//            shadowBuilder= new View.DragShadowBuilder(view);
//            dasView.startDrag(null,shadowBuilder,view,0);
//            dasView.findViewById(R.id.Call).setOnDragListener(this);
            Intent intent=new Intent(this,touchcontact.class);

            startActivity(new Intent(this,touchcontact.class));
            return true;
        } else {
            return false;
        }
    }

    private void changeAct(View view) {

        Intent changeAct;
        changeAct = new Intent(this, touchcontact.class);
        changeAct.putExtra("name", "igor");
        startActivity(changeAct);
    }

    public boolean onDrag(View layoutview, DragEvent dragevent) {
        int action = dragevent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                System.out.println("Action dragstarteted");
                System.out.println(layoutview.getId());
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                System.out.println("Action drag entered");
                System.out.println(layoutview.getId());
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                System.out.println("Action dragexited");
                System.out.println(layoutview.getId());
                break;
            case DragEvent.ACTION_DROP:
                System.out.println("Action drop");
                System.out.println(layoutview.getId());
                if(layoutview instanceof TextView) {
                    ((TextView) layoutview).setText("Derp");
                    setContentView(R.layout.activity_main);
                }
              //  View view = (View) dragevent.getLocalState();
                //  layoutview.setBackgroundColor(Color.BLACK);
                //((ViewGroup)layoutview).getChildAt(0).setBackgroundColor(Color.BLACK);
                //layoutview.get
                // ViewGroup owner = (ViewGroup) view.getParent();
                // owner.setBackgroundColor(Color.BLACK);
                //   owner.removeView(view);
                //    LinearLayout container = (LinearLayout) layoutview;
                //   container.addView(view);
                //   view.setVisibility(View.VISIBLE);
                //   setVisibility(View.INVISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(LOGCAT, "Drag ended");
                System.out.println(layoutview.getId());
                break;
            default:
                System.out.println("Default case");
                System.out.println(layoutview.getId());
                break;
        }
        return true;
    }

    public void me(View view) {
            Intent changeAct;
        changeAct = new Intent(this, meActivity.class);
        startActivity(changeAct);

    }

    public void startListActivity(View view)
    {
        startActivity(new Intent(this, ContactListActivity.class));
    }

    public void startDrawView(View view)
    {
        setContentView(new DrawView(this.getBaseContext()));
    }
}
