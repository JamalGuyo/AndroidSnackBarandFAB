package com.example.root.a201snack;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private CoordinatorLayout rootLayout;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.myRootLayout);
        floatingActionButton = findViewById(R.id.floatingId);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootLayout, "simple snackbar example", Snackbar.LENGTH_SHORT).show();
            }
        });


        mToolBar = findViewById(R.id.myTool);


        mToolBar.setTitle("BasicComponent");
        mToolBar.inflateMenu(R.menu.menu);
        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                switch (id){
                    case R.id.simplesnack:
                        showSimpleSnackBar();
                        break;
                    case R.id.customsnack:
                        showSnackBarWithActionCallBack();
                        break;
                    case R.id.optionssnack:
                        showSnackBarWithColoredText();
                        break;
                }
                return true;
            }
        });
    }

    public void showSimpleSnackBar(){
        Snackbar.make(rootLayout, "simple snackBar Example",Snackbar.LENGTH_SHORT).show();
    }
    public void showSnackBarWithActionCallBack(){

        final Snackbar snackbar = Snackbar.make(rootLayout, "File deleted", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootLayout,"File recovered successfully",Snackbar.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }

    public void showSnackBarWithColoredText(){

    }
}
