package dragcopy.notifyoficial;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
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
                    findViewById(R.id.calificar).setVisibility(View.GONE);
                    break;
                case R.id.navigation_notifications:
                    listView.setVisibility(View.GONE);
                    findViewById(R.id.calificar).setVisibility(View.VISIBLE);
                    break;
            }
            return true;
        }
    };
    public static final String Url = "http://sergrlcode.pythonanywhere.com/json/organizacion/";

    public void loadData(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response1) {
                        try {
                            String response = new String(response1.getBytes("ISO-8859-1"),"UTF-8");
                            JSONArray heroarray = new JSONArray(response);

                            //for(int i=0;i<heroarray.length();i++){}
                            JSONObject heroObject = heroarray.getJSONObject(0);
                            escuela.setText(heroObject.getString("nombre"));
                            director.setText(heroObject.getString("director"));
                            descripcion.setText(heroObject.getString("descripcion"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Inicio.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    ArrayList<String> texts = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<Class> classes = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Inicio");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorWhite)));

        View v = LayoutInflater.from(this).inflate(R.layout.actionbar,null);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(v);

        dragcopy.notifyoficial.ActionBar actionBar = new dragcopy.notifyoficial.ActionBar(v,this,"Inicio",this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MenuAdapter listAdapter = new MenuAdapter(this,texts, image,classes);
        listView = (ListView) findViewById(R.id.list);
        listView.setDivider(null);
        listView.setAdapter(listAdapter);

        escuela = (TextView) findViewById(R.id.name_school);
        director = (TextView) findViewById(R.id.name_director);
        descripcion = (TextView) findViewById(R.id.descripcion);

        //texts.add("Instituto");
        //image.add(R.drawable.instituto);
        //classes.add(InstitutoActivity.class);

        texts.add("Noticias");
        image.add(R.drawable.noticias);
        classes.add(NoticiasActivity.class);

        texts.add("Eventos");
        image.add(R.drawable.events);
        classes.add(EventosActivity.class);

        texts.add("Convocatorias");
        image.add(R.drawable.becas);
        classes.add(ConvocatoriasActivity.class);

        texts.add("Becas");
        image.add(R.drawable.becas);
        classes.add(BecasActivity.class);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadData();
    }
    TextView escuela,director,descripcion;
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
            Intent i = new Intent(Inicio.this,AcercaDeActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        } else if (id == R.id.contacto) {
            Toast.makeText(this,"Contacto", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.soporte) {
            Intent i = new Intent(Inicio.this,AjustesActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        } else if (id == R.id.salir) {
            System.exit(0);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
