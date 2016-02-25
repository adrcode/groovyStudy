/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.basics

import java.text.SimpleDateFormat

/**
 *
 * @author asun
 */
class DateExample {
    static void main(args) {
        Date date = new Date()       
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日")
        def formatStr = format1.format(date)
        println formatStr
        
    }
}

