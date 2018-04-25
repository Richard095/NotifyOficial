package dragcopy.notifyoficial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import dragcopy.notifyoficial.Adapters.MenuAdapter;

public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
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
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Inicio");
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.acerca) {
            Toast.makeText(this,"Acerca de", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.contacto) {
            Toast.makeText(this,"Contacto", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.soporte) {
            Toast.makeText(this,"Soporte", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.salir) {
            System.exit(0);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
