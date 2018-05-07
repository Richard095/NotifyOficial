package dragcopy.notifyoficial.Adapters;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dragcopy.notifyoficial.R;

/**
 * Created by dsconosido on 14/11/17.
 */

public class FavsRecientesAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> title;
    private final ArrayList<String> type;
    private final ArrayList<String> time;
    private final ArrayList<Integer> images;
    public FavsRecientesAdapter(Activity context, ArrayList<String> title, ArrayList<Integer> images, ArrayList<String> type, ArrayList<String> time) {
        super(context, R.layout.opcion_menu,title);
        this.context = context;
        this.type =type;
        this.title = title;
        this.images = images;
        this.time = time;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        final View rowview;
        rowview = inflater.inflate(R.layout.new_reciente, null, true);

        final TextView titletv = rowview.findViewById(R.id.title);
        final TextView type = rowview.findViewById(R.id.type);
        final TextView timetv = rowview.findViewById(R.id.time);
        final ImageView imageView = rowview.findViewById(R.id.img);
        RelativeLayout cc = (RelativeLayout)rowview.findViewById(R.id.changecolor);

        if(position%2==0){
            cc.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.colorGris)));
        }else{
            cc.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.colorWhite)));
        }

        titletv.setText(this.title.get(position));
        type.setText(this.type.get(position));
        imageView.setImageResource(images.get(position));
        timetv.setText(time.get(position));

        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Numero: "+position, Toast.LENGTH_SHORT).show();
            }
        });

        return rowview;
    }
}
