package com.example.customerapp.ApiData;

import com.example.customerapp.Models.CustomerRegisterResponse;
import com.example.customerapp.Models.CustomerlOGINResponse;
import com.example.customerapp.Models.OrdersResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface DataInterface {

    @FormUrlEncoded
    @POST("auth/login/user")
    public Call<CustomerlOGINResponse> customerLogin(@Field("email") String email, @Field("password") String password );

    @FormUrlEncoded
    @POST("auth/register/user")
    public Call<CustomerRegisterResponse> customerRegister(@Field("name") String name , @Field("email") String email
            , @Field("phone") String phone  , @Field("password") String password );

    @POST("create/order")
    public void createOrder(@Header("Authorization") String authorization , @Field("work_id") String work_id , @Field("details") String details
            , @Field("details_address") String details_address  , @Field("photos[]") String[] photo ,
                            @Field("phone") String phone  , @Field("lat") String lat  ,
                            @Field("long") String longg );


    @GET("order/pending/user")
    Call<OrdersResponse> pendingOrders(@Header("Authorization") String authorization);

    @GET("order/un/complete/user")
    Call<OrdersResponse> unCompletedOrders(@Header("Authorization") String authorization);

    @GET("order/complete/user")
    Call<OrdersResponse> completedOrders(@Header("Authorization") String authorization);


}
