package com.droiduino.bluetoothconn.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.droiduino.bluetoothconn.MainActivity;
import com.droiduino.bluetoothconn.R;

public class HomeFragment extends Fragment {

    private Button btn01, btn02,btn03,btn04,btn05,btn06;
    private String btn01_stat, btn02_stat,btn03_stat,btn04_stat,btn05_stat,btn06_stat;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        MainActivity context = (MainActivity)getActivity();
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btn01 = (Button) root.findViewById(R.id.btn01);
        btn02 = (Button) root.findViewById(R.id.btn02);
        btn03 = (Button) root.findViewById(R.id.btn03);
        btn04 = (Button) root.findViewById(R.id.btn04);
        btn05 = (Button) root.findViewById(R.id.btn05);
        btn06 = (Button) root.findViewById(R.id.btn06);

        context.setCmd("18");

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = context.getBtn01_stat();
                if (temp.equals("off")){
                    context.setCmd("3N");
                    context.setBtn01_stat("on");
                }else{
                    context.setCmd("4N");
                    context.setBtn01_stat("off");
                }
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn02_stat().equals("off")){
                    context.setCmd("1N");
                    context.setBtn02_stat("on");
                }else{
                    context.setCmd("2N");
                    context.setBtn02_stat("off");
                }
            }
        });

        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn03_stat().equals("off")){
                    context.setCmd("5N");
                    context.setBtn03_stat("on");
                }else{
                    context.setCmd("6N");
                    context.setBtn03_stat("off");
                }
            }
        });

        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn04_stat().equals("off")){
                    context.setCmd("7N");
                    context.setBtn04_stat("on");
                }else{
                    context.setCmd("8N");
                    context.setBtn04_stat("off");
                }
            }
        });

        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn05_stat().equals("off")){
                    context.setCmd("9N");
                    context.setBtn05_stat("on");
                }else{
                    context.setCmd("10");
                    context.setBtn05_stat("off");
                }
            }
        });

        btn06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn06_stat().equals("off")){
                    context.setCmd("11");
                    context.setBtn06_stat("on");
                }else{
                    context.setCmd("12");
                    context.setBtn06_stat("off");
                }
            }
        });

        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}