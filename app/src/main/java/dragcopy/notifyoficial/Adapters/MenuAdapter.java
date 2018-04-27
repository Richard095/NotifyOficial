package dragcopy.notifyoficial.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dragcopy.notifyoficial.R;

/**
 * Created by dsconosido on 14/11/17.
 */

public class MenuAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<Class> towhere;
    private final ArrayList<String> items;
    private final ArrayList<Integer> images;
    public MenuAdapter(Activity context, ArrayList<String> items, ArrayList<Integer> images,ArrayList<Class> towhere) {
        super(context, R.layout.opcion_menu,items);
        this.context = context;
        this.towhere=towhere;
        this.items = items;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.opcion_menu,null,true);

        TextView text = (TextView)rowview.findViewById(R.id.text);
        ImageView imageView = (ImageView)rowview.findViewById(R.id.icon);

        text.setText(items.get(position));
        imageView.setImageResource(images.get(position));

        rowview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,towhere.get(position));
                context.startActivity(i);
            }
        });

        return rowview;
    }
}
