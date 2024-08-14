package com.androidexp.android_55_day6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.GlideBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ProductModel> mListData;
    private ProductAdapter mProductAdapter;
    private RecyclerView rvProduct;
    private ArrayList<String> mListImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        rvProduct = findViewById(R.id.rvProduct);
        mProductAdapter = new ProductAdapter(this, mListData);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rvProduct.setLayoutManager(gridLayoutManager);
        rvProduct.setAdapter(mProductAdapter);
    }

    private void initData() {
        mListImg = new ArrayList<>();
        mListImg.add("https://vapa.vn/wp-content/uploads/2022/12/anh-3d-thien-nhien.jpeg");
        mListImg.add("https://www.chuphinhsanpham.vn/wp-content/uploads/2022/03/EDEN-EVA-APPLE-NUOC-TAO-LEN-MEN-chup-anh-san-pham-dep-0002.jpg");
        mListImg.add("https://www.chuphinhsanpham.vn/wp-content/uploads/2022/03/chup-anh-san-pham-dep-lon-bia-saigon-0001.jpg");
        mListImg.add("https://www.chuphinhsanpham.vn/wp-content/uploads/2022/03/chup-anh-san-pham-dep-physalisvncom-0001.jpg");
        mListImg.add("https://www.chuphinhsanpham.vn/wp-content/uploads/2022/03/chup-anh-san-pham-dep-vola-viet-quat-dau-tam-0001.jpg");


        mListData = new ArrayList<>();
        for(int i=0; i<20; i++){
            ProductModel productModel = new ProductModel();
            productModel.setProductName("Product: " + i);
            productModel.setProductPrice(Double.valueOf(i));
            productModel.setProductImg(mListImg.get(i % mListImg.size()));
            mListData.add(productModel);
        }
    }
}