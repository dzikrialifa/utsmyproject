package org.android.dzik.mytshirt.sum;

public class SumSewa {

    public static final int REGULER = 0;
    public static final int SWEET = 1;
    public static final int FAMILY = 2;

    private int anak,dewasa,tipeduduk,index;

    public SumSewa(int dewasa,int anak, int tipeduduk) {
        this.anak = dewasa;
        this.dewasa = dewasa;
        this.tipeduduk = tipeduduk;
        this.index = hitungSewa();
    }
    public int getIndex(){
        return index;
    }
    private int hitungSewa(){
        switch (tipeduduk){
            case REGULER :
                return (anak * 15000) + (dewasa * 30000); // KURSI REGULER
            case SWEET :
                return (dewasa * 80000) + 20000;
            case FAMILY :
                return (anak * 25000) + (dewasa * 50000);
            default:return 0;
        }
    }
}
