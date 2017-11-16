package com.example.usuario.staticfragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by usuario on 11/16/17.
 */

public class FragmentA extends Fragment {

    private FragmentAListener mCallBack;
    private EditText edtMessage;
    private Button btnCambiarTamanho;
    private SeekBar sbTamanho;

    // Se define la interfaz que servirá de contrato entre el Fragment y la Activity

    public interface FragmentAListener {
        void onFragmentAEvent(String message, int size);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d("onAttach","onAttach");
        super.onAttach(activity);
        try {
            mCallBack = (FragmentAListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement FragmentAListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("onCreate","onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("onCreateView","onCreateView");
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        edtMessage = view.findViewById(R.id.edtMessage);
        btnCambiarTamanho = view.findViewById(R.id.btnCambiarTamanho);
        sbTamanho = view.findViewById(R.id.sbTamanho);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d("onViewCreated","onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        btnCambiarTamanho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.onFragmentAEvent(edtMessage.getText().toString(), sbTamanho.getProgress());
            }
        }
        );
    }

    @Override
    public void onStart() {
        Log.d("onStart","onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("onResume","onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("onPause","onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("onStop","onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("onDestroyView","onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("onDestroy","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("onDetach","onDetach");
        mCallBack = null;
        super.onDetach();
    }

    /**
     * Este método solo funciona desde la API 23 en adelante. Si se ejecuta en una API anterior
     * no da error pero no funciona la comunicación entre el activity y el fragment
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


}
