package com.example.mobile_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.zip.Inflater;

public class AddContactFragment extends Fragment {


    EditText firstNameEdit, lastNameEdit, EmailEdit, AddressEdit, NumberEdit, NotesEdit;
    Button addBtn;
    String firstName , lastName , email, address, number, notes;
    int error = 0;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =     inflater.inflate(R.layout.fragment_add_contact, container, false);


        addBtn = view.findViewById(R.id.addBtn);

        firstNameEdit = view.findViewById(R.id.firstNameEditText);
        lastNameEdit = view.findViewById(R.id.lastNameEditText);
        EmailEdit = view.findViewById(R.id.EmailEditText);
        AddressEdit = view.findViewById(R.id.AddressEditText);
        NumberEdit = view.findViewById(R.id.phoneNumberEditText);
        NotesEdit = view.findViewById(R.id.noteEditText);


        firebaseDatabase = firebaseDatabase.getInstance();

        databaseReference  = firebaseDatabase.getReference();


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 firstName   = firstNameEdit.getText().toString();
                lastName   = lastNameEdit.getText().toString();
                email =     EmailEdit.getText().toString();
                address   = AddressEdit.getText().toString();
                number   = NumberEdit.getText().toString();
                notes   = NotesEdit.getText().toString();

          if (!number.isEmpty()){



              if ( number.length() > 10 || number.length() < 10){



                  error = 1;
                  Toast.makeText(view.getContext(), "number Should be 10 digits", Toast.LENGTH_LONG).show();



              }
          }


                if (email.isEmpty()){

                    error = 1;


                    Toast.makeText(getView().getContext(), "Email is empty", Toast.LENGTH_LONG).show();



                }  else if ( !Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                    error = 1;

                    Toast.makeText(view.getContext(), "Email format is wrong", Toast.LENGTH_LONG).show();

                } else if (firstName.isEmpty() || lastName.isEmpty()){

                    error = 1;

                    Toast.makeText(view.getContext(), "F or L name shouldn't be empty", Toast.LENGTH_LONG).show();
                } else if (address.isEmpty()){

                    error = 1;
                    Toast.makeText(view.getContext(), "Address Shouldn't be empty", Toast.LENGTH_LONG).show();
                } else if (notes.isEmpty()){
                    error = 1;
                    Toast.makeText(view.getContext(), "Your note is empty", Toast.LENGTH_LONG).show();
                }






                if (error == 0){


                    HashMap<String, Object> hashMap = new HashMap<>();

                    hashMap.put("fname", firstName);

                    hashMap.put("lname", lastName);

                    hashMap.put("email ", email);

                    hashMap.put("address", address);

                    hashMap.put("number", number);

                    hashMap.put("notes", notes);








                    databaseReference.child("users").child(lastName).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {

                            Toast.makeText(getView().getContext(), "Data Added Succesfully", Toast.LENGTH_LONG).show();


                            clear(firstNameEdit, lastNameEdit, EmailEdit, AddressEdit, NumberEdit, NotesEdit);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(getView().getContext(), ""+e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                }










                error = 0;

            }
        });

        return view;


    }

    public void clear(EditText a, EditText b, EditText c, EditText d, EditText e, EditText f){

        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        e.setText("");
        f.setText("");

    }
}