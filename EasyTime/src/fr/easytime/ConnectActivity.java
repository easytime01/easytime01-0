package fr.easytime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ConnectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        
        final Button loginButton = (Button) findViewById(R.id.button1);
        final Button editText1 = (Button) findViewById(R.id.editText1);
        final Button editText2 = (Button) findViewById(R.id.editText2);
        
        loginButton.setOnClickListener(new OnClickListener() {
      			
        @Override
        public void onClick(View v) {  
             
        	
        	
      	}
      });
    }
}
