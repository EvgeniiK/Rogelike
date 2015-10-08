package com.mugen.rogelike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        String[][] map = createMap(10,10);

        mapUpdate(map,1,1,gridLayout);

       /* TextView player = new TextView(this);
        GridLayout.Spec ox = GridLayout.spec(i,1);
        GridLayout.Spec oy = GridLayout.spec(j,1);
        gridLayout.getViewTreeObserver();*/
        Button up = (Button) findViewById(R.id.buttonUp);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public String[][] createMap(int sizeX, int sizeY){
        String[][] map = new String[sizeX][sizeY];
        for (int i = sizeX; i > 0; i--)
            for (int j = sizeY; j > 0; j--)
                if(i%2!=0) {
                    if(j%2!=0) map[i][j] = "X";
                    else map[i][j] = "Y";}
                else {
                    if(j%2==0) map[i][j] = "X";
                    else map[i][j] = "Y";}


        return map;
    }

    public void mapUpdate(String[][] map, int pointX, int pointY, GridLayout gridLayout) {
        for (int i = 5; i > 0; i--)
            for (int j = 5; j > 0; j--) {
                TextView textView = new TextView(this);
                textView.setText(R.string.UnknownTerra);
                // textView.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
                GridLayout.Spec ox = GridLayout.spec(i, 1);
                GridLayout.Spec oy = GridLayout.spec(j, 1);
                gridLayout.addView(textView, new GridLayout.LayoutParams(ox, oy));
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
