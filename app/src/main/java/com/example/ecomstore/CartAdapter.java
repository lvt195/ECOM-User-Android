package com.example.ecomstore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    private List<CartModel> productModelList;
    private Context context;

    public CartAdapter(Context context){
        this.context = context;
        productModelList= new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CartModel productModel = productModelList.get(position);
        holder.title.setText(productModel.getProductName());
        holder.price.setText(productModel.getProductPrice());
        holder.qty.setText(productModel.getProductQty());

        Glide.with(context).load(productModel.getProductImage())
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(productModel.is_selected ){
                    holder.main.setBackgroundColor(context.getResources().getColor(R.color.white));
                    productModel.is_selected=false;
                }
                else {
                    holder.main.setBackgroundColor(context.getResources().getColor(R.color.teal_700));
                    productModel.is_selected=true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public void addProduct(CartModel productModel){
        productModelList.add(productModel);
        notifyDataSetChanged();
    }

    public List<CartModel> getSelectedItems(){
        List<CartModel> cartitems = new ArrayList<>();
        for (int i = 0 ; i < productModelList.size(); i ++){
            if(productModelList.get(i).is_selected){
                cartitems.add((productModelList.get(i)));
            }
        }
        return cartitems;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title, qty, price;
        private ImageView img;
        private LinearLayout main;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            qty = itemView.findViewById(R.id.qty);
            price = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.image);
            main = itemView.findViewById(R.id.mainLayout);
        }

    }
}
