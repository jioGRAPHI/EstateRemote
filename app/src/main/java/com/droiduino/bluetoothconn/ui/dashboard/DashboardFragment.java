package com.droiduino.bluetoothconn.ui.dashboard;

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

public class DashboardFragment extends Fragment {

    private Button btn07, btn08;
    private String btn07_stat, btn08_stat;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MainActivity context = (MainActivity)getActivity();
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        /*final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/

        context.setCmd("18");

        btn07 = (Button) root.findViewById(R.id.btn07);
        btn08 = (Button) root.findViewById(R.id.btn08);

        btn07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn07_stat().equals("off")){
                    context.setCmd("13");
                    context.setBtn07_stat("on");
                }else{
                    context.setCmd("14");
                    context.setBtn07_stat("off");
                }
            }
        });

        btn08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getBtn08_stat().equals("off")){
                    context.setCmd("15");
                    context.setBtn08_stat("on");
                }else{
                    context.setCmd("16");
                    context.setBtn08_stat("off");
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}