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
        ConvocatoriasAdapter convocatoriasAdapter = new ConvocatoriasAdapter(this,texts,titles);
        listView.setDivider(null);

        listView.setAdapter(convocatoriasAdapter);

        titles.add("Titulo de convocatoria 1");
        texts.add("Texto o archivo");

        titles.add("Titulo de convocatoria 2");
        texts.add("Texto o archivo");

        titles.add("Titulo de convocatoria 3");
        texts.add("Texto o archivo");

        titles.add("Titulo de convocatoria 4");
        texts.add("Texto o archivo");

        titles.add("Titulo de convocatoria 5");
        texts.add("Texto o archivo");

        titles.add("Titulo de convocatoria 6");
        texts.add("Texto o archivo");

        findViewById(R.id.progress).setVisibility(View.GONE);

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
