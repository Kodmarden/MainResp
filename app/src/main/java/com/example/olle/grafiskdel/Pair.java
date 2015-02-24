package com.example.olle.grafiskdel;

/**
 * Created by magnus on 2/24/15.
 */
public class Pair <T>{
    private T fst;
    private T snd;
    public Pair(T fst,T snd)
    {
        this.fst=fst;
        this.snd=snd;
    }

    public T fst()
    {
        return this.fst;
    }
    public T snd()
    {
        return this.snd;
    }

    public T x()
    {
        return this.fst;
    }

    public T y()
    {
        return this.snd;
    }
}
