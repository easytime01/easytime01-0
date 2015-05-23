package fr.easytime;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

// import du projet
import fr.easytime.database.DatabaseHelper;
import fr.easytime.tools.Check;;

public class ConnectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        
        final Button loginButton = (Button) findViewById(R.id.button1);
        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        
        loginButton.setOnClickListener(new OnClickListener() {
      			
        @Override
        public void onClick(View v) {   
        
        	Check EasyTimeCheckMail ;
        	
        	
        	EasyTimeCheckMail = new Check();
        	
        	
        	 DatabaseHelper EasytimeDatabaseHelper = new DatabaseHelper(null) ;
        	 SQLiteDatabase database = null;
			
        		if (EasyTimeCheckMail.CheckMail(editText1.getText().toString()) == true) {
        	// EasytimeDatabaseHelper.onCreate(database);
				
		
			
		   			}

		    }
			
      });
}
}
