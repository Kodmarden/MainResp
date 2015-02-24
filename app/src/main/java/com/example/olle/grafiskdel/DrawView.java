package com.example.olle.grafiskdel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.util.ArrayList;

/**
 * Created by magnus on 1/29/15.
 */
public class DrawView extends View implements OnTouchListener {

    float x=0;
    float y=0 ;
    private ArrayList<ContactBubble> bubbles=new ArrayList<>();
    private ArrayList<Contact> contacts=new ArrayList<>();
    public DrawView(Context context) {
        super(context);
        this.setOnTouchListener(this);
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        if(x==0&&y==0) {
            x = canvas.getWidth() / 2;
            y = canvas.getHeight() / 2;
            initContacts();
            createBubbles();
        }
        for(ContactBubble bubble:bubbles)
        {
            drawContactBubble(canvas,bubble);
        }

    }

    public void initContacts()
    {
        contacts.add(new Contact("derp","derp","derp"));
        contacts.add(new Contact("derp1","derp1","derp1"));
        contacts.add(new Contact("derp2","derp2","derp2"));
        contacts.add(new Contact("derp","derp","derp"));
        contacts.add(new Contact("derp1","derp1","derp1"));
        contacts.add(new Contact("derp2","derp2","derp2"));
        contacts.add(new Contact("derp","derp","derp"));
        contacts.add(new Contact("derp1","derp1","derp1"));
        contacts.add(new Contact("derp2","derp2","derp2"));
        contacts.add(new Contact("derp","derp","derp"));


    }
    //this should be somewhere else I believe
    public void createBubbles()
    {
        double angleInc=2*Math.PI/contacts.size();
        double ringRadius=500;
        double angle=0;
        for(Contact contact:contacts)
        {
            ContactBubble cb = new ContactBubble(contact,100,new Pair<>
                    ((float)(x+(ringRadius*Math.cos(angle))),(float)(y+(ringRadius*Math.sin(angle)))));
            bubbles.add(cb);
            angle+=angleInc;
            System.out.println("added bubble at: x: "+cb.getCoord().x()+ " y: "+cb.getCoord().y());
        }
    }

    public void drawContactBubble(Canvas canvas,ContactBubble bubble)
    {
        Pair<Float> coord=bubble.getCoord();
        Paint paint=new Paint();
        paint.setColor(Color.parseColor("#FF0000"));
        paint.setStrokeWidth(10);
        canvas.drawCircle(coord.x(),coord.y(),bubble.getRadius(),paint);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(Math.abs(x-event.getX())<100 && Math.abs(y-event.getY())<100)
        {
           // x= (int)event.getX();
            //y= (int)event.getY();
            invalidate();
        }
//        System.out.println(event.getX());
//        System.out.println(event.getY());

        return true;
    }
}