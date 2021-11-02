package com.example.a3_secondphaseofapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.a3_secondphaseofapp.R;
import com.example.a3_secondphaseofapp.databinding.FragmentHomeBinding;
import android.view.View; // imports View class
import android.content.Intent; // imports Intent class
import android.widget.EditText; // imports EditText class

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

    public void OnLocationCreate(View view) {
        /*Intent displayIntent = new Intent(this, DisplayMessageActivity.class); // intent to jump to DisplayMessageActivity

        EditText firstText = (EditText) findViewById(R.id.editTextPersonFirstName); // data received from user
        EditText lastText = (EditText) findViewById(R.id.editTextPersonLastName); // data received from user

        String firstMessage = firstText.getText().toString(); // convert to string type
        String lastMessage = lastText.getText().toString();

        Bundle bridge = new Bundle();

        // bridge data from main activity to next activity
        bridge.putString("fName", firstMessage); // first parameter fName is used to pass the contents
        bridge.putString("lName", lastMessage); // to the next activity

        displayIntent.putExtras(bridge); // pass bundle as a param

        startActivity(displayIntent);
*/
    }
}

