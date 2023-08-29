package gouvea.lopes.mariana.galeriapublica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;
import android.Manifest;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);

        bottomNavigationView = findViewById(R.id.btNav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                vm.setNavigationOpSelected(item.getItemId());
                switch (item.getItemId()) {
                    case R.id.gridViewOp:
                        GridViewFragment gridViewFragment = GridViewFragment.newInstance();
                        setFragment(gridViewFragment);
                        break;
                    case R.id.listViewOp:
                        ListViewFragment listViewFragment = ListViewFragment.newInstance();
                        setFragment(listViewFragment);
                        break;
                }
                return true;
            }
        });
    }

    void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        checkForPermissions(permissions);
    }

    private void checkForPermissions(List<String> permissions) {
        List<String> permissionsNotGranted = new ArrayList<>();

        for(String permission : permissions) {
            if( !hasPermission(permission)) {
                permissionsNotGranted.add(permission);
                }
            }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(permissionsNotGranted.size() > 0) {
                requestPermissions(permissionsNotGranted.toArray(new
                        String[permissionsNotGranted.size()]),RESULT_REQUEST_PERMISSION);
                }
            else {
                MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);
                int navigationOpSelected = vm.getNavigationOpSelected();
                bottomNavigationView.setSelectedItemId(navigationOpSelected);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
    String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            final List<String> permissionsRejected = new ArrayList<>();
            if(requestCode == RESULT_REQUEST_PERMISSION) {
                for(String permission : permissions) {
                    if(!hasPermission(permission)) {
                        permissionsRejected.add(permission);
                    }
                }
            }

        if(permissionsRejected.size() > 0) {
            47. if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                48.
                if(shouldShowRequestPermissionRationale(permissionsRejected.get(0)))
                {
                    49. new AlertDialog.Builder(MainActivity.this).
                    50. setMessage("Para usar essa app é preciso
                        conceder essas permissões").
                    51. setPositiveButton("OK", new
                        DialogInterface.OnClickListener() {
52. @Override
53. public void onClick(DialogInterface
                                dialog, int which) {
                                54.
                                requestPermissions(permissionsRejected.toArray(new
                                        String[permissionsRejected.size()]), RESULT_REQUEST_PERMISSION);
                                55. }
56. }).create().show();
        31. else {
            32. MainViewModel vm = new
                    ViewModelProvider(this).get(MainViewModel.class);
            33. int navigationOpSelected = vm.getNavigationOpSelected();
            34. bottomNavigationView.setSelectedItemId(navigationOpSelected);
            35. }
        36.}

}