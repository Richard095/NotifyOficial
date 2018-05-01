package dragcopy.notifyoficial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by dsconosido on 4/28/18.
 */

public class ActionBar extends AppCompatActivity{
    public ActionBar(View v, final Context context, String title, final Activity activity){
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
                Intent i = new Intent(context,PerfilActivity.class);
                context.startActivity(i);
                activity.overridePendingTransition(R.anim.right_in, R.anim.right_out);

            }
        });
        TextView t = v.findViewById(R.id.title);
        t.setText(title);
    }
}
