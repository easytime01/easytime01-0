package fr.easytime;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        final Button loginButton = (Button) findViewById(R.id.button1);
        loginButton.setOnClickListener(new OnClickListener() {
      			
        @Override
        public void onClick(View v) {
      	Intent intent = new Intent(MainActivity.this, ConnectActivity.class);
      	startActivity(intent);
      	}
      });
    }
}
