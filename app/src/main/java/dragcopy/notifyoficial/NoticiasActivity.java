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

public class NoticiasActivity extends AppCompatActivity {

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<String> news = new ArrayList<>();
    ArrayList<String> fullnews = new ArrayList<>();
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

        ActionBar actionBar = new ActionBar(v,this,"Noticias",this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listView = (ListView) findViewById(R.id.list);
        NoticiasAdapter listAdapter = new NoticiasAdapter(this, titles, image,news,fullnews,listView,true);
        listView.setDivider(null);
        listView.setAdapter(listAdapter);

        titles.add("Instituto");
        image.add(R.drawable.star);
        news.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");
        fullnews.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres" +
                "Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");

        titles.add("Instituto 1");
        image.add(R.drawable.star);
        news.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");
        fullnews.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres" +
                "Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");

        titles.add("Instituto 2");
        image.add(R.drawable.star);
        news.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");
        fullnews.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres" +
                "Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");

        titles.add("Instituto 3");
        image.add(R.drawable.star);
        news.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");
        fullnews.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres" +
                "Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");

        titles.add("Instituto 4");
        image.add(R.drawable.star);
        news.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");
        fullnews.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres" +
                "Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");

        titles.add("Instituto 5");
        image.add(R.drawable.star);
        news.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");
        fullnews.add("Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres" +
                "Aqui va la noticia, el texto de la noticia, el cuerpo de la noticia y todo eso tambien puede ir una imagen o algo asi asi que tu elige que quieres");

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