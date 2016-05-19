package com.example.android.motelmgmtapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dhanashri on 19-05-2016.
 */
    public class OnLongClickListenerCustomerRecord implements View.OnLongClickListener {

    Context context;
    String id;

        @Override
        public boolean onLongClick(View view) {

            context = view.getContext();
            id = view.getTag().toString();



    final CharSequence[] items = { "Edit", "Delete" };

    new AlertDialog.Builder(context).setTitle("Student Record")
    .setItems(items, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int item) {
            if (item == 0) {
                editRecord(Integer.parseInt(id));
            }
            dialog.dismiss();

        }
    }).show();
            return false;
        }

    public void editRecord(final int customerId) {
        final TableControllerCustomer tableControllerCustomer = new TableControllerCustomer(context);
        ObjectCustomer objectCustomer = tableControllerCustomer.readSingleRecord(customerId);


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.customer_data_form, null, false);

        final EditText txtName = (EditText) formElementsView.findViewById(R.id.txtName);
        final EditText txtEmailId = (EditText) formElementsView.findViewById(R.id.txtEmailId);
        final EditText txtAddress = (EditText) formElementsView.findViewById(R.id.txtAddress);
        final EditText txtCheckIn = (EditText) formElementsView.findViewById(R.id.txtCheckIn);
        final EditText txtCheckOut = (EditText) formElementsView.findViewById(R.id.txtCheckOut);

        txtName.setText(objectCustomer.name);
        txtAddress.setText(objectCustomer.address);
        txtEmailId.setText(objectCustomer.email);
        txtCheckIn.setText(objectCustomer.check_in);
        txtCheckOut.setText(objectCustomer.check_out);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Edit Record")
                .setPositiveButton("Save Changes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                ObjectCustomer objectCustomer = new ObjectCustomer();
                                objectCustomer.id = customerId;
                                objectCustomer.name = txtName.getText().toString();
                                objectCustomer.email = txtEmailId.getText().toString();
                                objectCustomer.address = txtAddress.getText().toString();
                                objectCustomer.check_in = txtCheckIn.getText().toString();
                                objectCustomer.check_out = txtCheckOut.getText().toString();

                                boolean updateSuccessful = tableControllerCustomer.update(objectCustomer);

                                if(updateSuccessful){
                                    Toast.makeText(context, "Customer details were updated.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Unable to update customer record.", Toast.LENGTH_SHORT).show();
                                }

                                ((MainActivity) context).countRecords();
                                ((MainActivity) context).readRecords();

                                dialog.cancel();
                            }

                        }).show();
    }
}

