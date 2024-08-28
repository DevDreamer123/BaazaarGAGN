package com.example.neerajinnostore.home;
import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.neerajinnostore.AccountActivity;
import com.example.neerajinnostore.AppLocationService;
import com.example.neerajinnostore.CategoryAdapter;
import com.example.neerajinnostore.CategoryModel;
import com.example.neerajinnostore.CategorySecondAdapter;
import com.example.neerajinnostore.GridAdapter;
import com.example.neerajinnostore.ItemModel;
import com.example.neerajinnostore.LocationAddress;
import com.example.neerajinnostore.LocationTrack;
import com.example.neerajinnostore.MainActivity;
import com.example.neerajinnostore.ProductGridReAdapter;
import com.example.neerajinnostore.R;
import com.example.neerajinnostore.RecyclerAdapter;
import com.example.neerajinnostore.RecyclerModel;
import com.example.neerajinnostore.SearchLocation;
import com.example.neerajinnostore.SearchProductActivity;
import com.example.neerajinnostore.Utils.ItemListProductAdapter;
import com.example.neerajinnostore.Utils.ItemProductModel;
import com.example.neerajinnostore.Utils.ProductCategoryModel;
import com.example.neerajinnostore.Utils.ProductModel;
import com.example.neerajinnostore.Utils.RetrofitInstance;
import com.example.neerajinnostore.Utils.StoreModel;
import com.example.neerajinnostore.account.StoreFragment;
import com.example.neerajinnostore.category.CategoryFragment;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    ImageView profile;
    CardView storedetail;
    Dialog mDialog;
 TextView location_name;
    ImageSlider slider;
    ImageView search;
    RecyclerView grid,grid_pharmacy,grid_kitchen,recyclerview_pure_item,recyclerview_you_bought,recyclerview_daily_essentials,recyclerview_spredable_goodness;
    RecyclerView category_show;
    RecyclerView storere;
    LinearLayout morebtn;
    String[] web = {
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure"

    } ;
    int[] imageId = {
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure


    };
    public static final String TAG_IMAGE_URL = "Image";
    public static final String TAG_NAME = "Name";
    TextView click_more;
    private ArrayList permissionsToRequest;
    private ArrayList permissionsRejected = new ArrayList();
    private ArrayList permissions = new ArrayList();

    private final static int ALL_PERMISSIONS_RESULT = 101;
    LocationTrack locationTrack;
    TextView location;
    Button btnGPSShowLocation;
    Button btnShowAddress;
    TextView tvAddress;

    AppLocationService appLocationService;


    RecyclerView recycler_categories,recycler_product;
    TextView seeall;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_product =view.findViewById(R.id.recycler_product);
        RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
        recycler_categories =  view.findViewById(R.id.recycler_categories);


        try {
            Call<List<ProductCategoryModel>> call = RetrofitInstance.getInstance().getMyApi().getCategory();
            call.enqueue(new Callback<List<ProductCategoryModel>>() {
                @Override
                public void onResponse(Call<List<ProductCategoryModel>> call, Response<List<ProductCategoryModel>> response) {
                    //  Toast.makeText(CategoryActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    List<ProductCategoryModel> brandModels = response.body();
                    recycler_categories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
                    CategoryAdapter cate = new CategoryAdapter(getContext(),brandModels);
                    recycler_categories.setAdapter(cate);

                }

                @Override
                public void onFailure(Call<List<ProductCategoryModel>> call, Throwable t) {
                    Toast.makeText(getContext(),t.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());

                    t.toString();
                }
            });
            //Product
            Call<List<ProductModel>> callP = RetrofitInstance.getInstance().getMyApi().getProduct();
            callP.enqueue(new Callback<List<ProductModel>>() {
                @Override
                public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                    //  Toast.makeText(CategoryActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    List<ProductModel> brandModels = response.body();
                    recycler_product.setLayoutManager(new GridLayoutManager(getContext(),2));
                    ProductGridReAdapter category = new ProductGridReAdapter(getContext(),brandModels);
                    recycler_product.setAdapter(category);

                }

                @Override
                public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                    Toast.makeText(getContext(),t.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());

                    t.toString();
                }
            });








        } catch (Exception e) {
            Toast.makeText(getContext(),e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            Log.d("error1",e.getMessage());
            e.getMessage();
        }










       /* ArrayList<ProductModel> ModelArrayList = new ArrayList<ProductModel>();
        ModelArrayList.add(new ProductModel("","Whole Foods Store",R.drawable.lamp,"1200.00 "));
        ModelArrayList.add(new ProductModel("","Gift Giver", R.drawable.watch,"1200.00 "));
        ModelArrayList.add(new ProductModel("","The Sugar Rush", R.drawable.chair,"1200.00 "));
        ModelArrayList.add(new ProductModel("","SR Restaurant", R.drawable.lamp,"1200.00 "));
        ModelArrayList.add(new ProductModel("","Absolute Power Electric", R.drawable.chair,"1200.00 "));
        ModelArrayList.add(new ProductModel("","The Classic Cut", R.drawable.watch,"1200.00 "));*/



       /* seeall = view.findViewById(R.id.seeall);
        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                Fragment fragment = new CategoryFragment();
                FragmentTransaction mFragmentTransaction = ((MainActivity) getContext()).getSupportFragmentManager().beginTransaction();

                mFragmentTransaction.replace(R.id.container, new CategoryFragment()).addToBackStack("").commit();
            }
        });*/
        //Category Image Show in Recyclerview







        /*List<CategoryModel> models = getModelList();
        recycler_categories.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        CategoryAdapter categoryAdapteradapter = new CategoryAdapter(getContext(),models,this);
        recycler_categories.setAdapter(categoryAdapteradapter);*/

        location = view.findViewById(R.id.location);

        permissions.add(ACCESS_FINE_LOCATION);
        permissions.add(ACCESS_COARSE_LOCATION);

        permissionsToRequest = findUnAskedPermissions(permissions);
        //get the permissions we have asked for before but are not granted..
        //we will store this in a global list to access later.


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            if (permissionsToRequest.size() > 0)
                requestPermissions((String[]) permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
        }


        Button btn = (Button) view.findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                locationTrack = new LocationTrack(getContext());


                if (locationTrack.canGetLocation()) {


                    double longitude = locationTrack.getLongitude();
                    double latitude = locationTrack.getLatitude();
                    Toast.makeText(getContext().getApplicationContext(), "Longitude:" + Double.toString(longitude) + "\nLatitude:" + Double.toString(latitude), Toast.LENGTH_LONG).show();
                    location.setText("Longitude"+longitude+"Latitude"+latitude);
                } else {

                    locationTrack.showSettingsAlert();
                }

            }
        });
      /*  morebtn = view.findViewById(R.id.more_btn);
        morebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                Fragment fragment = new CategoryFragment();
                FragmentTransaction mFragmentTransaction = ((MainActivity) getContext()).getSupportFragmentManager().beginTransaction();

                mFragmentTransaction.replace(R.id.container, new CategoryFragment()).addToBackStack("").commit();
            }
        });*/
     /*   ArrayList<RecyclerModel> courseModelArrayList = new ArrayList<RecyclerModel>();
        courseModelArrayList.add(new RecyclerModel("Whole Foods Store",R.drawable.store3,"(Grocery Store) "));
        courseModelArrayList.add(new RecyclerModel("Gift Giver", R.drawable.store7,"(Gift Shop)"));
        courseModelArrayList.add(new RecyclerModel("The Sugar Rush", R.drawable.store8,"(Sweet Shop)"));
        courseModelArrayList.add(new RecyclerModel("SR Restaurant", R.drawable.store3,"(Restaurant)"));
        courseModelArrayList.add(new RecyclerModel("Absolute Power Electric", R.drawable.store7,"(electronic and Electrical  Store) "));
        courseModelArrayList.add(new RecyclerModel("The Classic Cut", R.drawable.store8,"(Barber shop)"));
        courseModelArrayList.add(new RecyclerModel("Hearty Mart", R.drawable.store3,"(Medical Shop)"));*/

        storere = (RecyclerView) view.findViewById(R.id.storere);
        RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
        try {
            Call<List<StoreModel>> call = RetrofitInstance.getInstance().getMyApi().getStore();
            call.enqueue(new Callback<List<StoreModel>>() {
                @Override
                public void onResponse(Call<List<StoreModel>> call, Response<List<StoreModel>> response) {
                    //  Toast.makeText(CategoryActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    List<StoreModel> brandModels = response.body();
                    storere.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
                    RecyclerAdapter cate = new RecyclerAdapter(getContext(),brandModels);
                    storere.setAdapter(cate);

                }

                @Override
                public void onFailure(Call<List<StoreModel>> call, Throwable t) {
                    Toast.makeText(getContext(),t.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());

                    t.toString();
                }
            });

        } catch (Exception e) {
            Toast.makeText(getContext(),e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            Log.d("error1",e.getMessage());
            e.getMessage();
        }





        grid = view.findViewById(R.id.grid);
        ArrayList<ItemModel> courseModelArrayList = new ArrayList<ItemModel>();
        courseModelArrayList.add(new ItemModel("LAKME",R.drawable.lakme));
        courseModelArrayList.add(new ItemModel("JONES", R.drawable.jones));
        courseModelArrayList.add(new ItemModel("LAKME", R.drawable.lakme));
        courseModelArrayList.add(new ItemModel("LAKME", R.drawable.lakme));
        courseModelArrayList.add(new ItemModel("LAKME", R.drawable.lakme));
        courseModelArrayList.add(new ItemModel("LAKME", R.drawable.lakme));
        courseModelArrayList.add(new ItemModel("JONES", R.drawable.jones));
        courseModelArrayList.add(new ItemModel("LAKME", R.drawable.lakme));
        courseModelArrayList.add(new ItemModel("JONES", R.drawable.jones));

        GridAdapter adapter = new GridAdapter(getContext(),courseModelArrayList);
        grid.setLayoutManager(new GridLayoutManager(getContext(),3));

        grid.setAdapter(adapter);

        grid_kitchen = view.findViewById(R.id.grid_kitchen);
        ArrayList<ItemModel> kitchen = new ArrayList<ItemModel>();
        kitchen.add(new ItemModel("Launch Box",R.drawable.box));
        kitchen.add(new ItemModel("Mixer", R.drawable.mixure));
        kitchen.add(new ItemModel("Induction", R.drawable.induction));
        kitchen.add(new ItemModel("Mixer", R.drawable.mixure));
        kitchen.add(new ItemModel("Launch Box", R.drawable.box));
        kitchen.add(new ItemModel("Mixer", R.drawable.mixure));
        kitchen.add(new ItemModel("Chopper", R.drawable.chopper));
        kitchen.add(new ItemModel("Launch Box", R.drawable.box));
        kitchen.add(new ItemModel("Mixer", R.drawable.mixure));

        GridAdapter adapterk = new GridAdapter(getContext(),kitchen);
        grid_kitchen.setLayoutManager(new GridLayoutManager(getContext(),3));

        grid_kitchen.setAdapter(adapterk);

        grid_pharmacy = view.findViewById(R.id.grid_pharmacy);
        ArrayList<ItemModel> pharmacy = new ArrayList<ItemModel>();
        pharmacy.add(new ItemModel("CleanseMe",R.drawable.cleanseme));
        pharmacy.add(new ItemModel("Cruel", R.drawable.cruel));
        pharmacy.add(new ItemModel("Cetyl", R.drawable.cetyl));
        pharmacy.add(new ItemModel("CleanseMe", R.drawable.cleanseme));
        pharmacy.add(new ItemModel("Cruel", R.drawable.cruel));
        pharmacy.add(new ItemModel("CleanseMe", R.drawable.cleanseme));
        pharmacy.add(new ItemModel("Cruel", R.drawable.cruel));
        pharmacy.add(new ItemModel("CleanseMe", R.drawable.cleanseme));
        pharmacy.add(new ItemModel("Cetyl", R.drawable.cetyl));

        GridAdapter adapterp = new GridAdapter(getContext(),pharmacy);
        grid_pharmacy.setLayoutManager(new GridLayoutManager(getContext(),3));

        grid_pharmacy.setAdapter(adapterp);
      /*  grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getContext(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });*/


      //  search = view.findViewById(R.id.sear);
      //  search.setOnClickListener(new View.OnClickListener() {
       //     @Override
      //      public void onClick(View view) {
       //         Intent i = new Intent(getContext(), SearchProductActivity.class);
       //         startActivity(i);
       //     }
     //  });



        slider = view.findViewById(R.id.image1_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();// Create image list

        imageList.add(new SlideModel(R.drawable.bazaarslider1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.bazaarslider2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.bazaarslider3, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.bazaarslider4, ScaleTypes.FIT));
        slider.setImageList(imageList);




        location_name = view.findViewById(R.id.location_name);


        //storedetail = view.findViewById(R.id.storedetail);
       // storedetail.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
         //       Intent i = new Intent(getContext(), StoreDetailActivity.class);
         //       startActivity(i);
        //    }
      //  });
        profile = view.findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AccountActivity.class);
                startActivity(i);
            }
        });
        location_name = view.findViewById(R.id.location_name);
        location_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), SearchLocation.class);
                startActivity(i);


             //   switch (view.getId()) {
             //       case R.id.location:
             //           alertDialog();
            //            break;
             //   }
            }
        });
      /*  click_more = view.findViewById(R.id.click);
        click_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.container, new CategoryFragment()).addToBackStack("").commit();
            }
        });*/
//Category Image in GridView
      //  List<CategoryModel> mode = getModelList();
        RecyclerView recyclerView = view.findViewById(R.id.category_show);

        RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
        try {
            Call<List<ProductCategoryModel>> call = RetrofitInstance.getInstance().getMyApi().getCategory();
            call.enqueue(new Callback<List<ProductCategoryModel>>() {
                @Override
                public void onResponse(Call<List<ProductCategoryModel>> call, Response<List<ProductCategoryModel>> response) {
                    //  Toast.makeText(CategoryActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    List<ProductCategoryModel> brandModels = response.body();
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
                    CategorySecondAdapter categoryadapter = new CategorySecondAdapter(brandModels,getContext());
                    recyclerView.setAdapter(categoryadapter);


                }

                @Override
                public void onFailure(Call<List<ProductCategoryModel>> call, Throwable t) {
                    Toast.makeText(getContext(),t.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());

                    t.toString();
                }
            });

        } catch (Exception e) {
            Toast.makeText(getContext(),e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            Log.d("error1",e.getMessage());
            e.getMessage();
        }



       // recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
       // CategorySecondAdapter categoryadapter = new CategorySecondAdapter(getContext(),mode);
       // recyclerView.setAdapter(categoryadapter);






        btnShowAddress = (Button) view.findViewById(R.id.btnShowAddress);
        btnShowAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Location location = appLocationService
                        .getLocation(LocationManager.GPS_PROVIDER);

                //you can hard-code the lat & long if you have issues with getting it
                //remove the below if-condition and use the following couple of lines
                //double latitude = 37.422005;
                //double longitude = -122.084095

                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getContext().getApplicationContext(), new GeocoderHandler());
                } else {
                    showSettingsAlert();
                }

            }
        });
        tvAddress = (TextView) view.findViewById(R.id.tvAddress);
        appLocationService = new AppLocationService(
                getContext());

        btnGPSShowLocation = (Button) view.findViewById(R.id.btnGPSShowLocation);
        btnGPSShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Location gpsLocation = appLocationService
                        .getLocation(LocationManager.GPS_PROVIDER);
                if (gpsLocation != null) {
                    double latitude = gpsLocation.getLatitude();
                    double longitude = gpsLocation.getLongitude();
                    String result = "Latitude: " + gpsLocation.getLatitude() +
                            " Longitude: " + gpsLocation.getLongitude();
                    tvAddress.setText(result);
                } else {
                    showSettingsAlert();
                }
            }
        });
        tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), SearchLocation.class);
                startActivity(i);


                //   switch (view.getId()) {
                //       case R.id.location:
                //           alertDialog();
                //            break;
                //   }
            }
        });


        Location location = appLocationService
                .getLocation(LocationManager.GPS_PROVIDER);

        //you can hard-code the lat & long if you have issues with getting it
        //remove the below if-condition and use the following couple of lines
        //double latitude = 37.422005;
        //double longitude = -122.084095

        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            LocationAddress locationAddress = new LocationAddress();
            locationAddress.getAddressFromLocation(latitude, longitude,
                    getContext().getApplicationContext(), new GeocoderHandler());
        } else {
            showSettingsAlert();
        }
        recyclerview_pure_item = view.findViewById(R.id.recyclerview_pure_item);

        ArrayList<ItemProductModel> itemModels = new ArrayList<ItemProductModel>();
        itemModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        itemModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        itemModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        itemModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        itemModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        itemModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        itemModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        itemModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        itemModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));

        ItemListProductAdapter itemAdapter = new ItemListProductAdapter(getContext(),itemModels);
        recyclerview_pure_item.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerview_pure_item.setAdapter(itemAdapter);

        recyclerview_you_bought = view.findViewById(R.id.recyclerview_you_bought);

        ArrayList<ItemProductModel> boughtModels = new ArrayList<ItemProductModel>();
        boughtModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        boughtModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        boughtModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        boughtModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        boughtModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        boughtModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        boughtModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        boughtModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        boughtModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));

        ItemListProductAdapter boughtAdapter = new ItemListProductAdapter(getContext(),boughtModels);
        recyclerview_you_bought.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerview_you_bought.setAdapter(boughtAdapter);

        recyclerview_spredable_goodness = view.findViewById(R.id.recyclerview_spreadable_goodness);

        ArrayList<ItemProductModel> spreadableModels = new ArrayList<ItemProductModel>();
        spreadableModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        spreadableModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        spreadableModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        spreadableModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        spreadableModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        spreadableModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        spreadableModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        spreadableModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        spreadableModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));

        ItemListProductAdapter spreadableAdapter = new ItemListProductAdapter(getContext(),spreadableModels);
        recyclerview_spredable_goodness.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerview_spredable_goodness.setAdapter(spreadableAdapter);

        recyclerview_daily_essentials = view.findViewById(R.id.recyclerview_daily_essentials);

        ArrayList<ItemProductModel> essentialsModels = new ArrayList<ItemProductModel>();
        essentialsModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        essentialsModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        essentialsModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        essentialsModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        essentialsModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        essentialsModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        essentialsModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        essentialsModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));
        essentialsModels.add(new ItemProductModel("Kurkure","Excepteur sint occaecat cupidatat non proident","25gm","₹50",R.drawable.kurkure));

        ItemListProductAdapter essentialAdapter = new ItemListProductAdapter(getContext(),essentialsModels);
        recyclerview_daily_essentials.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerview_daily_essentials.setAdapter(essentialAdapter);

        return view;

    }
    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                getContext());
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        getContext().startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            tvAddress.setText(locationAddress);
        }

    }

    private ArrayList findUnAskedPermissions(ArrayList wanted) {
        ArrayList result = new ArrayList();

        for (Object perm : wanted) {
            if (!hasPermission( perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(Object permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission((String)permission) == PermissionChecker.PERMISSION_DENIED);
            }
        }
        return true;
    }

    private int checkSelfPermission(String permission) {
        return 0;
    }

    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {

            case ALL_PERMISSIONS_RESULT:
                for (Object perms : permissionsToRequest) {
                    if (!hasPermission( perms)) {
                        permissionsRejected.add(perms);
                    }
                }

                if (permissionsRejected.size() > 0) {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale((String) permissionsRejected.get(0))) {
                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions((String[]) permissionsRejected.toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
                                            }
                                        }
                                    });
                            return;
                        }
                    }

                }

                break;
        }

    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(getContext())
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //locationTrack.stopListener();
    }
    private List<CategoryModel> getModelList(){
        InputStream is = getResources().openRawResource(R.raw.category);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            int n;
            while (( n = reader.read(buffer))!= -1){
                writer.write(buffer,0,n);
            }

        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();

        }
        String jsonstr = writer.toString();
        Gson gson = new Gson();
        CategoryModel[] itemModels= gson.fromJson(jsonstr,CategoryModel[].class);
        List<CategoryModel> list = Arrays.asList(itemModels);
        return list;

    }


}
  //  private void alertDialog() {
   //     AlertDialog.Builder dialog=new AlertDialog.Builder(getView().getContext());
   //     dialog.setMessage("Please Select any option");
    //    dialog.setTitle("Dialog Box");
     //   dialog.setPositiveButton("YES",
    //            new DialogInterface.OnClickListener() {
     //               public void onClick(DialogInterface dialog,
     //                                   int which) {
    //                    Toast.makeText(getContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
   //                 }
  //              });
 //       dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
  //          @Override
 //           public void onClick(DialogInterface dialog, int which) {
  //              Toast.makeText(getContext(),"cancel is clicked",Toast.LENGTH_LONG).show();
  //          }
  //      });
  //      AlertDialog alertDialog=dialog.create();
   //     alertDialog.show();
   // }
