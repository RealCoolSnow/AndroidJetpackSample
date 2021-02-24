package com.coolsnow.androidjetpacksample.data

import javax.inject.Inject

/**
 *  File: User
 *  Author: CoolSnow(coolsnow2020@gmail.com)
 *  Created at: 2021/2/24 11:55
 *  Description:
 *
 */
class User @Inject constructor() {
    lateinit var name: String;
    lateinit var age: Number;

    override fun toString(): String {
        return "name=$name,age=$age"
    }
}