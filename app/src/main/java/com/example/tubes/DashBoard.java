package com.example.tubes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tubes.fragment.FragmentHome;
import com.example.tubes.fragment.FragmentNote;
import com.example.tubes.fragment.FragmentProfile;
import com.example.tubes.fragment.FragmentQuiz;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashBoard extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNav;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setBackground(null);
        bottomNav.getMenu().getItem(2).setEnabled(false);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(DashBoard.this, ChatBot.class);
                startActivity(detail);
            }
        });

        loadFragment(new FragmentHome());
// beri listener pada saat item/menu bottomnavigation terpilih
        bottomNav.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home:
                fragment = new FragmentHome();
                break;
            case R.id.note:
                fragment = new FragmentNote();
                break;
            case R.id.quiz:
                fragment = new FragmentQuiz();
                break;
            case R.id.profile:
                fragment = new FragmentProfile();
                break;
        }
        return loadFragment(fragment);
    }
}
