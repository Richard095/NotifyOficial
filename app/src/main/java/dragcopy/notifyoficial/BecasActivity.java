package dragcopy.notifyoficial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import dragcopy.notifyoficial.Adapters.NoticiasAdapter;

public class BecasActivity extends AppCompatActivity {

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<String> news = new ArrayList<>();
    ArrayList<String> fullnews = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        //De aqui hasta donde diga es para la barra de estado, los 3 iconos finales
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View v = LayoutInflater.from(this).inflate(R.layout.actionbar,null);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(v);

        ActionBar actionBar = new ActionBar(v,this,"Becas");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //hasta aqui, igual agrega el include que veas en los xml a donde quieras que apareca esta barra personalizada

        listView = (ListView) findViewById(R.id.list);
        NoticiasAdapter listAdapter = new NoticiasAdapter(this, titles, image,news,fullnews,listView,false);
        listView.setDivider(null);
        listView.setAdapter(listAdapter);

        titles.add("Titulo de la beca 1");
        image.add(R.drawable.star);
        news.add("Aqui va el texto corto de la beca que se mostrar en el card view puedes poner el que quieras, ya luego hare que se redusca el texto original" +
                "Le ponemos mas texto para mas renglones");
        fullnews.add("Aqui va el texto corto de la beca que se mostrar en el card view puedes poner el que quieras, ya luego hare que se redusca el texto original" +
                "Aqui va el texto corto de la beca que se mostrar en el card view puedes poner el que quieras, ya luego hare que se redusca el texto original");
        titles.add("Titulo de la beca 2");
        image.add(R.drawable.star);
        news.add("Aqui va el texto corto de la beca que se mostrar en el card view puedes poner el que quieras, ya luego hare que se redusca el texto original" +
                "Le ponemos mas texto para mas renglones");
        fullnews.add("Aqui va el texto corto de la beca que se mostrar en el card view puedes poner el que quieras, ya luego hare que se redusca el texto original" +
                "Aqui va el texto corto de la beca que se mostrar en el card view puedes poner el que quieras, ya luego hare que se redusca el texto original");
        titles.add("Titulo de la beca 3");
        image.add(R.drawable.star);
        news.add("Aqui va el texto corto de la beca que se mostrar en el card view puedes poner el que quieras, ya luego hare que se redusca el texto original" +
                "Le ponemos mas texto para mas renglones");
        fullnews.add("Aqui va el texto corto de la beca que se mostrar en el card view puedes poner el que quieras, ya luego hare que se redusca el texto original" +
                "Aqui va el texto corto de la beca que se mostrar en el card view puedes poner el que quieras, ya luego hare que se redusca el texto original");

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