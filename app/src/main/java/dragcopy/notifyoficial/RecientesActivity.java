package dragcopy.notifyoficial;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import dragcopy.notifyoficial.Adapters.FavsRecientesAdapter;

public class RecientesActivity extends AppCompatActivity {

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<String> type = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recientes);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View v = LayoutInflater.from(this).inflate(R.layout.actionbar,null);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(v);

        ActionBar actionBar = new ActionBar(v,this,"Recientes",this);

        ImageButton ib = (ImageButton)v.findViewById(R.id.recientes);
        ib.setColorFilter(ib.getContext().getResources().getColor(R.color.notifystatus), PorterDuff.Mode.SRC_ATOP);
        ib.setClickable(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listView = (ListView) findViewById(R.id.list);
        FavsRecientesAdapter listAdapter = new FavsRecientesAdapter(this, titles, image, type, time);
        listView.setDivider(null);
        listView.setAdapter(listAdapter);

        titles.add("Graduación ISC");
        image.add(R.drawable.graduacion);
        type.add("Evento");
        time.add("10:45 PM");

        titles.add("Beca Subes");
        image.add(R.drawable.logo);
        type.add("Becas");
        time.add("8:45 PM");

        titles.add("Graduación ISC");
        image.add(R.drawable.graduacion);
        type.add("Evento");
        time.add("10:45 PM");

        titles.add("Beca Subes");
        image.add(R.drawable.logo);
        type.add("Becas");
        time.add("8:45 PM");

        titles.add("Graduación ISC");
        image.add(R.drawable.graduacion);
        type.add("Evento");
        time.add("10:45 PM");
       }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:finish();
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
}