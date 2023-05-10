package com.droiduino.bluetoothconn.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.droiduino.bluetoothconn.MainActivity;
import com.droiduino.bluetoothconn.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private Button btn01, btn02,btn03,btn04,btn05,btn06, btn07, btn08, btn09;
    private String btn01_stat, btn02_stat,btn03_stat,btn04_stat,btn05_stat,btn06_stat, btn07_stat, btn08_stat, btn09_stat;

    private List<String> bldg_view_arrlist = new ArrayList<String>();
    private String[] bldg_view_arr;

    private String bldg_view = "";

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
        btn07 = (Button) root.findViewById(R.id.btn07);
        btn08 = (Button) root.findViewById(R.id.btn08);
        btn09 = (Button) root.findViewById(R.id.btn09);

        //context.setCmd("18");

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = context.getBtn01_stat();
                if (context.getBtn01_stat().equals("off")){
                    context.setCmd("3N");
                    context.setBtn01_stat("on");
                    btn01.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("4N");
                    context.setBtn01_stat("off");
                    btn01.setBackgroundResource(R.drawable.btn_layout);
                }
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn02_stat().equals("off")){
                    context.setCmd("1N");
                    context.setBtn02_stat("on");
                    btn02.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("2N");
                    context.setBtn02_stat("off");
                    btn02.setBackgroundResource(R.drawable.btn_layout);
                }
            }
        });

        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn03_stat().equals("off")){
                    context.setCmd("5N");
                    context.setBtn03_stat("on");
                    btn03.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("6N");
                    context.setBtn03_stat("off");
                    btn03.setBackgroundResource(R.drawable.btn_layout);
                }
            }
        });

        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn04_stat().equals("off")){
                    context.setCmd("7N");
                    context.setBtn04_stat("on");
                    btn04.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("8N");
                    context.setBtn04_stat("off");
                    btn04.setBackgroundResource(R.drawable.btn_layout);
                }
            }
        });

        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn05_stat().equals("off")){
                    context.setCmd("9N");
                    context.setBtn05_stat("on");
                    btn05.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("10");
                    context.setBtn05_stat("off");
                    btn05.setBackgroundResource(R.drawable.btn_layout);
                }
            }
        });

        btn06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn06_stat().equals("off")){
                    context.setCmd("11");
                    context.setBtn06_stat("on");
                    btn06.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("12");
                    context.setBtn06_stat("off");
                    btn06.setBackgroundResource(R.drawable.btn_layout);
                }
            }
        });

        btn07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn07_stat().equals("off")){
                    context.setCmd("13");
                    context.setBtn07_stat("on");
                    btn07.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("14");
                    context.setBtn07_stat("off");
                    btn07.setBackgroundResource(R.drawable.btn_layout);
                }
            }
        });

        btn08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn08_stat().equals("off")){
                    context.setCmd("15");
                    context.setBtn08_stat("on");
                    btn08.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("16");
                    context.setBtn08_stat("off");
                    btn08.setBackgroundResource(R.drawable.btn_layout);
                }
            }
        });

        btn09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn09_stat().equals("off")){
                    context.setCmd("17");
                    context.setBtn09_stat("on");
                    btn09.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("18");
                    context.setBtn09_stat("off");
                    btn09.setBackgroundResource(R.drawable.btn_layout);
                }
            }
        });

        if(context.getBtn05_stat().equals("off")){
            if(context.getBtn01_stat().equals("on")){
                bldg_view_arrlist.add("1");
            }
            if(context.getBtn02_stat().equals("on")){
                bldg_view_arrlist.add("2");
            }
            if(context.getBtn03_stat().equals("on")){
                bldg_view_arrlist.add("3");
            }
            if(context.getBtn04_stat().equals("on")){
                bldg_view_arrlist.add("4");
            }
            if(context.getBtn06_stat().equals("on")){
                bldg_view_arrlist.add("6");
            }
            bldg_view_arr = bldg_view_arrlist.toArray(bldg_view_arr);
            Arrays.sort(bldg_view_arr);

            bldg_view = "a";
            for(int i = 0; i < bldg_view_arr.length; i++){
                bldg_view = bldg_view + bldg_view_arr[i];
            }
        }else{
            bldg_view = "a123456";
        }


        ((ImageView) root.findViewById(R.id.bldg_img)).setImageResource(getResources().getIdentifier("com.droiduino.bluetoothconn:drawable/"+bldg_view, null, null));


        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}