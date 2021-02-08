package grant.com.pexelapi.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import grant.com.pexelapi.databinding.EntryMainBinding;
import grant.com.pexelapi.utils.Constants;
import grant.com.pexelapi.viewModel.EntryViewModel;
import grant.com.pexelapi.viewModel.MainViewModel;

public class MainEntryActivity extends AppCompatActivity {

    private EntryViewModel viewModel;
    private EntryMainBinding binding;
    private String queryText;
    private int queryNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = EntryMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(EntryViewModel.class);
        setContentView(binding.getRoot());

        binding.regularSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryText = viewModel.setQueryText(binding.editQuery.getText());
                queryNumber = viewModel.setQueryNumber(binding.etNumberOfPictuers.getText());
                goToMainView(queryText, queryNumber);
            }

            private void goToMainView(String queryText, int queryNumber) {

                Intent intent = new Intent(MainEntryActivity.this, MainActivity.class);
                intent.putExtra(Constants.MAIN_ACTIVITY_QUERY, queryText);
                intent.putExtra(Constants.MAIN_ACTIVITY_NUMBER, queryNumber);
                startActivity(intent);
            }
        });
    }
}
