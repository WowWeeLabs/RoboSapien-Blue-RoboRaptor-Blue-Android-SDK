package com.wowwee.roboremotebluesampleproject.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.wowwee.roboremote.robots.IRobot;
import com.wowwee.roboremotebluesampleproject.R;

public class RobotScannerAdapter extends ArrayAdapter<IRobot> {
    Context context;
    int layoutResourceId;
    IRobot data[] = null;

    public RobotScannerAdapter(Context context, int layoutResourceId, IRobot[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RobotScannerItemHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new RobotScannerItemHolder();
            holder.m_nameTextView = (TextView)row.findViewById(R.id.textViewRobotName);
            holder.m_imgView = (ImageView)row.findViewById(R.id.imageViewRobotType);
            
            row.setTag(holder);
        }
        else
        {
            holder = (RobotScannerItemHolder)row.getTag();
        }

        IRobot robot = data[position];
        holder.m_robot = robot;
        holder.m_nameTextView.setText(robot.getName());
        holder.m_imgView.setImageResource(robot.getLogoDrawableId());

        return row;
    }
    
    public static class RobotScannerItemHolder
    {
        protected IRobot m_robot;
        protected TextView m_nameTextView;
        protected ImageView m_imgView;

        public IRobot getRobot() {
            return this.m_robot;
        }
    }
}
