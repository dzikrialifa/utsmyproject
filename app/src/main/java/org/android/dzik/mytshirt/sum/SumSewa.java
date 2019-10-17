package org.android.dzik.mytshirt.sum;

public class SumSewa {

    public static final int REGULER = 0;
    public static final int SWEET = 1;
    public static final int FAMILY = 2;

    private int anak,dewasa,seat,index;

    public SumSewa(int anak, int dewasa, int seat) {
        this.anak = anak;
        this.dewasa = dewasa;
        this.seat = seat;
        this.index = hitung();
    }

    public int getIndex(){
        return index;
    }

    private int hitung(){
        switch (seat){
            case REGULER :
                return (anak * 15000) + (dewasa * 30000); // KURSI REGULER
            case SWEET :
                return (dewasa * 80000);
            case FAMILY :
                return (anak * 25000) + (dewasa * 50000);
            default:return 0;
        }
    }
}
