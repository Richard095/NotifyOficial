package dragcopy.notifyoficial.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import dragcopy.notifyoficial.R;

/**
 * Created by dsconosido on 14/11/17.
 */

public class NoticiasAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> title;
    private final ArrayList<String> news;
    private final ArrayList<String> fullnew;
    private final ArrayList<Integer> images;
    private final boolean isnoticia;
    private ListView list;
    public NoticiasAdapter(Activity context, ArrayList<String> items, ArrayList<Integer> images, ArrayList<String> news, ArrayList<String> fullnew, ListView list,boolean isnoticia) {
        super(context, R.layout.opcion_menu,items);
        this.context = context;
        this.news=news;
        this.title = items;
        this.images = images;
        this.fullnew = fullnew;
        this.isnoticia=isnoticia;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        final View rowview;
        if(isnoticia) {
            rowview = inflater.inflate(R.layout.new_noticia, null, true);
        }else{
            rowview = inflater.inflate(R.layout.new_beca, null, true);
        }

        final TextView titletv = rowview.findViewById(R.id.title);
        final TextView notice = rowview.findViewById(R.id.notice);
        final ImageView imageView = rowview.findViewById(R.id.icon);

        titletv.setText(this.title.get(position));
        if(titletv.getText().equals("null") || titletv.getText().equals("")){
            titletv.setVisibility(View.GONE);
        }
        notice.setText(this.news.get(position));
        imageView.setImageResource(images.get(position));

        rowview.findViewById(R.id.opennews).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.setVisibility(View.GONE);
                context.findViewById(R.id.look_noticia).setVisibility(View.VISIBLE);
                TextView t=context.findViewById(R.id.look_noticia).findViewById(R.id.title);
                TextView n=context.findViewById(R.id.look_noticia).findViewById(R.id.notice);
                TextView open=context.findViewById(R.id.look_noticia).findViewById(R.id.opennews);
                ImageView i=context.findViewById(R.id.look_noticia).findViewById(R.id.icon);

                t.setText(title.get(position));
                n.setText(fullnew.get(position));
                i.setImageResource(images.get(position));
                open.setText("Comentar");


                if(t.getText().equals("null") || t.getText().equals("")){
                    t.setVisibility(View.GONE);
                }
            }
        });

        return rowview;
    }
}
