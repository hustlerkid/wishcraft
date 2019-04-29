package fiveguys.com.wishcraftapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

public class Feed extends FragmentActivity {

    final HomeFragment homeFragment = new HomeFragment();
    final ItemSearchFragment itemSearchFragment = new ItemSearchFragment();
    final ProfileFragment profileFragment = new ProfileFragment();
    final FriendsFragment friendsFragment = new FriendsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        //initializes bottom navigation menu and its fragments/frames
        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationMenu);
        navigationView.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch(menuItem.getItemId()) {
                case R.id.home:
                    setFragment(homeFragment);
                    return true;
                case R.id.search:
                    setFragment(itemSearchFragment);
                    return true;
                case R.id.profile:
                    setFragment(profileFragment);
                    return true;
                case R.id.friends:
                    setFragment(friendsFragment);
                    return true;
                default:
                    break;
            }
            return false;
        }
    };

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    public void settingsButton(MenuItem item) {
        Intent settingsIntent = new Intent(this, Settings.class);
        startActivity(settingsIntent);
    }
}