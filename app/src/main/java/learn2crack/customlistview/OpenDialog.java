package learn2crack.customlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OpenDialog extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.big_item);
	//Localizar los controles
	TextView nombre = (TextView)findViewById(R.id.textView1);
	//Recuperamos la información pasada en el intent
	Intent intent = this.getIntent();
	//Construimos el mensaje a mostrar
	nombre.setText("Welcome " + intent.getStringExtra("web"));
	
	}

}
