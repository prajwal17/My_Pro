package com.example.prajwal.my_pro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends Activity implements AdapterView.OnItemClickListener{
    ListView l;
    String[] momTitles;
    String[] momDescription;
    //String[] name={"SuryaNamaskar","Paschimothanasana","Dhanurasana","Sarvangasana","Karnapeedasana","Tittibhasana","Hanumasana","Padmabakasana","Vrustikasana",
   //"Poorna Chakrasana","Setubandha sarvangasana","Vrukshasana","Mayurasana","Halasana","Kukkutasana","Sheershasana"};
    int image[]={R.drawable.list};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        l = (ListView) findViewById(R.id.list);
      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        Resources res= getResources();
        momTitles=res.getStringArray(R.array.titles);
        momDescription=res.getStringArray(R.array.description);
        myadapter adapter=new myadapter(this,momTitles,momDescription);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);
        setTitle("Choose your asana");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

        RelativeLayout layout= (RelativeLayout )view;
        TextView t = (TextView)layout.findViewById(R.id.listtext);

        Toast.makeText(this, t.getText(), Toast.LENGTH_SHORT).show();

       // if(i==0)
       // {
        //    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
           // startActivity(intent);
       // }
        Intent intent=new Intent(this,MainActivity3.class);

        intent.putExtra("Name",momTitles[i]);
        intent.putExtra("position",i);
        startActivity(intent);
    }


}
class myadapter extends ArrayAdapter<String>
{
    Context context;
    String[] titleArray;
    String[] description;
    myadapter(Context c,String[] title,String[] desc )
    {
        super(c,R.layout.single_row,R.id.text,title);
        this.context=c;
        this.titleArray=title;
        this.description=desc;
    }
    class myViewHolder
    {
        TextView mytitle;
        TextView mydescription;

        myViewHolder(View v)
        {
            mytitle= (TextView) v.findViewById(R.id.listtext);
            mydescription= (TextView) v.findViewById(R.id.smalltext);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        myViewHolder holder=null;
        if(row==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder=new myViewHolder(row);
            row.setTag(holder);
            Log.d("Prajwal", "new row is created");
        }
        else
        {
            holder= (myViewHolder) row.getTag();
            Log.d("Prajwal","Recycling stuff");
        }
       // holder.myimage.setImageResource(image[position]);
        holder.mytitle.setText(titleArray[position]);
        holder.mydescription.setText(description[position]);
        return row;
    }

}