package org.android.dzik.mytshirt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.android.dzik.mytshirt.fragments.HasilFragment;
import org.android.dzik.mytshirt.fragments.HomeFragment;
import org.android.dzik.mytshirt.fragments.TicketIndexFragment;
import org.android.dzik.mytshirt.sum.SumSewa;

public class MainActivity extends AppCompatActivity implements
        TicketIndexFragment.OnFragmentInteractionListener,
        HasilFragment.OnFragmentInteractionListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    // Deklarasikan atribut Fragment di sini
    private SumSewa sumSewa;
    private HasilFragment hasilFragment;
    private TicketIndexFragment ticketIndexFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ticketIndexFragment = new TicketIndexFragment();
        hasilFragment = new HasilFragment();
        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;

        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_home:
                fragment = new HomeFragment();
                break;
            case R.id.action_film:
                fragment = new HasilFragment();
                break;
            case R.id.action_akun:
                fragment = new TicketIndexFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onCalculateTiket(int index) {
        hasilFragment.setInformasi(String.format(" "+index));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,hasilFragment).commit();
    }

    @Override
    public void onTryAgain(String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ticketIndexFragment)
                .commit();
    }
}
