package org.android.dzik.mytshirt.sum;

public class SumSewa {

    public static final int MALE = 0;

    private int anak,dewasa,tiket,index;

    public SumSewa(int dewasa,int anak, int tiket) {
        this.anak = dewasa;
        this.dewasa = dewasa;
        this.index = hitungSewa();
    }
    public int getIndex(){
        return index;
    }
    private int hitungSewa(){
//        switch (gender){
//            case
//        }
        return (anak * 15000) + (dewasa * 30000);
    }
}
