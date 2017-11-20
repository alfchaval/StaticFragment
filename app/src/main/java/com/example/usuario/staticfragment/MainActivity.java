package com.example.usuario.staticfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentA.FragmentAListener {

    private Fragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentB = getFragmentManager().findFragmentById(R.id.fragmentB);
    }

    @Override
    public void onFragmentAEvent(String message, int size) {
        ((FragmentB) fragmentB).changeTextAndSize(message, size);
    }
}
