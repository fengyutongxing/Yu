package com.zhang.yu.struct;

/**
 * Created by zhang_shuai on 2017/10/18.
 * Del:有返回值有参数
 */

public abstract class FunctionAndParamNoResult<Param> extends Function {
    public FunctionAndParamNoResult(String name) {
        super(name);
    }

    public abstract String function(Param data);
}
