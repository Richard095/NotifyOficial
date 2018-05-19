package dragcopy.notifyoficial.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dragcopy.notifyoficial.LookEventoActivity;
import dragcopy.notifyoficial.R;

/**
 * Created by dsconosido on 4/30/18.
 */

public class EventosAdapter extends BaseAdapter {
    Activity context;
    ArrayList<String> nombre;
    ArrayList<String> imgs;

    public EventosAdapter(Activity context,ArrayList<String> nombre,ArrayList<String> imgs){
        this.context=context;
        this.nombre=nombre;
        this.imgs=imgs;
    }
    @Override
    public int getCount() {
        return nombre.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v = inflater.inflate(R.layout.newevento,null,true);
        TextView t = v.findViewById(R.id.text);
        ImageView imageView = v.findViewById(R.id.img);
        //imageView.setBackgroundResource(R.drawable.logo);
        imageView.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.colorBlack)));
        //Picasso.with(context).load(imgs.get(position)).into(imageView);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, LookEventoActivity.class);
                context.startActivity(i);
                context.overridePendingTransition(R.anim.right_in, R.anim.right_out);
            }
        });

        t.setText(nombre.get(position));
        t.bringToFront();

        return v;
    }
}
