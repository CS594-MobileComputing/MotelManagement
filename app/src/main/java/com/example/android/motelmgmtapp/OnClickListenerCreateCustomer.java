package com.example.android.motelmgmtapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dhanashri on 18-05-2016.
 */

public class OnClickListenerCreateCustomer implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        final Context context = view.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.customer_data_form, null, false);

        final EditText txtName = (EditText) formElementsView.findViewById(R.id.txtName);
        final EditText txtEmailId = (EditText) formElementsView.findViewById(R.id.txtEmailId);
        final EditText txtAddress = (EditText) formElementsView.findViewById(R.id.txtAddress);
        final EditText txtCheckIn = (EditText) formElementsView.findViewById(R.id.txtCheckIn);
        final EditText txtCheckOut = (EditText) formElementsView.findViewById(R.id.txtCheckOut);


        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Create Customer")
                .setPositiveButton("Add",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                String customerName = txtName.getText().toString();
                                String customerEmail = txtEmailId.getText().toString();
                                String customerAddress = txtAddress.getText().toString();
                                String customerCheckIn = txtCheckIn.getText().toString();
                                String customerCheckOut = txtCheckOut.getText().toString();

                                ObjectCustomer objectCustomer = new ObjectCustomer();
                                objectCustomer.name = customerName;
                                objectCustomer.email = customerEmail;
                                objectCustomer.address = customerAddress;
                                objectCustomer.check_in = customerCheckIn;
                                objectCustomer.check_out = customerCheckOut;

                                boolean createSuccessful = new TableControllerCustomer(context).create(objectCustomer);

                                if(createSuccessful){
                                    Toast.makeText(context, "Customer information was saved.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Unable to save customer information.", Toast.LENGTH_SHORT).show();
                                }

                                /*((MainActivity) context).countRecords();
                                ((MainActivity) context).readRecords();*/

                                dialog.cancel();
                            }

                        }).show();

    }
}
