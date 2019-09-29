package application.com.tic_tac_toe;

import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


    TextView title;
    ImageView b11,b12,b13,b21,b22,b23,b31,b32,b33;
    boolean b11status=false,b12status=false,b13status=false,b21status=false,b22status=false,b23status=false,b31status=false,b32status=false,b33status=false;
    int int_counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        callfindViewById();
        callsetOnClickListener();
        setRandomTag();

    }
    void callsetOnClickListener()
    {
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);
        b23.setOnClickListener(this);
        b31.setOnClickListener(this);
        b32.setOnClickListener(this);
        b33.setOnClickListener(this);

    }

    void setRandomTag()
    {
        b11.setTag("1");
        b12.setTag("2");
        b13.setTag("3");
        b21.setTag("4");
        b22.setTag("5");
        b23.setTag("6");
        b31.setTag("7");
        b32.setTag("8");
        b33.setTag("9");

    }

    void callfindViewById()
    {
        title=(TextView)findViewById(R.id.title);
        b11=(ImageView) findViewById(R.id.b11);
        b12=(ImageView) findViewById(R.id.b12);
        b13=(ImageView) findViewById(R.id.b13);
        b21=(ImageView) findViewById(R.id.b21);
        b22=(ImageView) findViewById(R.id.b22);
        b23=(ImageView) findViewById(R.id.b23);
        b31=(ImageView) findViewById(R.id.b31);
        b32=(ImageView) findViewById(R.id.b32);
        b33=(ImageView) findViewById(R.id.b33);
    }

    @Override
    public void onClick(View v) {
        Log.d("onClick called","----------");
        switch(v.getId()) {
            case R.id.b11: {
                if(b11status==false)
                {                     
                    check_b_status(true,b11);
                    b11status=true;
                }
                else
                {
                    check_b_status(false,b11);
                }
                break;
            }
            case R.id.b12: {
                if(b12status==false)
                {
                    check_b_status(true,b12);
                    b12status=true;
                }
                else
                {
                    check_b_status(false,b12);
                }
                break;
            }
            case R.id.b13: {
                if(b13status==false)
                {
                    check_b_status(true,b13);
                    b13status=true;
                }
                else
                {
                    check_b_status(false,b13);
                }
                break;
            }
            case R.id.b21: {
                if(b21status==false)               
                {                     
                    check_b_status(true,b21);
                    b21status=true;
                }
                else
                {
                    check_b_status(false,b21);
                }
                break;
            }
            case R.id.b22: {
                if(b22status==false)
                {
                     
                    check_b_status(true,b22);
                    b22status=true;
                }
                else
                {
                    check_b_status(false,b22);
                }
                break;
            }
            case R.id.b23: {
                if(b23status==false)
                {
                     
                    check_b_status(true,b23);
                    b23status=true;
                }
                else
                {
                    check_b_status(false,b23);
                }
                break;
            }
            case R.id.b31: {
                if(b31status==false)
                {

                    check_b_status(true,b31);
                    b31status=true;
                }
                else
                {
                    check_b_status(false,b31);
                }
                break;
            }
            case R.id.b32: {
                if(b32status==false)
                {

                    check_b_status(true,b32);
                    b32status=true;
                }
                else
                {
                    check_b_status(false,b32);
                }
                break;
            }
            case R.id.b33: {
                if(b33status==false)
                {

                    check_b_status(true,b33);
                    b33status=true;
                }
                else
                {
                    check_b_status(false,b33);
                }
                break;
            }
            default:
                callSnackBar("Fatal error");

        }
    }
    int check_b_status(boolean b_status,ImageView b)
    {
        Log.d("check_b_status called","----------");
        if(b_status)
        {
            int_counter++;
            callSnackBar(""+int_counter);
            if(int_counter%2==0) {
                int id = getResources().getIdentifier("application.com.tic_tac_toe:drawable/o", null, null);
                b.setImageResource(id);
                b.setTag("o");
                Log.d("id="+id+"  getID="+b.getTag(),"-----------------------");
                win_status();
            }
            else if(int_counter%2!=0)
            {
                int id = getResources().getIdentifier("application.com.tic_tac_toe:drawable/x", null, null);
                b.setImageResource(id);
                b.setTag("x");
                Log.d("id="+id+"  getID="+b.getTag(),"-----------------------");
                win_status();
            }


        }
        else
        {
            callSnackBar("Not here buddy!!");
        }
        return  int_counter;
    }
    boolean win_status()

    {
        Log.d("win_status called","----------");
        if(b11.getTag()==b12.getTag()&&b11.getTag()==b13.getTag())
        {

            vanish(b21,b22,b23,b31,b32,b33);
            decalreWinner(""+b11.getTag());
        }
        else if(b21.getTag()==b22.getTag()&&b21.getTag()==b23.getTag())
        {
            vanish(b11,b12,b13,b31,b32,b33);
            decalreWinner(""+b21.getTag());

        }
        else if(b31.getTag()==b32.getTag()&&b31.getTag()==b33.getTag())
        {
            vanish(b21,b22,b23,b11,b12,b13);
            decalreWinner(""+b31.getTag());

        }
        else if(b11.getTag()==b22.getTag()&&b11.getTag()==b33.getTag())
        {
            vanish(b12,b13,b21,b23,b31,b32);
            decalreWinner(""+b11.getTag());

        }
        else if(b13.getTag()==b22.getTag()&&b13.getTag()==b31.getTag())
        {
            vanish(b11,b12,b21,b23,b32,b33);
            decalreWinner(""+b13.getTag());

        }
        else if(b11.getTag()==b21.getTag()&&b11.getTag()==b31.getTag())
        {
            vanish(b12,b22,b32,b13,b23,b33);
            decalreWinner(""+b11.getTag());

        }
        else if(b12.getTag()==b22.getTag()&&b12.getTag()==b32.getTag())
        {
            vanish(b11,b21,b31,b13,b23,b33);
            decalreWinner(""+b12.getTag());

        }
        else if(b13.getTag()==b23.getTag()&&b13.getTag()==b33.getTag())
        {
            vanish(b11,b12,b21,b22,b31,b32);
            decalreWinner(""+b13.getTag());

        }
        else
        {
            if(int_counter>=9) {
                callSnackBar("Oh! It's a draw. Better luck next time.");
                reset();
            }
        }
        return true;
    }

    private void decalreWinner(String tag)
    {
        Log.d("decalreWinner called","----------");

        if(tag.equals("x"))
        {
         callSnackBar("Wow! X WON. ");
         reset();
        }
        else if(tag.equals("o"))
        {
            callSnackBar("Wow! O WON. ");

            reset();

        }
    }

    void reset()
    {
        Log.d("reset called","----------");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // yourMethod();
                finish();
                startActivity(getIntent());
            }
        }, 3000);


        /*
        b11status=false;
        b12status=false;
        b13status=false;
        b21status=false;
        b22status=false;
        b23status=false;
        b31status=false;
        b32status=false;
        b33status=false;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // yourMethod();
            }
        }, 5000);   //5 seconds
        b11.setImageDrawable(null);
        b12.setImageDrawable(null);
        b13.setImageDrawable(null);
        b21.setImageDrawable(null);
        b22.setImageDrawable(null);
        b23.setImageDrawable(null);
        b31.setImageDrawable(null);
        b32.setImageDrawable(null);
        b33.setImageDrawable(null);

        int_counter=0;
        b11.setTag(null);
        b12.setTag(null);
        b13.setTag(null);
        b21.setTag(null);
        b22.setTag(null);
        b23.setTag(null);
        b31.setTag(null);
        b32.setTag(null);
        b33.setTag(null);
*/
    }

    void vanish(ImageView i1,ImageView i2,ImageView i3,ImageView i4,ImageView i5,ImageView i6)
    {
        Log.d("vanish called","----------");
        i1.setImageDrawable(null);
        i2.setImageDrawable(null);
        i3.setImageDrawable(null);
        i4.setImageDrawable(null);
        i5.setImageDrawable(null);
        i6.setImageDrawable(null);
    }

    void callSnackBar(String msg)
    {
        Snackbar.make(findViewById(R.id.RL),msg,Snackbar.LENGTH_SHORT).show();
    }


}


