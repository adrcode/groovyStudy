/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.basics

/**
 *
 * @author asun
 */
class CalendarExample {
    static void main(args) {
        Calendar cal = Calendar.getInstance()
        println cal.get(Calendar.YEAR)
        println cal.get(Calendar.MONTH) + 1
        println cal.get(Calendar.DATE)
        println System.currentTimeMillis()
    }
}

