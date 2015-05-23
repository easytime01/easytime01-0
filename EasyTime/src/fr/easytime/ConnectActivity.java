package fr.easytime;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// import du projet
import fr.easytime.database.DataBaseContent;
import fr.easytime.tools.Check;;

public class ConnectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        Context context = this;
        
        final Button loginButton = (Button) findViewById(R.id.button1);
        final EditText editText1 = (EditText) findViewById(R.id.editText1);
             
        loginButton.setOnClickListener(new OnClickListener() {
      			
        @Override
        public void onClick(View v) {   
        	Check EasyTimeCheckMail ;
        	EasyTimeCheckMail = new Check();
        	DataBaseContent EasytimeDataBaseContent = new DataBaseContent(v.getContext()) ;
        		if (EasyTimeCheckMail.CheckMail(editText1.getText().toString()) == true) {
        			EasytimeDataBaseContent.open();
        			EasytimeDataBaseContent.insertUserEasyTime("Peter", "Howse");
		   			}
        		else {
        		Toast.makeText(null, "Merci de saisir un mail !!", Toast.LENGTH_LONG).show();
      		     }
        			
        		}
		   });
}
}
