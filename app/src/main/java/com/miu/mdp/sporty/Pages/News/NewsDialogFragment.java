package com.miu.mdp.sporty.Pages.News;

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

import com.miu.mdp.sporty.Pages.News.Model.News;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.miu.mdp.sporty.Adapters.DialogCallback;
import com.miu.mdp.sporty.R;

public class NewsDialogFragment extends DialogFragment {
    public DialogCallback callback =null;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the MaterialAlertDialogBuilder to create the dialog
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext(), R.style.CustomDialogStyle);

        // Set dialog title
        builder.setTitle("Add New News");

        // Set the custom view for the dialog
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.news_dialog_fragment, null);
        builder.setView(dialogView);

        // Create the dialog
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);

        dialog.setCanceledOnTouchOutside(false);

        // Set positive button with text and click listener
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                EditText editTextImageUrl = dialogView.findViewById(R.id.edit_text_news_image);
                EditText editTextNewsName = dialogView.findViewById(R.id.edit_text_news_name);
                EditText editTextDescription = dialogView.findViewById(R.id.edit_text_news_description);
                String selectedMeasure = editTextImageUrl.getText().toString();
                String newsName = editTextNewsName.getText().toString();
                String description = editTextDescription.getText().toString();

                if (newsName.isEmpty() || description.isEmpty() || selectedMeasure.isEmpty()) {
                    // Display a Toast message indicating all fields must be filled

                    Toast.makeText(requireContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    // Process the data (e.g., pass it to your ViewModel)
                    callback.onDataReturned(new News(selectedMeasure,newsName, description));
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



