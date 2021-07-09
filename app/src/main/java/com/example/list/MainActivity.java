package com.example.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            // Restore value of members from saved state
            ArrayList<String> list =new ArrayList<String>();
            list = savedInstanceState.getStringArrayList(lis);

            for(String s:list){
                if(!s.isEmpty()) {
                    LinearLayout linearLayout  = findViewById(R.id.linear);
                    LinearLayout nametag = new LinearLayout(this);
                    nametag.setOrientation(LinearLayout.HORIZONTAL);
                    nametag.setId(View.generateViewId());
                    nametag.setLayoutParams((new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)));
                    ImageButton close = new ImageButton(this);
                    close.setBackground(getDrawable(R.drawable.close));
                    close.setId(View.generateViewId());
                    close.setOnClickListener(this::close);
                    LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(70,70);
                    parms.gravity = parms.rightMargin;
                    parms.setMargins(0,0,40,0);
                    close.setLayoutParams(parms);

                    TextView textView1 = new TextView(this);
                    quantity += 1;

                    nametag.setElevation(4);
                    nametag.setTranslationZ(4);
                    nametag.setBackground(ContextCompat.getDrawable(this,R.drawable.layout));


                    textView1.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
                    textView1.setText(""+ s);
                    total.add(""+ s);
                    textView1.setTextSize(20);
                    textView1.setTextColor(getResources().getColor(R.color.white));


                    textView1.setPadding(20, 0, 0, 0);// in pixels (left, top, right, bottom)
                    nametag.addView(textView1);
                    nametag.addView(close);
                    linearLayout.addView(nametag);
                }

            }



        } else {
            // Probably initialize members with default values for a new instance


        }


    }

    ArrayList<String> total =new ArrayList<String>();
    int quantity;
    int buid;
    public void additem(View view){
        RelativeLayout relativeLayout =  findViewById(R.id.relative);
        LinearLayout linear = new LinearLayout(this);
        ScrollView scroll  = new ScrollView(this);
        EditText edit = new EditText(this);
        Button but = new Button(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        //linear.setBackgroundColor(getResources().getColor(android.R.color.white));
        RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        linear.setPadding(30,30,30,30);
        parms.addRule(RelativeLayout.ABOVE,R.id.material_button);
        scroll.setLayoutParams(parms);
        linear.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT,ScrollView.LayoutParams.WRAP_CONTENT));
        int r =10;
        int b =20;
        scroll.setId(r);

        but.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        but.setText("ADD");



        but.setOnClickListener(this::addlist);
        edit.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));

        edit.setId(b);
        edit.setBackground(ContextCompat.getDrawable(this,R.drawable.layout));

        edit.setTextColor(getResources().getColor(R.color.white));
        edit.setShadowLayer(6,10,10,R.color.black);

        //edit.setTextColor(getResources().getColor(R.color.black));
        linear.addView(edit);
        linear.addView(but);
        relativeLayout.addView(scroll);
        scroll.addView(linear);

    }

    public void addlist(View view){
        RelativeLayout relativeLayout =  findViewById(R.id.relative);
        int r =10;
        int b = 20;
        LinearLayout linearLayout = findViewById(R.id.linear);
        ScrollView name = relativeLayout.findViewById(r);
        
        EditText edit = name.findViewById(b);
        String item = edit.getText().toString();
        relativeLayout.removeView(name);
        String lines[] = item.split("\\r?\\n");
        for(String s: lines){
            if(!s.isEmpty()) {

                LinearLayout nametag = new LinearLayout(this);
                nametag.setOrientation(LinearLayout.HORIZONTAL);
                nametag.setId(View.generateViewId());
                nametag.setElevation(4);

                nametag.setLayoutParams((new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)));
                nametag.setBackgroundColor(Color.parseColor("#212121"));
                ImageButton close = new ImageButton(this);
                close.setBackground(getDrawable(R.drawable.close));
                close.setId(View.generateViewId());
                close.setOnClickListener(this::close);
                LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(70,70);
                //parms.gravity = parms.rightMargin;
                parms.setMargins(0,0,40,0);
                close.setLayoutParams(parms);

                TextView textView1 = new TextView(this);
                quantity += 1;
                nametag.setTranslationZ(4);
                nametag.setTranslationY(4);
                nametag.setTranslationX(4);
                nametag.setBackground(ContextCompat.getDrawable(this,R.drawable.layout));

                textView1.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
                textView1.setText("" + s);
                total.add(""+ s);
                textView1.setTextSize(20);
                textView1.setTextColor(getResources().getColor(R.color.white));
                TypedValue typedValue = new TypedValue();
                //getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK)


                //textView1.setTextColor(getResources().getColor(R.color.design_default_color_on_primary));

                //textView1.setTextColor(getResources().getColor(R.color.));
                textView1.setElevation(5);
                textView1.setPadding(0, 0, 0, 0);// in pixels (left, top, right, bottom)
                nametag.addView(textView1);
                nametag.addView(close);
                linearLayout.addView(nametag);
            }

        }

    }

    private void close(View view){
        LinearLayout linearLayout = findViewById(R.id.linear);
        quantity -= 1;
        ImageButton bu = (ImageButton)view;
        int butid = bu.getId();
        LinearLayout root = (LinearLayout)bu.getParent();
        TextView textview = (TextView)root.getChildAt(0);
        String text = textview.getText().toString();

        for(int i=0;i<total.size();i++){

            if(text.equals(total.get(i))){

                total.remove(i);
            }
        }
        int rootid = root.getId();
        linearLayout.removeView(root);
    }

    static final String lis = "total";






    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putStringArrayList(lis,total);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
}