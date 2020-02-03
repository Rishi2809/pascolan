package com.rishi.pascolan;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<DataModel> list_array;
    private Context context;

    public DataAdapter(Context context,ArrayList<DataModel> List_array) {
        this.context = context;
        this.list_array = List_array;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {

        viewHolder.name.setText(list_array.get(i).getnames());
        Picasso.get().load(list_array.get(i).getimage_url()).resize(320,320).into(viewHolder.image_url);
    final DataModel DataModel = list_array.get(i);
     //   Toast.makeText(context,"hi",Toast.LENGTH_SHORT).show();
        viewHolder.layout.setBackgroundColor(DataModel.isSelected() ? Color.CYAN : Color.WHITE);
//    viewHolder.vieww.setBackgroundResource(DataModel.isSelected()? R.drawable.ic_check_black_24dp : R.drawable.selector);
        viewHolder.image_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataModel.setSelected(!DataModel.isSelected());
                viewHolder.layout.setBackgroundColor(DataModel.isSelected() ? Color.CYAN : Color.WHITE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_array.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image_url;
        RelativeLayout layout;
        public ViewHolder(View view) {
            super(view);

layout = view.findViewById(R.id.relaLay);
            name = (TextView)view.findViewById(R.id.text);
            image_url = (ImageView)view.findViewById(R.id.image_url);
        }
    }
}
