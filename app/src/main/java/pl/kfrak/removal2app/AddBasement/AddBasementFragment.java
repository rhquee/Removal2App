package pl.kfrak.removal2app.AddBasement;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.kfrak.removal2app.R;


public class AddBasementFragment extends DialogFragment implements AddBasementContract.ViewAB {


    public AddBasementFragment() {
        // Required empty public constructor
    }

    public static AddBasementFragment newInstance(){
        return new AddBasementFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_basement, container, false);
    }
//
//    @Override
//    public void closeAddBasementDialog() {
//        this.dismiss();
//    }
}
