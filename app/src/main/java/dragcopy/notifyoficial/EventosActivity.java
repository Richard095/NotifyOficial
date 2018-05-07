package dragcopy.notifyoficial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
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

import java.util.ArrayList;

import dragcopy.notifyoficial.Adapters.EventosAdapter;

public class EventosActivity extends AppCompatActivity {
        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    break;
                case R.id.navigation_dashboard:
                    break;
                case R.id.navigation_notifications:
                    break;
            }
            return true;
        }
    };

    public static final String Url = "https://notify123.000webhostapp.com/publicaciones.json";
    public static final String UrlImg = "https://notify123.000webhostapp.com/public-images.json";

    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<String> imgs = new ArrayList<>();
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View v = LayoutInflater.from(this).inflate(R.layout.actionbar,null);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(v);

        ActionBar actionBar = new ActionBar(v,this,"Eventos",this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        gridView = (GridView)findViewById(R.id.grid);
        loadData();

    }
    String link="";

    public void loadData(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            findViewById(R.id.progress).setVisibility(View.GONE);
                            JSONObject obj = new JSONObject(response);
                            JSONArray heroarray = obj.getJSONArray("publicaciones");

                            for(int i=0;i<heroarray.length();i++){
                                JSONObject heroObject = heroarray.getJSONObject(i);
                                if(heroObject.getString("cat_public_id").equals("2")) {
                                    nombres.add(heroObject.getString("titulo"));
                                    imgs.add(link);
                                }
                            }
                            gridView.setAdapter(new EventosAdapter(EventosActivity.this,nombres,imgs));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EventosActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
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
}
