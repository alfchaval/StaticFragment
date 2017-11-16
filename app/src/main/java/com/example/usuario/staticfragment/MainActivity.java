package com.example.usuario.staticfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener {

    private Fragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentB = getSupportFragmentManager().findFragmentById(R.id.fragmentB);
    }

    @Override
    public void onFragmentAEvent(String message, int size) {
        ((FragmentB) fragmentB).changeTextAndSize(message, size);
    }
}
