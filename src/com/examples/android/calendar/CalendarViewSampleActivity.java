/*
* Copyright 2011 Lauri Nevala.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.examples.android.calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class CalendarViewSampleActivity extends Activity {
    /** Called when the activity is first created. */
    
    static final int DATE_DIALOG_ID = 0;
	static final int PICK_DATE_REQUEST = 1;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button openButton = (Button)findViewById(R.id.openButton);
        
        openButton.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				DatePicker dp = (DatePicker)findViewById(R.id.datePicker1);
				Intent intent = new Intent(v.getContext(),CalendarView.class);
				
	    		intent.putExtra("date", dp.getYear()+"-"+dp.getMonth()+"-"+dp.getDayOfMonth());
	    		startActivityForResult(intent, PICK_DATE_REQUEST);				
			}
		});
    }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == PICK_DATE_REQUEST) {
            if (resultCode == RESULT_OK) {
            	Toast.makeText(getApplicationContext(), data.getStringExtra("date"), Toast.LENGTH_SHORT).show();
            	String[] dateArr = data.getStringExtra("date").split("-");
            	DatePicker dp = (DatePicker)findViewById(R.id.datePicker1);
            	dp.updateDate(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2]));
            }
		}
	}
		
}