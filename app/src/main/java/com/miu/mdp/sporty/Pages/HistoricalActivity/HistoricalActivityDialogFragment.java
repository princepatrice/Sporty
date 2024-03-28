package com.miu.mdp.sporty.Pages.HistoricalActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.miu.mdp.sporty.Pages.HistoricalActivitys.Model.HistoricalActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.miu.mdp.sporty.Adapters.DialogCallback;
import com.miu.mdp.sporty.R;

import java.util.Locale;

public class HistoricalActivityDialogFragment extends DialogFragment {
    public DialogCallback callback =null;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the MaterialAlertDialogBuilder to create the dialog
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext(), R.style.CustomDialogStyle);

        // Set dialog title
        builder.setTitle("Add New HistoricalActivity");

        // Set the custom view for the dialog
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.historical_activity_dialog_fragment, null);
        builder.setView(dialogView);

        EditText editTextHistoricalActivityDate = dialogView.findViewById(R.id.edit_text_historical_activity_date);


        MaterialDatePicker.Builder<Long> CalendatBuilder = MaterialDatePicker.Builder.datePicker();
        final MaterialDatePicker<Long> picker = CalendatBuilder.build();

        editTextHistoricalActivityDate.setOnClickListener(v -> picker.show(getParentFragmentManager(), picker.toString()));
        picker.addOnPositiveButtonClickListener(selection -> {
            editTextHistoricalActivityDate.setText(picker.getHeaderText());
        });

        // Create the dialog
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);

        dialog.setCanceledOnTouchOutside(false);

        // Set positive button with text and click listener
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                EditText editTextHistoricalActivityName = dialogView.findViewById(R.id.edit_text_historical_activity_name);
                EditText editTextHistoricalActivityDescription = dialogView.findViewById(R.id.edit_text_historical_activity_description);
             
                String historicalActivityName = editTextHistoricalActivityName.getText().toString();
                String historicalActivityDescription = editTextHistoricalActivityDescription.getText().toString();
                String historicalActivityDate = editTextHistoricalActivityDate.getText().toString();

                if (historicalActivityName.isEmpty() || historicalActivityDescription.isEmpty() || historicalActivityDate.isEmpty()
                ) {
                    // Display a Toast message indicating all fields must be filled

                    Toast.makeText(requireContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    // Process the data (e.g., pass it to your ViewModel)
                    callback.onDataReturned(new HistoricalActivity(historicalActivityName,historicalActivityDescription,historicalActivityDate));
                    dialog.dismiss(); // Dismiss the dialog
                }
            }
        });

        // Set negative button with text and click listener
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Handle negative button click
                dialog.dismiss(); // Dismiss the dialog
            }
        });

        return dialog;
    }


    // This function is called when you want to return data
}



