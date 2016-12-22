package sanjeev.trial.com.flames;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    char a[],b[],c[]={'x','F','L','A','M','E','S'};
    int l1,l2,l3,ctr=0,f;
    void mark(int s,char m)
    {
        for(int k=0;k!=l2;k++)
        {
            if(b[k]==m)
            {
                b[k]='x';
                a[s]='x';
                return;
            }
            if((m==' ')||(m=='.'))
                a[s]='x';
            if((b[k]==' ')||(b[k]=='.'))
                b[k]='x';
        }
    }

    void ret()
    { //Place ptr in initial
        for(int k=1;k!=l3;k++)
        {
            if(c[k]!='x')
            {
                f=k;
                return;
            }
        }
    }
    void nret(int y)
    {      //Place next
        int hb;
        hb=y+1;
        while(true)
        {
            if(hb>6)
                hb=1;
            if(c[hb]!='x')
            {
                f=hb;
                return;
            }
            hb++;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button B=(Button)findViewById(R.id.button);
        final TextView TV= (TextView)findViewById(R.id.textView);
        final EditText ed1=(EditText)findViewById(R.id.Field1);
        final EditText ed2=(EditText)findViewById(R.id.Field2);
        final ImageView IV=(ImageView)findViewById(R.id.imageView);

        B.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainActivity ob=new MainActivity();

                String person1 =ed1.getText().toString();
                String person2 =ed2.getText().toString();

                ob.a=person1.toCharArray();
                ob.l1=person1.length();
                ob.b=person2.toCharArray();
                ob.l2=person2.length();

                ob.l3=7;
                for(int i=0;i!=ob.l1;i++)
                    ob.mark(i,ob.a[i]);

                for(int i=0;i!=ob.l1;i++)
                    if(ob.a[i]!='x')
                        ob.ctr++;
                for(int i=0;i!=ob.l2;i++)
                    if(ob.b[i]!='x')
                        ob.ctr++;

                ob.ret();
                for(int i=1;i<=5;i++)
                {
                    int g=1,d;
                    for(d=1;g<ob.ctr;d++)
                    {
                        if(d>6)
                            d=1;
                        if(ob.c[d]!='x')
                        {
                            ob.nret(ob.f);//place f=in next count
                            g++;
                            if(ob.f>6)
                                ob.ret();
                        }
                    }
                    ob.c[ob.f]='x';
                    ob.nret(ob.f);
                }

                char lo='F';
                for(int j=1;j!=ob.l3;j++)
                    if(ob.c[j]!='x')
                        lo=ob.c[j];
                switch(lo)
                {
                    case 'F':TV.setText("FRIEND");
                        IV.setImageResource(R.drawable.smiley);
                        break;
                    case 'L':TV.setText("LOVE");
                        IV.setImageResource(R.drawable.love_arrow);
                        break;
                    case 'A':TV.setText("AFFECTION");
                        IV.setImageResource(R.drawable.one_eye);
                        break;
                    case 'M':TV.setText("MARRIAGE");
                        IV.setImageResource(R.drawable.eye_heart);
                        break;
                    case 'E':TV.setText("ENEMY");
                        IV.setImageResource(R.drawable.lol);
                        break;
                    case 'S':TV.setText("SISTER");
                        IV.setImageResource(R.drawable.green_heart);
                        break;
                }

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Good Luck\nsanjeevitcit@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
