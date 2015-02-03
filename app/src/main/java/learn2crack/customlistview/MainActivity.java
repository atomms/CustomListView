package learn2crack.customlistview;


import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	ListView list;
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

        // etiqueta para desplegar menu contextual
        ImageButton imagebutton = (ImageButton) findViewById(R.id.imageButton);
        registerForContextMenu(imagebutton);


//    public boolean onContextItemSelected(MenuItem item) {
//        // TextView textview2 = (TextView) findViewById(R.id.textView2);
////		gridcontrol = (TextView) findViewById(R.id.textView2);
//        switch (item.getItemId()) {
//            case R.id.CtxtOpt1:
//                gridcontrol.setText("clicked context 1");
//                return true;
//            case R.id.CtxtOpt2:
//                gridcontrol.setText("clicked context 2");
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }




        // añadir content
		CustomList adapter = new CustomList(MainActivity.this, web, content,
				imageId);
		list = (ListView) findViewById(R.id.list);
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

	}
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        // Inflate the menu; this adds items to the action bar if it is present.
        {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menuctx, menu);
        }
    }

}
