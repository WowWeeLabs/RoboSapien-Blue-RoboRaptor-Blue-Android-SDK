package com.wowwee.roboremotebluesampleproject.fragments.robots;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.*;

import com.wowwee.roboremotebluesampleproject.R;

import java.util.ArrayList;
import java.util.List;

public class RobosapienFragment extends BluetoothRobotFragment {

    private LinearLayout m_layoutLeftPanel;
    private LinearLayout m_layoutRightPanel;

    private com.wowwee.roboremotebluesampleproject.utils.AutoResizeTextView m_textViewCommands;

    private List<View> pages;
    private Button prevPageButton;
    private Button nextPageButton;
    private int currentPage = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_remote_robosapien, container, false);
        updateChildButtons((ViewGroup) view);
        prepareFragmentView(view);

        this.m_textViewCommands = (com.wowwee.roboremotebluesampleproject.utils.AutoResizeTextView) view.findViewById(R.id.textView_BottomPanel_CommandName);
        this.m_textViewCommands.setText("");

        this.m_layoutLeftPanel = (LinearLayout) view.findViewById(R.id.layoutRemote_LeftPanel);
        this.m_layoutRightPanel = (LinearLayout) view.findViewById(R.id.layoutRemote_RightPanel);
        this.m_layoutLeftPanel.setVisibility(View.INVISIBLE);
        this.m_layoutRightPanel.setVisibility(View.INVISIBLE);
        this.m_layoutLeftPanel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }
        });
        this.m_layoutRightPanel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }
        });

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int bottomLayoutOffset = 0;
        int pageOffset = 0;
        int commandOffset = 0;
        int generalOffset = 0;
        Log.i("Resolution: ", metrics.widthPixels + "," + metrics.heightPixels);
        float scale = 480.0f / 1920.0f * Math.max(metrics.heightPixels, metrics.widthPixels) / metrics.densityDpi;
        Log.i("densityDPI:", "" + metrics.xdpi + "," + metrics.ydpi);

        if (metrics.widthPixels == 480 && metrics.heightPixels == 800) {
            bottomLayoutOffset = -20;
            pageOffset = -7;
            commandOffset = -10;
        } else if (metrics.widthPixels == 480 && metrics.heightPixels == 854) {
            pageOffset = 3;
            commandOffset = -10;
        } else if (metrics.widthPixels == 720) {
            if (metrics.heightPixels != 1280) {
                commandOffset = -(1280 - metrics.heightPixels) / 4;
                pageOffset = -(1280 - metrics.heightPixels) / 4;
                bottomLayoutOffset = -(1280 - metrics.heightPixels) / 4;
            }
        } else if (metrics.widthPixels == 800) {
            if (metrics.heightPixels != 1280) {
                commandOffset = -(1280 - metrics.heightPixels) / 4;
                pageOffset = -(1280 - metrics.heightPixels) / 4;
                bottomLayoutOffset = -(1280 - metrics.heightPixels) / 4;
            }
        } else if (metrics.widthPixels == 1080) {
            if (metrics.heightPixels != 1920) {
                commandOffset = -(1920 - metrics.heightPixels) / 4;
                pageOffset = -(1920 - metrics.heightPixels) / 4;
                bottomLayoutOffset = -(1920 - metrics.heightPixels) / 4;
            }
        } else if (metrics.widthPixels == 1440) {
            if (metrics.heightPixels != 2560) {
                commandOffset = -(2560 - metrics.heightPixels) / 4;
                pageOffset = -(2560 - metrics.heightPixels) / 4;
                bottomLayoutOffset = -(2560 - metrics.heightPixels) / 4;
            }

        } else if (metrics.widthPixels == 1600) {
            if (metrics.heightPixels != 2560) {
                commandOffset = -(2560 - metrics.heightPixels) / 4;
                pageOffset = -(2560 - metrics.heightPixels) / 4;
                bottomLayoutOffset = -(2560 - metrics.heightPixels) / 4;
            }

        }

        View viewBottomLayout = view.findViewById(R.id.layoutRemote_BottomPanel);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewBottomLayout.getLayoutParams();
        params.bottomMargin += bottomLayoutOffset;
        viewBottomLayout.setLayoutParams(params);

        View viewChangePage = view.findViewById(R.id.layoutRemote_ChangePage);
        params = (RelativeLayout.LayoutParams) viewChangePage.getLayoutParams();
        params.bottomMargin += pageOffset;
        viewChangePage.setLayoutParams(params);

        View viewCommand = view.findViewById(R.id.layoutRemote_BottomPanel_CommandName);
        FrameLayout.LayoutParams paramsFrameLayout = (FrameLayout.LayoutParams) viewCommand.getLayoutParams();
        paramsFrameLayout.bottomMargin += commandOffset;

        pages = new ArrayList<View>();
        prevPageButton = (Button) view.findViewById(R.id.prev_page);
        nextPageButton = (Button) view.findViewById(R.id.next_page);
        pages.add(view.findViewById(R.id.layoutRemote_top));
        pages.add(view.findViewById(R.id.layoutRemote_top2));
        pages.add(view.findViewById(R.id.layoutRemote_top3));
        prevPageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage > 0) {
                    currentPage--;
                }
                updatePageNavigation();
            }
        });
        nextPageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage < pages.size() - 1) {
                    currentPage++;
                }
                updatePageNavigation();
            }
        });
        updatePageNavigation();

        view.findViewById(R.id.buttonDemo).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m_layoutLeftPanel.getVisibility() == View.VISIBLE) {
                    m_layoutLeftPanel.setVisibility(View.INVISIBLE);
                } else {
                    m_layoutLeftPanel.setVisibility(View.VISIBLE);
                }
            }
        });
        view.findViewById(R.id.buttonExtra).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m_layoutRightPanel.getVisibility() == View.VISIBLE) {
                    m_layoutRightPanel.setVisibility(View.INVISIBLE);
                } else {
                    m_layoutRightPanel.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }

    private void updatePageNavigation() {
        if (currentPage == 0) {
            prevPageButton.setEnabled(false);
        } else {
            prevPageButton.setEnabled(true);
        }
        if (currentPage == pages.size() - 1) {
            nextPageButton.setEnabled(false);
        } else {
            nextPageButton.setEnabled(true);
        }
        for (View page : pages) {
            page.setVisibility(View.INVISIBLE);
        }
        pages.get(currentPage).setVisibility(View.VISIBLE);
    }

    @Override
    protected void updateGeneralButton(final Button aButton) {
        final String tag = (String) aButton.getTag();
        if (tag == null) {
            return;
        }
        if (!tag.equals("")) {
            aButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendRobotCommand(tag);
                }
            });
        }
    }

    public void setCommandText(final int id) {
    	if (id == 0)
    	{
    		return;
    	}
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                String str = getResources().getString(id);
                str = str.replace('\n', ' ');
                m_textViewCommands.setText(str);
                m_textViewCommands.resetTextSize();
            }
        });
    }
}