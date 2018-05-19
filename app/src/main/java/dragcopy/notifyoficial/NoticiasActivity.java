package dragcopy.notifyoficial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
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

import dragcopy.notifyoficial.Adapters.NoticiasAdapter;

public class NoticiasActivity extends AppCompatActivity {

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<String> news = new ArrayList<>();
    ArrayList<String> fullnews = new ArrayList<>();
    ListView listView;
    public static final String Url = "http://sergrlcode.pythonanywhere.com/json/publicacion/";
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

        loadData();
    }

    public void loadData(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            findViewById(R.id.progress).setVisibility(View.GONE);
                            JSONArray heroarray = new JSONArray(response);

                            for(int i=0;i<heroarray.length();i++){
                                JSONObject heroObject = heroarray.getJSONObject(i);
                                if(heroObject.getString("cat_public_id").equals("1")) {
                                    String title = new String(heroObject.getString("titulo").getBytes("ISO-8859-1"),"UTF-8");
                                    String text = new String(heroObject.getString("descripcion").getBytes("ISO-8859-1"),"UTF-8");
                                    String textnew = text.substring(0, heroObject.getString("descripcion").length() / 2);

                                    titles.add(title);
                                    image.add(R.drawable.star);
                                    news.add(textnew + "...");
                                    fullnews.add(text);
                                }
                            }
                            NoticiasAdapter listAdapter = new NoticiasAdapter(NoticiasActivity.this, titles, image,news,fullnews,listView,true);
                            listView.setDivider(null);
                            listView.setAdapter(listAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NoticiasActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
            if (listView.getVisibility()==View.GONE){
                listView.setVisibility(View.VISIBLE);
                findViewById(R.id.look_noticia).setVisibility(View.GONE);
                return false;
            }else {
                finish();
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                return false;
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (listView.getVisibility()==View.GONE){
            listView.setVisibility(View.VISIBLE);
            findViewById(R.id.look_noticia).setVisibility(View.GONE);
        }else {
            super.onBackPressed();
            overridePendingTransition(R.anim.left_in, R.anim.left_out);
        }
    }
}