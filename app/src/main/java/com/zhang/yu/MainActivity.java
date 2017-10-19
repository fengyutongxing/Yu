package com.zhang.yu;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zhang.yu.struct.FunctionAndParamNoResult;
import com.zhang.yu.struct.FunctionManager;
import com.zhang.yu.struct.FunctionNoParamAndResult;
import com.zhang.yu.struct.FunctionNoParamNoResult;

public class MainActivity extends AppCompatActivity{
    //数组 存储Fragment
    Fragment[] mFragments = new Fragment[]{new Fragment1(),new Fragment2(),new Fragment3(),new Fragment4()};
    private RadioGroup radioGroup;
    private RadioButton notifyButton;
    private RadioButton historyButton;
    private RadioButton mineButton;
    //当前Fragent的下标
    private int currentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.rbg_main);
        notifyButton = (RadioButton) findViewById(R.id.rb_main_notify);
        historyButton = (RadioButton) findViewById(R.id.rb_main_history);
        mineButton = (RadioButton) findViewById(R.id.rb_main_mine);

        notifyButton.setText("我的");
        historyButton.setText("通知");
        mineButton.setText("联系人");
        //开启事务
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //设置为默认界面 MainHomeFragment
        ft.add(R.id.main_frameLayout, mFragments[0]).commit();
        radioGroup.setOnCheckedChangeListener(mainCheckChangeListener);
    }
    RadioGroup.OnCheckedChangeListener mainCheckChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.rb_main_notify:
                    setIndexSelected(0);
                    break;
                case R.id.rb_main_history:
                    setIndexSelected(1);
                    break;
                case R.id.rb_main_mine:
                    setIndexSelected(2);
                    break;

            }

        }
    };

    //设置Fragment页面
    private void setIndexSelected(int index) {
        if (currentIndex == index) {
            return;
        }
        //开启事务
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //隐藏当前Fragment
        ft.hide(mFragments[currentIndex]);
        //判断Fragment是否已经添加
        if (!mFragments[index].isAdded()) {
            ft.add(R.id.main_frameLayout, mFragments[index]).show(mFragments[index]);
        } else {
            //显示新的Fragment
            ft.show(mFragments[index]);
        }
        ft.commit();
        currentIndex = index;
    }

    //创建接口
    public void setFunction(){
        FunctionManager functionManager = FunctionManager.getInstance();

            functionManager.addFunction(new FunctionNoParamNoResult(Fragment1.INTRFACE) {
                @Override
                public void function() {
                    Toast.makeText(MainActivity.this,"无参无返回值的接口",Toast.LENGTH_SHORT).show();
                }
            });

           functionManager.addFunction( new FunctionNoParamAndResult<String>(Fragment2.INTRFACE){

               @Override
               public String function() {

                   return "我是接口   有返回值 无参的2";
               }
           });

        functionManager.addFunction(new FunctionAndParamNoResult(Fragment3.INTRFACE) {
            @Override
            public String function(Object data) {
                return "我是接口   有返回值  有参的3" +data;
            }
        });


    }
}
