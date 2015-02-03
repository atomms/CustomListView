package learn2crack.customlistview;

//import com.example.intent00.Intent00;
//import com.example.intent00.OpenDialog;
//import com.example.intent00.R;

//import com.example.intent00.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	GridView list;
	String[] web = { "Google Plus", "Twitter", "Windows", "Bing", "Itunes",
			"Wordpress", "Drupal" };
	String[] content = { "nice tool", "you know...", "shit!", "sorry?",
			"play it", "web design", "nice web design" };
	Integer[] imageId = { R.drawable.image1, R.drawable.image2,
			R.drawable.image3, R.drawable.image4, R.drawable.image5,
			R.drawable.image6, R.drawable.image7

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// añadir content
		CustomList adapter = new CustomList(MainActivity.this, web, content,
				imageId);
		list = (GridView) findViewById(R.id.list);
		// final TextView txtNombre = (TextView)findViewById(R.id.txt);
		// final ImageView img1 = (ImageView)findViewById(R.id.img);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Creamos el Intent
				// Intent intent = new Intent(MainActivity.this,
				// OpenDialog.class);
				Intent intent = null;
//				try {
//					Class<?> clase = Class
//							.forName("learn2crack.customlistview.OpenDialog");
					intent = new Intent(
							MainActivity.this,OpenDialog.class);

//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

				// Creamos la información a pasar entre actividades
                intent.putExtra("web",web[position]);
				// Iniciamos la nueva actividad
				startActivity(intent);
				Toast.makeText(MainActivity.this,
						"You Clicked at " + web[+position], Toast.LENGTH_SHORT)
						.show();

			}
		});

		// @Override
		// protected void onListItemClick(ListView lista, View vista, int
		// posicion, long id)
		// {
		// super.onListItemClick(lista, vista, posicion, id);
		// String nombrePractica = practicas[posicion];
		// try
		// {
		// Toast t= Toast.makeText(this, nombrePractica, Toast.LENGTH_SHORT);
		// t.show();
		// Class <?> clase = Class.forName("es.raul.listainterfaces."+
		// nombrePractica);
		// Intent intent = new Intent(this,clase);
		// startActivity(intent);
		// }
		// catch (ClassNotFoundException e)
		// {
		// Log.d(tag1, e.getMessage());
		// }
		// }

		// img1.setOnClickListener(new OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// // //abrimos un diálogo que confirma el envío
		// // AlertDialog.Builder alert = new AlertDialog.Builder(null);
		// // alert.setMessage("guay");
		// // alert.setPositiveButton("ok",null);
		// //// AlertDialog cosa = alert.create();
		// // alert.show();
		//
		// //Creamos el Intent
		// Intent intent = new Intent(MainActivity.this, OpenDialog.class);
		// //Creamos la información a pasar entre actividades
		// Bundle b = new Bundle();
		// b.putString("NOMBRE", txtNombre.getText().toString());
		// //Añadimos la información al intent
		// intent.putExtras(b);
		// //Iniciamos la nueva actividad
		// startActivity(intent);
		// }
		// });
	}

}
