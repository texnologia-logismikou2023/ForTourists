package com.example.fortourists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {

    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient fusedLocationProviderClient;





    RecyclerView recyclerView;
    AttractionsAdapter attractionsAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);

        fusedLocationProviderClient = (FusedLocationProviderClient) LocationServices.getFusedLocationProviderClient(this);

        Dexter.withContext(getApplicationContext()).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).
                //withPermission(Manifest.permission.ACCESS_FINE_LOCATION);
                        withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        getCurrentLocation();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.cancelPermissionRequest();
                    }
                }).check();





        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_attractions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dummy data for demonstration purposes (replace with your data retrieval logic)
        List<Attraction> attractions = getAttractions();

        // Initialize AttractionsAdapter and set it to RecyclerView
        attractionsAdapter = new AttractionsAdapter(attractions, this);
        recyclerView.setAdapter(attractionsAdapter);




    }





    private List<Attraction> getAttractions() {
        List<Attraction> attractions = new ArrayList<>();
            attractions.add(new Attraction("ΔΙ.ΠΑ.Ε. Σερρών", "Ιδρύθηκε το 2005 και άρχισε να λειτουργεί το 2008.", 41.07510320962552, 23.55365103727739));
        attractions.add(new Attraction("Αυτοκινητοδρόμιο Σερρών", "Πίστα αγώνων αυτοκινήτων.", 41.07273866445464, 23.518218368797775));
        attractions.add(new Attraction("Ζιντζιρλί Τζαμί", "Μεσαίου μεγέθους, περιλαμβάνει τετράγωνο χώρο προσευχής με διώροφη στοά με κιονοστοιχία", 41.088289765940125, 23.55376149723361));
        attractions.add(new Attraction("Λαογραφικό Μουσείο Σαρακατσάνων", "Μουσείο για την ιστορία και τον πολιτισμό των Σαρακατσάνων.", 41.09437312336059, 23.555243797997516));
        attractions.add(new Attraction("Παλαιά Μητρόπολη Σερρών", "Βυζαντινός χριστιανικός ναός.", 41.09444428641045, 23.55394552607018));
        attractions.add(new Attraction("Λαογραφικό Μουσείο Βλάχων", "Μουσείο για την ιστορία και τον πολιτισμό των Βλάχων.", 41.09132004347515, 23.542257730408643));
        attractions.add(new Attraction("Κοιλάδα Αγίων Αναργύρων", "Description", 41.104218519325904, 23.55200507125519));
        attractions.add(new Attraction("Μουσείο Φυσικής Ιστορίας", "Ενημέρωση του επισκέπτη για το φυσικό περιβάλλον του τόπου μας.", 41.100335766847806, 23.56986527381822));
        attractions.add(new Attraction("Κοτζά Μουσταφά Πασά Τζαμί", "Τζαμί με τη κατάκτηση των Οθομανών το 1383.", 41.086394590557255, 23.53459225449863));
        attractions.add(new Attraction("Βυζαντινή Ακρόπολη Σερρών", "Πάνω σε λόφο γνωστό ως Κουλάς, βρίσκεται η αρχαία ακρόπολη.", 41.09723837669804, 23.551047820741562));
        attractions.add(new Attraction("Μπεζεστένι", "Το Μπεζεστένι ήταν ένας πολύ σημαντικός θεσμός των οθωμανικών πόλεων.", 41.09093358537034, 23.549356267992994));
        attractions.add(new Attraction("Τέμενος Αχμέτ Πασά Τζαμί", "Ένα από τα σημαντικότερα κτίρια οθωμανικής αρχιτεκτονικής στην περιοχή.", 41.09167393281643, 23.559411979640146));
        attractions.add(new Attraction("ΔΗ.ΠΕ.ΘΕ. Σερρών", "Ένα από τα πρώτα ΔΗ.ΠΕ.ΘΕ. που δημιουργήθηκαν από το Υπουργείο Πολιτισμού.", 41.08894608215148, 23.54933113915748));
        attractions.add(new Attraction("Ιερός Βυζαντινός Ναός Αγίου Γεωργίου Κρυονερίτου", "Η ονομασία του οφείλεται σε πηγή κρύου νερού, η οποία βρισκόταν σε κοντινή απόσταση.", 41.09641683286726, 23.56648293079135));
        attractions.add(new Attraction("Κειμηλιαρχείο 'Ψυχῆς Ἄκος΄", "Κεντρο μείζονος σημασίας για τήν εκκλησιαστική, πνευματική και τοπική καλλιτεχνική δημιουργία.", 41.09512194520564, 23.552363129180897));
        // Add more attractions as needed
        return attractions;
    }






    public void getCurrentLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        if(location != null){
                            LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
                            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Current Location !");
                            googleMap.addMarker(markerOptions);
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));




                            //recent-changes
                            List<Attraction> attractions = getAttractions();
                            for (Attraction attraction : attractions) {
                                LatLng attractionLocation = new LatLng(attraction.getLatitude(), attraction.getLongitude());

                                MarkerOptions attractionMarker = new MarkerOptions()
                                        .position(attractionLocation)
                                        .title(attraction.getName())
                                        .snippet(attraction.getDescription())
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

                                googleMap.addMarker(attractionMarker);
                            }



                        }




                        else {
                            Toast.makeText(MainActivity.this, "Please on your Location App Permissions", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}