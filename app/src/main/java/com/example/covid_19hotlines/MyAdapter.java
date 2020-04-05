package com.example.covid_19hotlines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

//    String[] states;
    private List<String> states;
    private Context context;
    OnStateClickListener listener;

    public MyAdapter (OnStateClickListener listener){
        this.listener = listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.states,parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.txtStates.setText(states.get(i));

//        final String getState = states.get(i);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show();
////
////                Intent intent =  new Intent( context ,Hotlines.class);
////                intent.putExtra("state", getState);
////
////                context.startActivity(intent);
//
//            }
//        });
    }

    public void setAdapterItem(List<String> states1){
        if(states1 == null) return;
        if(states!=null) states = null;
        states = states1;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtStates;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtStates = itemView.findViewById(R.id.textViewStates);
            txtStates.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null  ){
                listener.onStateClick(getAdapterPosition());
            }
        }
    }



    public interface OnStateClickListener {
        void onStateClick(int position);
    }
}
