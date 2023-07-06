package com.example.myapplication.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import com.bumptech.glide.Glide;
import com.example.myapplication.Modelos.Revista;

import com.example.myapplication.R;

import java.util.ArrayList;

public class AdaptadorRevista  extends ArrayAdapter<Revista> {
    public AdaptadorRevista(Context context, ArrayList<Revista> datos)
    {
        super(context, R.layout.lyitemrevista, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemrevista, null);

        TextView LblReviId = (TextView)item.findViewById(R.id.lblReviId);
        LblReviId.setText(getItem(position).getJournal_id());

        TextView LblNombre = (TextView)item.findViewById(R.id.lblNombre);
        LblNombre.setText(getItem(position).getName());


        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada()).into(imageView);
        return(item);
    }
}
