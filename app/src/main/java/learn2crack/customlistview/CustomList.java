package learn2crack.customlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

//	inicializamos variables
	private final Activity context;
	private final String[] web;
	private final String[] content;
	private final Integer[] imageId;

	public CustomList(Activity context, String[] web, String[] content,
			Integer[] imageId) {
		super(context, R.layout.list_single, web);
		this.context = context;
		this.web = web;
		this.imageId = imageId;
		// la contextualizamos
		this.content = content;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.list_single, null, true);
		
		TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
		TextView txtContent = (TextView) rowView.findViewById(R.id.txt2);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		
		// desde el array inflamos el adaptador una posicion tras otra
		txtTitle.setText(web[position]);
		txtContent.setText(content[position]);
		imageView.setImageResource(imageId[position]);

		return rowView;
	}
}