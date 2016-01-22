package com.wowwee.roboremotebluesampleproject.fragments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.wowwee.roboremotebluesampleproject.ConnectionManager;
import com.wowwee.roboremotebluesampleproject.R;

//import com.wowwee.snappets.fragments.BaseViewFragment;

public class SelectionViewFragment extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		      /**
		       * Inflate the layout for this fragment
		       */
				View view = inflater.inflate(R.layout.fragment_tableservicesview, container, false);
				TableLayout tableLayout = (TableLayout) view.findViewById(R.id.table_services);
				int count = tableLayout.getChildCount();
				for (int i=0; i<count; i++) {
					View aTableRow = tableLayout.getChildAt(i);
					if (aTableRow instanceof TableRow) {
						TableRow aRow = (TableRow)aTableRow;
						aRow.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View arg0) {
								int count = ((TableRow)arg0).getChildCount();
								for (int i=0; i<count; i++) {
									View aTextview = ((ViewGroup) arg0).getChildAt(i);
									if (aTextview instanceof TextView) {
										TextView theTextview = (TextView)aTextview;
										FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
										if (theTextview.getText().equals("Service Name: Remote")) {
											Fragment aFragment = ConnectionManager.mRobot.createFragment();
											fragmentTransaction.replace(R.id.fragment_container, aFragment);
						        			fragmentTransaction.addToBackStack(null);
						        			fragmentTransaction.commit();
										}
									}
								}
							}
							
						});
					}
				}
				
			
				return view;
		   }
    @Override
    public void onResume()
    {
    	super.onResume();
    	getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    
}
