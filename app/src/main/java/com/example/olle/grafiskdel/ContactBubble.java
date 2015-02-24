package com.example.olle.grafiskdel;

/**
 * Created by magnus on 2/24/15.
 */
public class ContactBubble {
    public static final float PaddingDistance=0.0F;
    private Contact contact;
    private float radius;
    private Pair<Float> coord;

    public Pair<Float> getCoord() {
        return coord;
    }

    public void setCoord(Pair<Float> coord) {
        this.coord = coord;
    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public ContactBubble(Contact contact,float radius,Pair<Float> coord)
    {
        this.contact=contact;
        this.radius=radius;
        this.coord=coord;

    }

    public boolean intersects(ContactBubble bubble)
    {
        return (distance(this.coord,bubble.getCoord())+ContactBubble.PaddingDistance)<(this.radius+bubble.getRadius());
    }

    //this should not be here
    private double distance(Pair<Float> c1,Pair<Float> c2)
    {
        return Math.sqrt(Math.pow(c2.x()-c1.x(),2)+Math.pow(c2.y()-c1.y(),2));
    }
}
