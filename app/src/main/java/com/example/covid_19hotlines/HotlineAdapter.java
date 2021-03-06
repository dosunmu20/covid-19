package com.example.covid_19hotlines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HotlineAdapter extends RecyclerView.Adapter<HotlineAdapter.HotlineViewHolder>  {

    String[] hotlines;
    Context context ;
    HotlineListener hotlineListener;

    public HotlineAdapter (HotlineListener hotlineListener) {
        this.hotlineListener = hotlineListener;
    }

    @NonNull
    @Override
    public HotlineAdapter.HotlineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotline_item,parent,false);
        return new HotlineViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HotlineAdapter.HotlineViewHolder holder, final int position) {
        holder.textViewHotlines.setText(hotlines[position]);

//
//      holder.itemView.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//              Intent callIntent = new Intent(Intent.ACTION_CALL);
//              callIntent.setData(Uri.parse("tel:" + hotlines[position]));
//
//              if (ActivityCompat.checkSelfPermission(context,
//                      Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                  return;
//              }
//              context.startActivity(callIntent);
//          }
//      });
    }

    @Override
    public int getItemCount() {
        return hotlines == null ? 0 : hotlines.length;
    }

    public void setHotlinesAdapterItem(String[] hotlines1){
        if(hotlines1 == null) return;
        if(hotlines!=null) hotlines = null;
        hotlines = hotlines1;
        notifyDataSetChanged();
    }

    public class HotlineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewHotlines;

        public HotlineViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewHotlines = itemView.findViewById(R.id.hotlines);

            textViewHotlines.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(hotlineListener != null){
                hotlineListener.onClickHotlineItem(getAdapterPosition());
            }
        }

    }
    public interface HotlineListener {
        void onClickHotlineItem(int positon);
    }
}
