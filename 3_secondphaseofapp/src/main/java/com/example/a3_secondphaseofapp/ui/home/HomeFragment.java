package com.example.a3_secondphaseofapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a3_secondphaseofapp.R;
import com.example.a3_secondphaseofapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //region After locations are entered, new fragment will load on button click

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.Send);

        NavController navController = Navigation.findNavController(view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // when user taps on button, take data from edit text and pass to next fragment
                //EditText bornData = view.findViewById(R.id.editTextBornLocation);
                EditText bornData = (EditText) getView().findViewById(R.id.editTextBornLocation);
                int amount = Integer.parseInt(bornData.getText().toString());

                //ConfirmationAction action = speci


                EditText currData = view.findViewById(R.id.editTextCurrentLocation);
                EditText famData = view.findViewById(R.id.editTextFamilyLocation);
                EditText dreamData = view.findViewById(R.id.editTextDreamLocation);

                // create navdirection object
                //NavDirections action =

                navController.navigate(R.id.action_navigation_home_to_weatherFragment); // navigate to next fragment
            }
        });
    //endregion
        //region Use locations inputted to get data from accuweather through API

        final TextView textView = (TextView) getView().findViewById(R.id.text);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "https://developer.accuweather.com/accuweather-locations-api/apis/get/locations/v1/cities/autocomplete?apikey=i6ea0ysImG3m0bT7WGySpmYdXHrqhHgy&q=";
        String query = "";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
//queue.add(stringRequest);

    //endregion


    }



}