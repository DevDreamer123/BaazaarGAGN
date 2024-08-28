package com.example.neerajinnostore.Utils;

import com.example.neerajinnostore.IncreaseDecreaseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @GET("Stores/List") // Brand
    Call<List<StoreModel>> getStore();
    @GET("BusinessCategories/List") // Brand
    Call<List<ProductCategoryModel>> getCategory();



    @GET("Products/List") // Product
    Call<List<ProductModel>> getProduct();
    @POST("Orders/AllOrders") // AllOrder
    Call<List<ProductModel>> getAllOrder(@Body UserIDModel userIDModel);
    @POST("Carts/List") // ListCart
    Call<List<CartListModel>> getCartsList(@Body UserIDModel userIDModel);
    @POST("Carts/addItem") // AddItem
    Call<List<ProductModel>> getAddItemList(@Body AddItemRequestModel addItemRequestModel);
    @POST("Carts/increaseItemQty") // IncreaseItem
    Call<IncreaseDecreaseModel> getIncreaseItemList(@Body ItemQtyRequestModel itemQtyRequestModel);
    @POST("Carts/decreaseItemQty") // DecreaseItem
    Call<IncreaseDecreaseModel> getDecreaseItemList(@Body ItemQtyRequestModel itemQtyRequestModel);

    @POST("Items/List") // ItemListProduct
    Call<List<ProductItemListModel>> getProductItemList(@Body ProductIDModel productIDModel);








}
