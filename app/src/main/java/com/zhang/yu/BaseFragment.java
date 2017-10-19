package com.zhang.yu;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by zhang_shuai on 2017/10/18.
 * Del:
 */

public class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //绑定接口
        if(context instanceof MainActivity){
            ((MainActivity)context).setFunction();
        }
    }
}
