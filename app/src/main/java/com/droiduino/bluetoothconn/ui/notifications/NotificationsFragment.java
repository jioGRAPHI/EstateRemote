package com.droiduino.bluetoothconn.ui.notifications;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotificationsFragment extends Fragment {
    private List<String> random_pattern = new ArrayList<String>();
    private Button btn09;
    private boolean random_stat;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        MainActivity context = (MainActivity)getActivity();

        context.setCmd("18");

        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        /*final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/

        btn09 = (Button) root.findViewById(R.id.btn09);
        random_stat = false;

        btn09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!random_stat) {
                    context.setCmd("17");
                    random_stat = true;
                }else{
                    context.setCmd("18");
                    random_stat = false;
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