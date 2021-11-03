package com.example.a3_secondphaseofapp.ui.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.example.a3_secondphaseofapp.R;
import com.example.a3_secondphaseofapp.databinding.FragmentWeatherBinding;

public class WeatherFragment extends Fragment {

    private WeatherViewModel WeatherViewModel;
    private FragmentWeatherBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WeatherViewModel =
                new ViewModelProvider(this).get(WeatherViewModel.class);

        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textWeather;
        WeatherViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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

    //region Return to home fragment

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //receive data from fragment 1
        @NonNull WeatherFragmentArgs name = WeatherFragmentArgs.fromBundle(getArguments());
        TextView receivedBornData = view.findViewById(R.id.editTextBornLocation);

        //Button button = view.findViewById(R.id.);

        //NavController navController = Navigation.findNavController(view);
        //NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.navigation_home, true).build();
        // navController.navigate(R.id.action_navigation_weather_to_navigation_home, null, navOptions);

        //endregion
    }

}