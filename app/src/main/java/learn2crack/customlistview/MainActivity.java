package learn2crack.customlistview;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;



public class MainActivity extends Activity {
	ListView list;
    public ImageButton imagebutton;

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
        imagebutton = (ImageButton) findViewById(R.id.imageButton);
        registerForContextMenu(imagebutton);


        // añadir content
		CustomList adapter = new CustomList(MainActivity.this, web, content,
				imageId);
		list = (ListView) findViewById(R.id.list);

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

    // creando el menu ppal

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // alternativa
        // MenuInflater inflater = getMenuInflater();
        // inflater.inflate(R.menu.main,menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // eventos del menu ActionBar

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TextView textview2 = (TextView) findViewById(R.id.textView2);
//		textview1 = (TextView) findViewById(R.id.textView2);
        switch (item.getItemId()) {
            case R.id.mainitem0:
                Toast.makeText(MainActivity.this,
                        "You Clicked at " + item.getTitle(), Toast.LENGTH_SHORT)
                        .show();
                              return true;
            case R.id.mainitem1:
                Toast.makeText(MainActivity.this,
                        "You Clicked at " + item.getTitle(), Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.mainitem2:
                Toast.makeText(MainActivity.this,
                        "You Clicked at " + item.getTitle(), Toast.LENGTH_SHORT)
                        .show();

                return true;
            case R.id.mainitem3:
                Toast.makeText(MainActivity.this,
                        "You Clicked at " + item.getTitle(), Toast.LENGTH_SHORT)
                        .show();

                return true;
            case R.id.subitem1:
                Toast.makeText(MainActivity.this,
                        "You Clicked at " + item.getTitle(), Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.subitem2:
                Toast.makeText(MainActivity.this,
                        "You Clicked at " + item.getTitle(), Toast.LENGTH_SHORT)
                        .show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.subitem1:
//                imagebutton.setImageResource(imagebutton.get("blah"));
                Toast.makeText(MainActivity.this,
                        "You Clicked at " + item.getTitle(), Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.subitem2:
                Toast.makeText(MainActivity.this,
                        "You Clicked at " + item.getTitle(), Toast.LENGTH_SHORT)
                        .show();
            default:
                return super.onContextItemSelected(item);
        }
    }
}
