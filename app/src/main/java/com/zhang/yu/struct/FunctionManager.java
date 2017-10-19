package com.zhang.yu.struct;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by zhang_shuai on 2017/10/18.
 * Del:管理类
 */

public class FunctionManager {
    private static final FunctionManager ourInstance = new FunctionManager();

    public static FunctionManager getInstance() {
        return ourInstance;
    }

    private FunctionManager() {
        mFunctionNoParamNoResultHashMap = new HashMap<>();
        mFunctionNoParamAndResultHashMap = new HashMap<>();
        mFunctionAndParamAndResultHashMap = new HashMap<>();
        mFunctionAndParamNoResultHashMap = new HashMap<>();
    }
    //无参数无返回值
    private HashMap<String,FunctionNoParamNoResult> mFunctionNoParamNoResultHashMap;
    //无参数有返回值
    private HashMap<String,FunctionNoParamAndResult> mFunctionNoParamAndResultHashMap;
    //有参数有返回值
    private HashMap<String,FunctionAndParamAndResult> mFunctionAndParamAndResultHashMap;
    //有参数无返回值
    private HashMap<String,FunctionAndParamNoResult> mFunctionAndParamNoResultHashMap;

    //添加接口
    public FunctionManager addFunction(FunctionNoParamNoResult function){
        mFunctionNoParamNoResultHashMap.put(function.mFunctionName,function);
        return this;
    }

    //执行接口
    public void invokeFunction(String functionName){
        if(TextUtils.isEmpty(functionName)){
            return;
        }
        if(mFunctionNoParamNoResultHashMap != null){
            FunctionNoParamNoResult f = mFunctionNoParamNoResultHashMap.get(functionName);
            if(f != null){
                f.function();
            }
            if(f == null){
                try {
                    throw new FunctionException("NO Function  :  "+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //添加接口
    public FunctionManager addFunction(FunctionNoParamAndResult function){
        mFunctionNoParamAndResultHashMap.put(function.mFunctionName,function);
        return this;
    }

    //执行接口
    public <Result> Result invokeFunction(String functionName,Class<Result>  c){
        if(TextUtils.isEmpty(functionName)){
            return null;
        }
        if(mFunctionNoParamAndResultHashMap != null){
            FunctionNoParamAndResult f = mFunctionNoParamAndResultHashMap.get(functionName);
            if(f != null){
                if(c!=null){
                    return c.cast(f.function());
                }else{
                    return (Result) f.function();
                }
            }
            if(f == null){
                try {
                    throw new FunctionException("NO Function  :  "+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //添加接口
    public FunctionManager addFunction(FunctionAndParamNoResult function){
        mFunctionAndParamNoResultHashMap.put(function.mFunctionName,function);
        return this;
    }

    //执行接口
    public <Param> Param invokeFunction(String functionName,String  str){
        if(TextUtils.isEmpty(functionName)){
            return null;
        }
        if(mFunctionAndParamNoResultHashMap != null){
            FunctionAndParamNoResult f = mFunctionAndParamNoResultHashMap.get(functionName);
            if(f != null){
                if(str!=null) {
                    return (Param) f.function(str);
                }
            }
            if(f == null){
                try {
                    throw new FunctionException("NO Function  :  "+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
