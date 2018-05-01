package dragcopy.notifyoficial.Adapters;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dragcopy.notifyoficial.R;

/**
 * Created by dsconosido on 14/11/17.
 */

public class ConvocatoriasAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> texts;
    private final ArrayList<String> titles;
    private final ArrayList<Boolean> hearts;
    public ConvocatoriasAdapter(Activity context, ArrayList<String> texts, ArrayList<String> titles, ArrayList<Boolean> hearts) {
        super(context, R.layout.opcion_menu,texts);
        this.context = context;
        this.texts=texts;
        this.titles = titles;
        this.hearts = hearts;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.new_convocatoria,null,true);

        TextView title = rowview.findViewById(R.id.title);
        TextView text = rowview.findViewById(R.id.text);

        final ImageView iv = rowview.findViewById(R.id.heart);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hearts.set(position,!hearts.get(position));
                if (hearts.get(position)){
                    iv.setColorFilter(iv.getContext().getResources().getColor(R.color.notifystatus), PorterDuff.Mode.SRC_ATOP);
                }else{
                    iv.setColorFilter(iv.getContext().getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
                }
            }
        });

        text.setText(texts.get(position));
        title.setText(titles.get(position));

        rowview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Abriendo ", Toast.LENGTH_SHORT).show();
            }
        });

        return rowview;
    }
}
