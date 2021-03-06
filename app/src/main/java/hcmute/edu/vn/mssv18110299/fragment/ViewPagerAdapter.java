package hcmute.edu.vn.mssv18110299.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new TrackingFragment();
            case 2:
                return new NotificationFragment();
            case 3:
                return new ProfileFragment();
            case 4:
                return new CartFragment();
            default:
                return new StoreFragment();
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
}
