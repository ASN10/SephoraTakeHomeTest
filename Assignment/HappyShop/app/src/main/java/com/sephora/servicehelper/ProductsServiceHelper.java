package com.sephora.servicehelper;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.sephora.app.AppController;
import com.sephora.app.R;
import com.sephora.model.ProductsList;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nivedhitha.a on 26-Apr-16.
 */
public class ProductsServiceHelper {

    private static final String GET_PRODUCTS_LIST_TAG = "get_products_list_tag";
    private static final String GET_PRODUCTS_DETAIL_TAG = "get_product_detail_tag";


    private ProductsServiceListener productsServiceListener;


    public void makeGetProductsListServiceCall(String url, final int requestCode) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("Response", response.toString());

                productsServiceListener.onResponse(requestCode, response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                productsServiceListener.onError(requestCode, error.toString());
            }
        });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, GET_PRODUCTS_LIST_TAG);
    }

    public void makeGetProductDetailServiceCall(String url, final int requestCode) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("Response", response.toString());

                productsServiceListener.onResponse(requestCode, response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                productsServiceListener.onError(requestCode, error.toString());
            }
        });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, GET_PRODUCTS_DETAIL_TAG);
    }


    public interface ProductsServiceListener {
        void onResponse(int requestCode, JSONObject response);

        void onError(int requestCode, String error);
    }

    public void setProductsServiceListener(ProductsServiceListener productsServiceListener) {
        this.productsServiceListener = productsServiceListener;
    }


}
