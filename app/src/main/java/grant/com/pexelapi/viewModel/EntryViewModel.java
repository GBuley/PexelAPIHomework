package grant.com.pexelapi.viewModel;

import android.content.Intent;
import android.text.Editable;

import androidx.lifecycle.ViewModel;

import grant.com.pexelapi.utils.Constants;
import grant.com.pexelapi.view.MainActivity;
import grant.com.pexelapi.view.MainEntryActivity;

public class EntryViewModel extends ViewModel {

    public String setQueryText(Editable text) {
        if(text==null || text.toString().equals("")){
            return "Ocean";
        }else {
            return text.toString();
        }
    }

    public int setQueryNumber(Editable text) {
        if(text==null || text.toString().equals("")){
            return 15;
        }else{
            return Integer.parseInt(text.toString());
        }
    }
}
