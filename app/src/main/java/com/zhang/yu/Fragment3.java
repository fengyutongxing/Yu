package com.zhang.yu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhang.yu.struct.FunctionManager;

/**
 * Created by zhang_shuai on 2017/10/18.
 * Del:
 */

public class Fragment3 extends BaseFragment {

    //定义接口
    public static final String INTRFACE = Fragment3.class.getName()+"APAR";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message2, container, false);
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object yes = FunctionManager.getInstance().invokeFunction(INTRFACE, "yes");
                Toast.makeText(getActivity(),"返回值3："+yes,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
