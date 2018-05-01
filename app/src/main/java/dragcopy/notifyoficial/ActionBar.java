package dragcopy.notifyoficial;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by dsconosido on 4/28/18.
 */

public class ActionBar extends AppCompatActivity{
    public ActionBar(View v, final Context context,String title){
        v.findViewById(R.id.favoritos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Favoritos", Toast.LENGTH_SHORT).show();
            }
        });
        v.findViewById(R.id.recientes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Recientes", Toast.LENGTH_SHORT).show();
            }
        });
        v.findViewById(R.id.photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Perfil", Toast.LENGTH_SHORT).show();
            }
        });
        TextView t = v.findViewById(R.id.title);
        t.setText(title);
    }
}
