package com.buddybear;

import android.app.ExpandableListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TodoFirstPage extends  ExpandableListActivity {

    int pos;
    ImageButton setting_btn;
    //Initialize variables
    TextView Tcounter;
    List<String> firstchildren = new ArrayList<String>();
    List<String> firstparent = new ArrayList<String>();
    String checker;
    private static final String STR_CHECKED = " has Checked!";
    private static final String STR_UNCHECKED = " has unChecked!";
    private int ParentClickStatus=-1;
    private int ChildClickStatus=-1;
    private ArrayList<Parent> parents;
    SQLiteDatabase database;
    String sql;
    Cursor c;
    int count =0;
    int limit=7;


    Typeface font;

    List<String> secchildren = new ArrayList<String>();
    List<String> secparent = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_first_page);

       font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");




        setting_btn = (ImageButton) findViewById(R.id.settings_button);


        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(TodoFirstPage.this, setting_page.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });






        SQLiteDatabase  database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        String sqlz = "CREATE TABLE IF NOT EXISTS todoSecondv (Todo VARCHAR ,des VARCHAR  );";
        database.execSQL(sqlz);
        sqlz = "SELECT * from todoSecondv;";
        Cursor cz = database.rawQuery(sqlz, null);



        while (cz.moveToNext()) {


            checker = cz.getString(cz.getColumnIndex("Todo"));




        }
        if (checker != null && !checker.isEmpty()) {
            Intent i=new Intent(this,TodoThirdPage.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();

        }












        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(TodoFirstPage.this);
                LayoutInflater inflater = TodoFirstPage.this.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.customdialog, null);
                dialogBuilder.setView(dialogView);

                final EditText h = (EditText) dialogView.findViewById(R.id.head);
                final EditText d = (EditText) dialogView.findViewById(R.id.des);

                dialogBuilder.setTitle("Lisa endale personaalne eesmärk");

                dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {


                        FirstPageDB(h.getText().toString(), d.getText().toString());
                        Intent intent = getIntent();
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        finish();

                    }
                });
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //pass
                    }
                });
                AlertDialog b = dialogBuilder.create();
                b.show();


            }
        });





        database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        sql = "CREATE TABLE IF NOT EXISTS todofirst (Todo VARCHAR ,des VARCHAR  );";
        database.execSQL(sql);
        String	 sqlx = "SELECT * from todofirst;";
        Cursor c = database.rawQuery(sqlx, null);



        while (c.moveToNext()) {


            String h = c.getString(c.getColumnIndex("Todo"));

            String d = c.getString(c.getColumnIndex("des"));
            firstparent.add(h);
            firstchildren.add( d);


        }



        firstparent.add("Sunscreen");
        firstchildren.add("While many of us remember to bring the sunscreen, often is the case of when we return home that evening, we are surprised that we somehow still have a bit of a sunburn. Make sure you know which SPF suits you.");

        firstparent.add("Blanket");
        firstchildren.add("It is always a good idea I find, to bring a large blanket with you to the beach. That way the beach towels can be used for drying off and you won’t have to worry about wet, sticky sand. Blankets are usually heavier than towels and it will be easier to keep the blanket on the ground rather than blowing down the Grand Strand.");

        firstparent.add("Whistle");
        firstchildren.add("With a record number of people expected to be in Myrtle Beach this year, you can expect a bunch of unattended kids roaming the beaches. A good way to keep track of your children is to bring a whistle. Teach your family the “family whistle” and you’ll be sure to have them back by your side in no time.");

        firstparent.add("First Aid Kit");
        firstchildren.add("It’s always best to keep a little first aid kit either in your car or with you at the beach. You’ll be surprised at how handy that will be.\n");

        firstparent.add("Flip-flops");
        firstchildren.add("Flip-flops are vital for that transition from the hot sand to the not as hot sand as you trek towards that watery abyss. Bring them and you won’t regret it. It’s never fun to remove shoes and then try to put them back on with sandy wet feet.");

        firstparent.add("Binoculars");
        firstchildren.add("Often there are times where you are on the beach looking out toward the ocean and someone asks you “what is that?” pointing to a small blip in the distance. How nice would it be to be able to tell them? Well with a cheap pair of binoculars, you could tell them.");

        firstparent.add("Lots of Water");
        firstchildren.add("The average adult requires 8 full glasses of water each day as recommended by doctors everywhere. This number increases when lying out in the sun. A good tip is to bring a gallon of water and a couple water bottles. That way you can keep one water bottle in the cooler and not have to waste valuable cooler space.");

        Resources res = this.getResources();


        // Set ExpandableListView values



        getExpandableListView().setGroupIndicator(null);


        getExpandableListView().setDivider(null);
        registerForContextMenu(getExpandableListView());

        //Creating static data in arraylist
        final ArrayList<Parent> dummyList = buildDummyData();

        // Adding ArrayList data to ExpandableListView values
        loadHosts(dummyList);
    }
    private ArrayList<Parent> buildDummyData()
    {
        // Creating ArrayList of type parent class to store parent class objects
        final ArrayList<Parent> list = new ArrayList<Parent>();



        for (int i = 0; i < firstparent.size(); i++)
        {
            final Parent parent = new Parent();

            for (int x = 0; x < firstparent.size(); x++) {
                parent.setName("" + firstparent.get(i));
                parent.setText1("" + firstparent.get(i));
                parent.setText2("");
                parent.setChildren(new ArrayList<Child>());

                // Create Child class object
                final Child child = new Child();

                child.setText1(" " + firstchildren.get(i));

                //Add Child class object to parent class object
                parent.getChildren().add(child);
            }
            list.add(parent);
        }

        return list;
    }



    private void loadHosts(final ArrayList<Parent> newParents)
    {
        if (newParents == null)
            return;

        parents = newParents;

        // Check for ExpandableListAdapter object
        if (this.getExpandableListAdapter() == null)
        {
            //Create ExpandableListAdapter Object
            final MyExpandableListAdapter mAdapter = new MyExpandableListAdapter();

            // Set Adapter to ExpandableList Adapter
            this.setListAdapter(mAdapter);
        }
        else
        {
            // Refresh ExpandableListView data
            ((MyExpandableListAdapter)getExpandableListAdapter()).notifyDataSetChanged();
        }
    }

    /**
     * A Custom adapter to create Parent view (Used grouprow.xml) and Child View((Used childrow.xml).
     */
    private class MyExpandableListAdapter extends BaseExpandableListAdapter {


        private LayoutInflater inflater;

        public MyExpandableListAdapter() {
            // Create Layout Inflator
            inflater = LayoutInflater.from(TodoFirstPage.this);
        }


        // This Function used to inflate parent rows view

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parentView) {
            final Parent parent = parents.get(groupPosition);

            // Inflate grouprow.xml file for parent rows
            convertView = inflater.inflate(R.layout.grouprow, parentView, false);

            // Get grouprow.xml file elements and set values
          TextView tv = ((TextView) convertView.findViewById(R.id.boro));
            tv.setText(parent.getText1());
            tv.setTypeface(font);
            ((TextView) convertView.findViewById(R.id.text)).setText(parent.getText2());


            // Get grouprow.xml file checkbox elements
            CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
            checkbox.setChecked(parent.isChecked());
            if (parent.isChecked()) {
                checkbox.setBackgroundResource(R.drawable.listchecked);
            } else {
                checkbox.setBackgroundResource(R.drawable.listuncheck);
            }
            // Set CheckUpdateListener for CheckBox (see below CheckUpdateListener class)
            checkbox.setOnCheckedChangeListener(new CheckUpdateListener(parent));

            return convertView;
        }


        // This Function used to inflate child rows view
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parentView) {
            final Parent parent = parents.get(groupPosition);
            final Child child = parent.getChildren().get(childPosition);

            // Inflate childrow.xml file for child rows
            convertView = inflater.inflate(R.layout.childrow, parentView, false);

            // Get childrow.xml file elements and set values
            TextView tv1 = ((TextView) convertView.findViewById(R.id.choto));
            tv1.setText(child.getText1());
            tv1.setTypeface(font);

            return convertView;
        }


        @Override
        public Object getChild(int groupPosition, int childPosition) {
            //Log.i("Childs", groupPosition+"=  getChild =="+childPosition);
            return parents.get(groupPosition).getChildren().get(childPosition);
        }

        //Call when child row clicked
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            /****** When Child row clicked then this function call *******/

            //Log.i("Noise", "parent == "+groupPosition+"=  child : =="+childPosition);
            if (ChildClickStatus != childPosition) {
                ChildClickStatus = childPosition;


            }

            return childPosition;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            int size = 0;
            if (parents.get(groupPosition).getChildren() != null)
                size = parents.get(groupPosition).getChildren().size();
            return size;
        }


        @Override
        public Object getGroup(int groupPosition) {
            Log.i("Parent", groupPosition + "=  getGroup ");

            return parents.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return parents.size();
        }

        //Call when parent row clicked
        @Override
        public long getGroupId(int groupPosition) {
            Log.i("Parent", groupPosition + "=  getGroupId " + ParentClickStatus);

            if (groupPosition == 2 && ParentClickStatus != groupPosition) {


            }

            ParentClickStatus = groupPosition;
            if (ParentClickStatus == 0)
                ParentClickStatus = -1;

            return groupPosition;
        }

        @Override
        public void notifyDataSetChanged() {
            // Refresh List rows
            super.notifyDataSetChanged();
        }

        @Override
        public boolean isEmpty() {
            return ((parents == null) || parents.isEmpty());
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }


        /*******************
         * Checkbox Checked Change Listener
         ********************/

        private final class CheckUpdateListener implements CompoundButton.OnCheckedChangeListener {
            private final Parent parent;


            private CheckUpdateListener(Parent parent) {
                this.parent = parent;

            }

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("onCheckedChanged", "isChecked: " + isChecked);
                parent.setChecked(isChecked);

                ((MyExpandableListAdapter) getExpandableListAdapter()).notifyDataSetChanged();

                final Boolean checked = parent.isChecked();


                for (int i = 0; i < parents.size(); i++) {
                    if (parent.getName().equalsIgnoreCase(firstparent.get(i))) {
                        pos = i;
                    }

                }

                if (checked) {


                    count++;
                    if (count == limit) {
                           Intent i = new Intent(TodoFirstPage.this, TodoThirdPage.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


                        finish();

                    }
                } else {


                    count--;
                    database = openOrCreateDatabase("Todo", MODE_PRIVATE, null);

                    sql = "CREATE TABLE IF NOT EXISTS todoSecondv (Todo VARCHAR ,des VARCHAR  );";
                    database.execSQL(sql);
                    String sqlx = "SELECT * from todoSecondv;";
                    Cursor cw = database.rawQuery(sqlx, null);


                    while (cw.moveToNext()) {


                        String h = cw.getString(cw.getColumnIndex("Todo"));

                        String d = cw.getString(cw.getColumnIndex("des"));
                        secparent.add(h);
                        secchildren.add(d);


                    }


                    database.execSQL("DROP TABLE IF EXISTS todoSecondv");
                    for (int i = 0; i < secchildren.size(); i++) {

                        if (!secparent.get(i).equalsIgnoreCase(firstparent.get(pos))) {

                        }


                    }


                }


            }




        }
    }

    void FirstPageDB(String todo, String des ){


        database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        sql = "CREATE TABLE IF NOT EXISTS todofirst (Todo VARCHAR ,des VARCHAR  );";
        c = database.rawQuery(sql, null);

        database.execSQL(sql);


        String insertSql = "INSERT INTO todofirst VALUES('"+todo+"','"+des+"' );";
        database.execSQL(insertSql);


        database.close();



    }


    @Override
    public void onBackPressed() {

        Intent setIntent = new Intent(TodoFirstPage.this,NewsFeedFirstPage.class);

        startActivity(setIntent);
    }
}