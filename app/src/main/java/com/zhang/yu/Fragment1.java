package com.zhang.yu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhang.yu.struct.FunctionManager;

/**
 * Created by zhang_shuai on 2017/10/18.
 * Del:
 */

public class Fragment1 extends BaseFragment {

    //定义接口
    public static final String INTRFACE = Fragment1.class.getName()+"NPNR";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionManager.getInstance().invokeFunction(INTRFACE);//使用接口
            }
        });
        return view;
    }

}
