package com.example.ecomstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ecomstore.databinding.ActivityCartBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    private CartAdapter cartAdapter;

    public static List<CartModel> cartItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cartAdapter = new CartAdapter(this);
        binding.cartRecycler.setAdapter(cartAdapter);
        binding.cartRecycler.setLayoutManager(new LinearLayoutManager(this));

        getCartItem();

        binding.proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItemList = cartAdapter.getSelectedItems();
                startActivity(new Intent(CartActivity.this,OrderPlacingActivity.class ));
            }
        });
    }

    private void getCartItem() {
        FirebaseFirestore.getInstance()
                .collection("cart")
                .whereEqualTo("sellerUid", FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot ds:dsList){
                            CartModel cartModel = ds.toObject(CartModel.class);
                            cartAdapter.addProduct(cartModel);

                        }
                    }
                });
    }
}