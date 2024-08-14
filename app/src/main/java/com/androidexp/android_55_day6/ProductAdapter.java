package com.androidexp.android_55_day6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewModel> {

    private ArrayList<ProductModel> mListData;
    private Context mContext;

    public ProductAdapter(Context context, ArrayList<ProductModel> listData) {
        this.mListData = listData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = mContext;
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_product, parent, false);
        return new ProductViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewModel holder, int position) {
        ProductModel productModel = mListData.get(position);
        holder.tvProductName.setText(productModel.getProductName());
        holder.tvProductPrice.setText("$"+ productModel.getProductPrice());
        Glide.with(mContext).load(productModel.getProductImg()).into(holder.imgProduct);

    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }


    public class ProductViewModel extends RecyclerView.ViewHolder {

        ImageView imgProduct;
        TextView tvProductName, tvProductPrice;
        public ProductViewModel(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
        }
    }
}
