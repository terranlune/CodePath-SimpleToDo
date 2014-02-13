package codepath.apps.simpletodo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {

	private int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		
		// Show the Up button in the action bar.
		setupActionBar();

		String text = getIntent().getStringExtra("text");
		position = getIntent().getIntExtra("position", -1);
		EditText etText = (EditText) findViewById(R.id.etText);
		etText.setText(text);
	}

	public void save(View v) {
		EditText etText = (EditText) findViewById(R.id.etText);
		Intent data = new Intent();
		data.putExtra("position", position);
		data.putExtra("text", etText.getText().toString());
		setResult(RESULT_OK, data);
		finish();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
}
