package com.example.photos;

import java.util.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;

public class Add extends Activity {

	DatePicker min;
	DatePicker max;
	CheckBox reminder;
	EditText name;
	EditText desc;
	Button submit;
	int type;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        
        submit = (Button)findViewById(R.id.submit);
        name   = (EditText)findViewById(R.id.title);
        desc = (EditText)findViewById(R.id.des);
        min = (DatePicker)findViewById(R.id.startdate);
        max   = (DatePicker)findViewById(R.id.enddate);
        reminder = (CheckBox)findViewById(R.id.remind);
        type = -1;

        addListenerOnButton()
        submit.setOnClickListener(
            new View.OnClickListener()
            {
                public void onClick(View view)
                {
                    Log.v("EditText", mEdit.getText().toString());
                }
            });
    }

    public void addListenerOnButton() {
     
    	submit.setOnClickListener(new View.OnClickListener() {
     
    		@Override
    		public void onClick(View v) {
     
    			RadioButton test = (RadioButton)findViewById(R.id.month);
    			if (test.isChecked())
    				type = 0;
    			test = (RadioButton)findViewById(R.id.year);
    			if (test.isChecked())
    				type = 1;
    			
    			boolean remind = reminder.isChecked();
    			String title = name.getText().toString();
    			String des = desc.getText().toString();
    			
    		}
     
    	});
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }
    
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
    }
    
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                break;
        }
    }
    
}
