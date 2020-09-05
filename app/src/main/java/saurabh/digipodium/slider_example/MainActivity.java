package saurabh.digipodium.slider_example;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import saurabh.digipodium.slider_example.fragments.BlueFragment;
import saurabh.digipodium.slider_example.fragments.GreenFragment;
import saurabh.digipodium.slider_example.fragments.RedFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager pager = findViewById(R.id.vpIntro);
        TabLayout tabs = findViewById(R.id.tbIntro);

        DummyAdapter adapter = new DummyAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter
                        .BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        tabs.setupWithViewPager(pager);

        pager.setAdapter(adapter);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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

    // adapter for fragments

    class DummyAdapter extends FragmentStatePagerAdapter {

        public DummyAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior); //skipping extra code
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new BlueFragment();
                case 1:
                    return new GreenFragment();
                case 2:
                    return new RedFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return 3; // giving the number of fragments
        }

        // added this manually using cntrl+ O
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "blue";
                case 1:
                    return "Green";
                case 2:
                    return "red";
            }

            return super.getPageTitle(position);
        }
    }

}