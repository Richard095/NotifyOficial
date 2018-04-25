package dragcopy.notifyoficial;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import dragcopy.notifyoficial.Adapters.MenuAdapter;

public class Inicio extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                        listView.setVisibility(View.VISIBLE);
                    break;
                case R.id.navigation_dashboard:
                        listView.setVisibility(View.GONE);
                    break;
                case R.id.navigation_notifications:
                        listView.setVisibility(View.GONE);
                    break;
            }
            return true;
        }
    };
    ArrayList<String> texts = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorWhite)));
        getSupportActionBar().setTitle("Inicio");

        MenuAdapter listAdapter = new MenuAdapter(this,texts, image);
        listView = (ListView) findViewById(R.id.list);
        listView.setDivider(null);
        listView.setAdapter(listAdapter);

        texts.add("Instituto");
        image.add(R.drawable.ic_notifications_black_24dp);

        texts.add("Noticias");
        image.add(R.drawable.ic_notifications_black_24dp);

        texts.add("Eventos");
        image.add(R.drawable.ic_notifications_black_24dp);

        texts.add("Convocatorias");
        image.add(R.drawable.ic_notifications_black_24dp);

        texts.add("Becas");
        image.add(R.drawable.ic_notifications_black_24dp);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
