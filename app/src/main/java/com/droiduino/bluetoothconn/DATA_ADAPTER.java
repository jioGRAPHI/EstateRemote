package com.droiduino.bluetoothconn;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.droiduino.bluetoothconn.ui.home.HomeFragment;

import java.util.List;

public class DATA_ADAPTER {
    public static class ButtonListAdapter extends
            RecyclerView.Adapter<ButtonListAdapter.MyViewHolder> {


        private List<List<String>>btn_list;
        private OnClickListener onClickListener;

        private Activity a;

        private HomeFragment fragment;

        /**
         * View holder class
         * */
        public class MyViewHolder extends RecyclerView.ViewHolder {
            public Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn10, btn11, btn12;
            public MyViewHolder(View view) {
                super(view);
                btn01 = (Button) view.findViewById(R.id.btn01);
                btn02 = (Button) view.findViewById(R.id.btn02);
                btn03 = (Button) view.findViewById(R.id.btn03);
                btn04 = (Button) view.findViewById(R.id.btn04);
                btn05 = (Button) view.findViewById(R.id.btn05);
                btn06 = (Button) view.findViewById(R.id.btn06);
                btn07 = (Button) view.findViewById(R.id.btn07);
                btn08 = (Button) view.findViewById(R.id.btn08);
                btn09 = (Button) view.findViewById(R.id.btn09);
                btn10 = (Button) view.findViewById(R.id.btn10);
                btn11 = (Button) view.findViewById(R.id.btn11);
                btn12 = (Button) view.findViewById(R.id.btn12);
            }
        }

        public ButtonListAdapter(Activity a, List<List<String>> btn_list, HomeFragment fragment) {
            this.btn_list = btn_list;
            this.a = a;
            this.fragment = fragment;
        }

        public void setOnClickListener(OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
        }

        public interface OnClickListener {
            void onClick(int position, String model);
        }

        public int getItemCount() {
            return btn_list.size();
        }

        public void offButtons(MyViewHolder holder){
            holder.btn01.setBackgroundResource(R.drawable.btn_layout);
            holder.btn02.setBackgroundResource(R.drawable.btn_layout);
            holder.btn03.setBackgroundResource(R.drawable.btn_layout);
            holder.btn04.setBackgroundResource(R.drawable.btn_layout);
            holder.btn05.setBackgroundResource(R.drawable.btn_layout);
            holder.btn06.setBackgroundResource(R.drawable.btn_layout);
            holder.btn07.setBackgroundResource(R.drawable.btn_layout);
            holder.btn08.setBackgroundResource(R.drawable.btn_layout);
            holder.btn09.setBackgroundResource(R.drawable.btn_layout);
            holder.btn10.setBackgroundResource(R.drawable.btn_layout);
            holder.btn11.setBackgroundResource(R.drawable.btn_layout);
            holder.btn12.setBackgroundResource(R.drawable.btn_layout);
        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            List<String> c = btn_list.get(position);
            holder.btn01.setText(c.get(0));
            holder.btn02.setText(c.get(1));
            holder.btn03.setText(c.get(2));
            holder.btn04.setText(c.get(3));
            holder.btn05.setText(c.get(4));
            holder.btn06.setText(c.get(5));
            holder.btn07.setText(c.get(6));
            holder.btn08.setText(c.get(7));
            holder.btn09.setText(c.get(8));
            holder.btn10.setText(c.get(9));
            holder.btn11.setText(c.get(10));
            holder.btn12.setText(c.get(11));

            holder.btn01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn01.getText().toString(), holder.btn01);
                    offButtons(holder);
                    if (holder.btn01.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn01.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn01.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn02.getText().toString(), holder.btn02);
                    offButtons(holder);
                    if (holder.btn02.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn02.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn02.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn03.getText().toString(), holder.btn03);
                    if (holder.btn03.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn03.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn03.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn04.getText().toString(), holder.btn04);
                    offButtons(holder);
                    if (holder.btn04.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn04.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn04.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn05.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn05.getText().toString(), holder.btn05);
                    offButtons(holder);
                    if (holder.btn05.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn05.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn05.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn06.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn06.getText().toString(), holder.btn06);
                    offButtons(holder);
                    if (holder.btn06.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn06.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn06.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn07.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn07.getText().toString(), holder.btn07);
                    offButtons(holder);
                    if (holder.btn07.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn07.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn07.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn08.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn08.getText().toString(), holder.btn08);
                    offButtons(holder);
                    if (holder.btn08.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn08.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn08.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn09.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn09.getText().toString(), holder.btn09);
                    offButtons(holder);
                    if (holder.btn09.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn09.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn09.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn10.getText().toString(), holder.btn10);
                    offButtons(holder);
                    if (holder.btn10.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn10.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn10.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn11.getText().toString(), holder.btn11);
                    offButtons(holder);
                    if (holder.btn11.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn11.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn11.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });

            holder.btn12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.btn_commands(holder.btn12.getText().toString(), holder.btn12);
                    offButtons(holder);
                    if (holder.btn12.getBackground().getConstantState().equals(holder.btn10.getResources().getDrawable(R.drawable.btn_layout))){
                        holder.btn12.setBackgroundResource(R.drawable.btn_layout2);
                    }else{
                        holder.btn12.setBackgroundResource(R.drawable.btn_layout);
                    }
                    fragment.changeImg();
                }
            });
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.btn_layout,parent, false);
            return new MyViewHolder(v);
        }
    }
}
