package com.zhang.yu.struct;

/**
 * Created by zhang_shuai on 2017/10/18.
 * Del:无参数有返回值
 */

public abstract class FunctionNoParamAndResult<Result> extends Function {
    public FunctionNoParamAndResult(String name) {
        super(name);
    }

    public abstract Result function();
}
