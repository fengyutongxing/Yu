package com.zhang.yu.struct;


/**
 * Created by zhang_shuai on 2017/10/18.
 * Del:有参数有返回值
 */

public abstract class FunctionAndParamAndResult<Result,Param> extends Function{
    public FunctionAndParamAndResult(String name) {
        super(name);
    }
    public abstract Result function(Param data);
}
