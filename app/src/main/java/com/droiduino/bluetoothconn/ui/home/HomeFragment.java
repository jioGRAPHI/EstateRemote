package com.droiduino.bluetoothconn.ui.home;

import android.app.Activity;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment {

    private Button btn01, btn02,btn03,btn04,btn05,btn06, btn07, btn08, btn09, btn10, btn11, btn12, btn13;
    private String btn01_stat, btn02_stat,btn03_stat,btn04_stat,btn05_stat,btn06_stat, btn07_stat, btn08_stat, btn09_stat;

    private List<String> bldg_view_arrlist = new ArrayList<String>();
    private String[] bldg_view_arr;

    private String bldg_view = "";

    private MainActivity a;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        MainActivity context = (MainActivity)getActivity();
        a = context;
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
        btn10 = (Button) root.findViewById(R.id.btn10);
        btn11 = (Button) root.findViewById(R.id.btn11);
        btn12 = (Button) root.findViewById(R.id.btn12);
        btn13 = (Button) root.findViewById(R.id.btn13);

        //context.setCmd("18");

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = context.getBtn01_stat();
                if (context.getBtn01_stat().equals("off")){
                    context.setCmd("3N");
                    offButtons(context);
                    context.setBtn01_stat("on");
                    btn01.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("4N");
                    offButtons(context);
                    context.setBtn01_stat("off");
                    btn01.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn02_stat().equals("off")){
                    context.setCmd("1N");
                    offButtons(context);
                    context.setBtn02_stat("on");;
                    btn02.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("2N");
                    offButtons(context);
                    context.setBtn02_stat("off");
                    btn02.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn03_stat().equals("off")){
                    context.setCmd("5N");
                    offButtons(context);
                    context.setBtn03_stat("on");
                    btn03.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("6N");
                    offButtons(context);
                    context.setBtn03_stat("off");
                    btn03.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn04_stat().equals("off")){
                    context.setCmd("7N");
                    offButtons(context);
                    context.setBtn04_stat("on");
                    btn04.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("8N");
                    offButtons(context);
                    context.setBtn04_stat("off");
                    btn04.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn05_stat().equals("off")){
                    context.setCmd("9N");
                    offButtons(context);
                    context.setBtn05_stat("on");
                    btn05.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("10");
                    offButtons(context);
                    context.setBtn05_stat("off");
                    btn05.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn06_stat().equals("off")){
                    context.setCmd("11");
                    offButtons(context);
                    context.setBtn06_stat("on");
                    btn06.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("12");
                    offButtons(context);
                    context.setBtn06_stat("off");
                    btn06.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn07_stat().equals("off")){
                    context.setCmd("13");
                    offButtons(context);
                    context.setBtn07_stat("on");
                    btn07.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("14");
                    offButtons(context);
                    context.setBtn07_stat("off");
                    btn07.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn08_stat().equals("off")){
                    context.setCmd("15");
                    offButtons(context);
                    context.setBtn08_stat("on");
                    btn08.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("16");
                    offButtons(context);
                    context.setBtn08_stat("off");
                    btn08.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn09_stat().equals("off")){
                    context.setCmd("17");
                    offButtons(context);
                    context.setBtn09_stat("on");
                    btn09.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("18");
                    offButtons(context);
                    context.setBtn09_stat("off");
                    btn09.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn10_stat().equals("off")){
                    context.setCmd("20");
                    offButtons(context);
                    context.setBtn10_stat("on");
                    btn10.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("21");
                    offButtons(context);
                    context.setBtn10_stat("off");
                    btn10.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn11_stat().equals("off")){
                    context.setCmd("22");
                    offButtons(context);
                    context.setBtn11_stat("on");
                    btn11.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("23");
                    offButtons(context);
                    context.setBtn11_stat("off");
                    btn11.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn12_stat().equals("off")){
                    context.setCmd("24");
                    offButtons(context);
                    context.setBtn12_stat("on");
                    btn12.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("25");
                    offButtons(context);
                    context.setBtn12_stat("off");
                    btn12.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn13_stat().equals("off")){
                    context.setCmd("26");
                    offButtons(context);
                    context.setBtn13_stat("on");
                    btn13.setBackgroundResource(R.drawable.btn_layout2);
                }else{
                    context.setCmd("27");
                    offButtons(context);
                    context.setBtn13_stat("off");
                    btn13.setBackgroundResource(R.drawable.btn_layout);
                }
                changeImg(root, context);
            }
        });



        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/

        return root;
    }

    public void offButtons(MainActivity context){
        context.setBtn01_stat("off");
        context.setBtn02_stat("off");
        context.setBtn03_stat("off");
        context.setBtn04_stat("off");
        context.setBtn05_stat("off");
        context.setBtn06_stat("off");
        context.setBtn07_stat("off");
        context.setBtn08_stat("off");
        context.setBtn09_stat("off");
        context.setBtn10_stat("off");
        context.setBtn11_stat("off");
        context.setBtn12_stat("off");
        context.setBtn13_stat("off");
        btn01.setBackgroundResource(R.drawable.btn_layout);
        btn02.setBackgroundResource(R.drawable.btn_layout);
        btn03.setBackgroundResource(R.drawable.btn_layout);
        btn04.setBackgroundResource(R.drawable.btn_layout);
        btn05.setBackgroundResource(R.drawable.btn_layout);
        btn06.setBackgroundResource(R.drawable.btn_layout);
        btn07.setBackgroundResource(R.drawable.btn_layout);
        btn08.setBackgroundResource(R.drawable.btn_layout);
        btn09.setBackgroundResource(R.drawable.btn_layout);
        btn10.setBackgroundResource(R.drawable.btn_layout);
        btn11.setBackgroundResource(R.drawable.btn_layout);
        btn12.setBackgroundResource(R.drawable.btn_layout);
        btn13.setBackgroundResource(R.drawable.btn_layout);
    }

    public void changeImg(View root, MainActivity context){
        bldg_view_arrlist.clear();
        if(context.getBtn05_stat().equals("off")){
            if(context.getBtn01_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("2");
            }
            else if(context.getBtn02_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("1");
            }
            else if(context.getBtn03_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("3");
            }
            else if(context.getBtn04_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("4");
            }
            else if(context.getBtn06_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("6");
            }

            else if(context.getBtn07_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("7");
            }
            else if(context.getBtn08_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("8");
            }
            else if(context.getBtn10_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("10");
            }
            else if(context.getBtn11_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("right");
            }
            else if(context.getBtn12_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("10");
            }
            else if(context.getBtn13_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("left");
            }
            List<String> sublist = bldg_view_arrlist.subList(0, bldg_view_arrlist.size());
            Collections.sort(sublist);
            if (sublist != null){
                bldg_view = "a";
                for (String x:sublist) {
                    bldg_view = bldg_view + x;
                }
            }else{
                bldg_view = "a";
            }

        }else{
            bldg_view = "a123456";
        }


        ((ImageView) root.findViewById(R.id.bldg_img)).setImageResource(getResources().getIdentifier("com.droiduino.bluetoothconn:drawable/"+bldg_view, null, null));

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}