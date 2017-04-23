package com.buddybear;



import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class OneFragment extends Fragment {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/gillsans.ttf");

        TextView  txt1 = (TextView) rootView.findViewById(R.id.txt1);
        TextView  txt2 = (TextView) rootView.findViewById(R.id.txt2);


        txt1.setTypeface(font);
        txt2.setTypeface(font);


        return rootView;
    }

}