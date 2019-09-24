package com.example.administrator.test.unit

/**
 * @author Alex
 * @date 2019/3/27 下午11:04
 * @email 18238818283@sina.cn
 * @desc ...
 */
open class Call(val addImpl: AddI) : Callback{

    var message = "AAA"

    override fun success(msg: String) {
        System.out.println("==========$msg")
        this.message = msg
    }

    fun test(){
        addImpl.syncAnswer(this)
    }
}