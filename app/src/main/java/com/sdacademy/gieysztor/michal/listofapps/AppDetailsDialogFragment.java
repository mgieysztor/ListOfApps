package com.sdacademy.gieysztor.michal.listofapps;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class AppDetailsDialogFragment extends DialogFragment {

    public AppDetailsDialogFragment() {
        // Required empty public constructor
    }

    public static AppDetailsDialogFragment newInstance() {
        AppDetailsDialogFragment fragment = new AppDetailsDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_app_details_dialog,null);

        ImageView imageView = (ImageView) view.findViewById(R.id.fragmentAppDetailsDialogIcon);
        TextView uidTextView = (TextView) view.findViewById(R.id.fragmentAppDetailsUID);
        TextView nameTextView = (TextView) view.findViewById(R.id.fragmentAppDetailsName);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
        .setTitle("Aplication details")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }


}
