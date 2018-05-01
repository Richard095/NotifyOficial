package dragcopy.notifyoficial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import dragcopy.notifyoficial.Adapters.ConvocatoriasAdapter;

public class ConvocatoriasActivity extends AppCompatActivity {

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> texts = new ArrayList<>();
    ArrayList<Boolean> hearts = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View v = LayoutInflater.from(this).inflate(R.layout.actionbar,null);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(v);

        ActionBar actionBar = new ActionBar(v,this,"Convocatorias",this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listView = (ListView) findViewById(R.id.list);
        ConvocatoriasAdapter convocatoriasAdapter = new ConvocatoriasAdapter(this,texts,titles, hearts);
        listView.setDivider(null);
        listView.setAdapter(convocatoriasAdapter);
        convocatoriasAdapter.notifyDataSetChanged();

        titles.add("titulo 1");
        texts.add("Texto 1");
        hearts.add(false);

        titles.add("titulo 2");
        texts.add("Texto 2");
        hearts.add(false);

        titles.add("titulo 3");
        texts.add("Texto 3");
        hearts.add(false);

        titles.add("titulo 1");
        texts.add("Texto 1");
        hearts.add(false);

        titles.add("titulo 2");
        texts.add("Texto 2");
        hearts.add(false);

        titles.add("titulo 3");
        texts.add("Texto 3");
        hearts.add(false);

        titles.add("titulo 1");
        texts.add("Texto 1");
        hearts.add(false);

        titles.add("titulo 2");
        texts.add("Texto 2");
        hearts.add(false);

        titles.add("titulo 3");
        texts.add("Texto 3");
        hearts.add(false);

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
