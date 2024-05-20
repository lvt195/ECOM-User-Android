package com.example.ecomstore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<ProductModel> productModelList;
    private Context context;

    public ProductAdapter(Context context){
        this.context = context;
        productModelList= new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductModel productModel = productModelList.get(position);
        holder.title.setText(productModel.getTitle());
        holder.desc.setText(productModel.getDescription());
        holder.price.setText(productModel.getPrice());

        Glide.with(context).load(productModel.getImage())
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("model", productModel);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public void addProduct(ProductModel productModel){
        productModelList.add(productModel);
        notifyDataSetChanged();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title, desc, price;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.image);
        }

    }
}
