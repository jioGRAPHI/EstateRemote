package com.droiduino.bluetoothconn.ui.home;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.droiduino.bluetoothconn.DATA_ADAPTER;
import com.droiduino.bluetoothconn.MainActivity;
import com.droiduino.bluetoothconn.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment {

    private Button btn01, btn02,btn03,btn04,btn05,btn06, btn07, btn08, btn09, btn10, btn11, btn12, btn13;

    private List<String> bldg_view_arrlist = new ArrayList<String>();
    private String[] bldg_view_arr;

    private String bldg_view = "";

    private MainActivity a;

    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        MainActivity context = (MainActivity)getActivity();
        a = context;
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView rv = (RecyclerView) root.findViewById(R.id.recycler_view);

        List<List<String>> btn_list = new ArrayList<>();

        List<String> btn_list_subset = new ArrayList<>();
        btn_list_subset.add("All");
        btn_list_subset.add("Random");
        btn_list_subset.add("Landscape");
        btn_list_subset.add("Lobby");
        btn_list_subset.add("Second Floor");
        btn_list_subset.add("Typical Floor");
        btn_list_subset.add("Amenity");
        btn_list_subset.add("Amenity (Penthouse)");
        btn_list_subset.add("Ayala Side");
        btn_list_subset.add("Ritz Side");
        btn_list_subset.add("Urdaneta Side");
        btn_list_subset.add("Discovery Primea Side");
        btn_list.add(btn_list_subset);

        btn_list_subset = new ArrayList<>();
        btn_list_subset.add("Garden");
        btn_list_subset.add("Play Area");
        btn_list_subset.add("Wine Tasting");
        btn_list_subset.add("Outdoor Lounge");
        btn_list_subset.add("Wine Cellar");
        btn_list_subset.add("Business Centre");
        btn_list_subset.add("Fitness Centre");
        btn_list_subset.add("Atrium Lounge");
        btn_list_subset.add("Pavillion Lounge");
        btn_list_subset.add("Arrival Lounge");
        btn_list_subset.add("Piano Lounge");
        btn_list_subset.add("Pool Deck");
        btn_list.add(btn_list_subset);


        DATA_ADAPTER.ButtonListAdapter _Adapter = new DATA_ADAPTER.ButtonListAdapter(a, btn_list, this);
        rv.setAdapter(_Adapter);

        LinearLayoutManager llm = new LinearLayoutManager(a);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        llm.scrollToPositionWithOffset(0, rv.getWidth()/2);
        rv.setLayoutManager(llm);

        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(rv);

        /*btn01 = ((Button) rv.findViewById(R.id.btn01));
        btn02 = ((Button) rv.findViewById(R.id.btn02));
        btn03 = ((Button) rv.findViewById(R.id.btn03));
        btn04 = ((Button) rv.findViewById(R.id.btn04));
        btn05 = ((Button) rv.findViewById(R.id.btn05));
        btn06 = ((Button) rv.findViewById(R.id.btn06));
        btn07 = ((Button) rv.findViewById(R.id.btn07));
        btn08 = ((Button) rv.findViewById(R.id.btn08));
        btn09 = ((Button) rv.findViewById(R.id.btn09));
        btn10 = ((Button) rv.findViewById(R.id.btn10));
        btn11 = ((Button) rv.findViewById(R.id.btn11));
        btn12 = ((Button) rv.findViewById(R.id.btn12));

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn01.getText().toString(), btn01);
                changeImg(root, context);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn02.getText().toString(), btn02);
                changeImg(root, context);
            }
        });

        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn03.getText().toString(), btn03);
                changeImg(root, context);
            }
        });

        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn04.getText().toString(), btn04);
                changeImg(root, context);
            }
        });

        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn05.getText().toString(), btn05);
                changeImg(root, context);
            }
        });

        btn06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn06.getText().toString(), btn06);
                changeImg(root, context);
            }
        });

        btn07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn07.getText().toString(), btn07);
                changeImg(root, context);
            }
        });

        btn08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn08.getText().toString(), btn08);
                changeImg(root, context);
            }
        });

        btn09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn09.getText().toString(), btn09);
                changeImg(root, context);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn10.getText().toString(), btn10);
                changeImg(root, context);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn11.getText().toString(), btn11);
                changeImg(root, context);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_commands(btn12.getText().toString(), btn12);
                changeImg(root, context);
            }
        });*/


        return root;
    }

    public void btn_commands(String btn_text, Button btn){
        switch(btn_text) {
            case "Second Floor":
                if (a.getSecondFloor_stat().equals("off")){
                    a.setCmd("3N");
                    offButtons(a);
                    a.setSecondFloor_stat("on");
                }else{
                    a.setCmd("4N");
                    offButtons(a);
                    a.setSecondFloor_stat("off");
                }
                break;
            case "Lobby":
                if (a.getLobby_stat().equals("off")){
                    a.setCmd("1N");
                    offButtons(a);
                    a.setLobby_stat("on");
                }else{
                    a.setCmd("2N");
                    offButtons(a);
                    a.setLobby_stat("off");
                }
                break;
            case "Amenity":
                if (a.getAmenity_stat().equals("off")){
                    a.setCmd("5N");
                    offButtons(a);
                    a.setAmenity_stat("on");
                }else{
                    a.setCmd("6N");
                    offButtons(a);
                    a.setAmenity_stat("off");
                }
                break;
            case "Amenity (Penthouse)":
                if (a.getAmenityPenthouse_stat().equals("off")){
                    a.setCmd("7N");
                    offButtons(a);
                    a.setAmenityPenthouse_stat("on");
                }else{
                    a.setCmd("8N");
                    offButtons(a);
                    a.setAmenityPenthouse_stat("off");
                }
                break;
            case "All":
                if (a.getAll_stat().equals("off")){
                    a.setCmd("9N");
                    offButtons(a);
                    a.setAll_stat("on");
                }else{
                    a.setCmd("10");
                    offButtons(a);
                    a.setAll_stat("off");
                }
                break;
            case "Typical Floor":
                if (a.getTypicalFloor_stat().equals("off")){
                    a.setCmd("11");
                    offButtons(a);
                    a.setTypicalFloor_stat("on");
                }else{
                    a.setCmd("12");
                    offButtons(a);
                    a.setTypicalFloor_stat("off");
                }
                break;
            case "Landscape":
                if (a.getLandscape_stat().equals("off")){
                    a.setCmd("13");
                    offButtons(a);
                    a.setLandscape_stat("on");
                }else{
                    a.setCmd("14");
                    offButtons(a);
                    a.setLandscape_stat("off");
                }
                break;
            case "Street":
                if (a.getStreet_stat().equals("off")){
                    a.setCmd("15");
                    offButtons(a);
                    a.setStreet_stat("on");
                }else{
                    a.setCmd("16");
                    offButtons(a);
                    a.setStreet_stat("off");
                }
                break;
            case "Random":
                if (a.getRandom_stat().equals("off")){
                    a.setCmd("17");
                    offButtons(a);
                    a.setRandom_stat("on");
                }else{
                    a.setCmd("18");
                    offButtons(a);
                    a.setRandom_stat("off");
                }
                break;
            case "Ayala Side":
                if (a.getAyalaSide_stat().equals("off")){
                    a.setCmd("19");
                    offButtons(a);
                    a.setAyalaSide_stat("on");
                }else{
                    a.setCmd("20");
                    offButtons(a);
                    a.setAyalaSide_stat("off");
                }
                break;
            case "Ritz Side":
                if (a.getRitzSide_stat().equals("off")){
                    a.setCmd("21");
                    offButtons(a);
                    a.setRitzSide_stat("on");
                }else{
                    a.setCmd("22");
                    offButtons(a);
                    a.setRitzSide_stat("off");
                }
                break;
            case "Urdaneta Side":
                if (a.getUrdanetaSide_stat().equals("off")){
                    a.setCmd("23");
                    offButtons(a);
                    a.setUrdanetaSide_stat("on");
                }else{
                    a.setCmd("24");
                    offButtons(a);
                    a.setUrdanetaSide_stat("off");
                }
                break;
            case "Discovery Primea Side":
                if (a.getDiscoveryPrimeaSide_stat().equals("off")){
                    a.setCmd("25");
                    offButtons(a);
                    a.setDiscoveryPrimeaSide_stat("on");
                }else{
                    a.setCmd("26");
                    offButtons(a);
                    a.setDiscoveryPrimeaSide_stat("off");
                }
                break;
            case "Garden":
                if (a.getGarden_stat().equals("off")){
                    a.setCmd("27");
                    offButtons(a);
                    a.setGarden_stat("on");
                }else{
                    a.setCmd("28");
                    offButtons(a);
                    a.setGarden_stat("off");
                }
                break;
            case "Play Area":
                if (a.getPlayArea_stat().equals("off")){
                    a.setCmd("29");
                    offButtons(a);
                    a.setPlayArea_stat("on");
                }else{
                    a.setCmd("30");
                    offButtons(a);
                    a.setPlayArea_stat("off");
                }
                break;
            case "Wine Tasting":
                if (a.getWineTasting_stat().equals("off")){
                    a.setCmd("31");
                    offButtons(a);
                    a.setWineTasting_stat("on");
                }else{
                    a.setCmd("32");
                    offButtons(a);
                    a.setWineTasting_stat("off");
                }
                break;
            case "Outdoor Lounge":
                if (a.getOutdoorLounge_stat().equals("off")){
                    a.setCmd("33");
                    offButtons(a);
                    a.setOutdoorLounge_stat("on");
                }else{
                    a.setCmd("34");
                    offButtons(a);
                    a.setOutdoorLounge_stat("off");
                }
                break;
            case "Wine Cellar":
                if (a.getWineCellar_stat().equals("off")){
                    a.setCmd("35");
                    offButtons(a);
                    a.setWineCellar_stat("on");
                }else{
                    a.setCmd("36");
                    offButtons(a);
                    a.setWineCellar_stat("off");
                }
                break;
            case "Business Centre":
                if (a.getBusinessCentre_stat().equals("off")){
                    a.setCmd("37");
                    offButtons(a);
                    a.setBusinessCentre_stat("on");
                }else{
                    a.setCmd("38");
                    offButtons(a);
                    a.setBusinessCentre_stat("off");
                }
                break;
            case "Fitness Centre":
                if (a.getFitnessCentre_stat().equals("off")){
                    a.setCmd("39");
                    offButtons(a);
                    a.setFitnessCentre_stat("on");
                }else{
                    a.setCmd("40");
                    offButtons(a);
                    a.setFitnessCentre_stat("off");
                }
                break;
            case "Atrium Lounge":
                if (a.getAtriumLounge_stat().equals("off")){
                    a.setCmd("41");
                    offButtons(a);
                    a.setAtriumLounge_stat("on");
                }else{
                    a.setCmd("42");
                    offButtons(a);
                    a.setAtriumLounge_stat("off");
                }
                break;
            case "Pavillion Lounge":
                if (a.getPavillionLounge_stat().equals("off")){
                    a.setCmd("43");
                    offButtons(a);
                    a.setPavillionLounge_stat("on");
                }else{
                    a.setCmd("44");
                    offButtons(a);
                    a.setPavillionLounge_stat("off");
                }
                break;
            case "Arrival Lounge":
                if (a.getArrivalLounge_stat().equals("off")){
                    a.setCmd("45");
                    offButtons(a);
                    a.setArrivalLounge_stat("on");
                }else{
                    a.setCmd("46");
                    offButtons(a);
                    a.setArrivalLounge_stat("off");
                }
                break;
            case "Piano Lounge":
                if (a.getPianoLounge_stat().equals("off")){
                    a.setCmd("47");
                    offButtons(a);
                    a.setPianoLounge_stat("on");
                }else{
                    a.setCmd("48");
                    offButtons(a);
                    a.setPianoLounge_stat("off");
                }
                break;
            case "Pool Deck":
                if (a.getPoolDeck_stat().equals("off")){
                    a.setCmd("49");
                    offButtons(a);
                    a.setPoolDeck_stat("on");
                }else{
                    a.setCmd("50");
                    offButtons(a);
                    a.setPoolDeck_stat("off");
                }
                break;
            default:
        }

    }

    public void offButtons(MainActivity context){
        context.setAll_stat("off");
        context.setAmenity_stat("off");
        context.setAmenityPenthouse_stat("off");
        context.setAyalaSide_stat("off");
        context.setDiscoveryPrimeaSide_stat("off");
        context.setGarden_stat("off");
        context.setBusinessCentre_stat("off");
        context.setFitnessCentre_stat("off");
        context.setAtriumLounge_stat("off");
        context.setArrivalLounge_stat("off");
        context.setRandom_stat("off");
        context.setLandscape_stat("off");
        context.setLobby_stat("off");
        context.setSecondFloor_stat("off");
        context.setTypicalFloor_stat("off");
        context.setRitzSide_stat("off");
        context.setUrdanetaSide_stat("off");
        context.setPlayArea_stat("off");
        context.setWineTasting_stat("off");
        context.setOutdoorLounge_stat("off");
        context.setWineCellar_stat("off");
        context.setPavillionLounge_stat("off");
        context.setPianoLounge_stat("off");
        context.setPoolDeck_stat("off");
        context.setStreet_stat("off");
        /*btn01.setBackgroundResource(R.drawable.btn_layout);
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
        btn13.setBackgroundResource(R.drawable.btn_layout);*/
    }

    public void changeImg(){
        bldg_view_arrlist.clear();
        if(a.getAll_stat().equals("off")){
            if(a.getAll_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("2");
            }
            else if(a.getLobby_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("1");
            }
            else if(a.getAmenity_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("3");
            }
            else if(a.getAmenityPenthouse_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("4");
            }
            else if(a.getTypicalFloor_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("6");
            }

            else if(a.getLandscape_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("7");
            }
            else if(a.getStreet_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("8");
            }
            else if(a.getAyalaSide_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("10");
            }
            else if(a.getRitzSide_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("right");
            }
            else if(a.getUrdanetaSide_stat().equals("on")){
                bldg_view_arrlist.clear();
                bldg_view_arrlist.add("10");
            }
            else if(a.getDiscoveryPrimeaSide_stat().equals("on")){
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