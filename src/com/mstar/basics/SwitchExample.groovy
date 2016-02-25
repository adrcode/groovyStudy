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
class SwitchExample {
    static void main(args) {
        /**
         * switch中的case语句可以是数值，字符串，范围，列表，正则表达式或某个类
         * continue仅限于在for或while语句中使用
         * break语句用于for,while及switch语句
        */
        
        def score = 95
        switch(score) {
            case 0..59:
                println 'E'
                break
            case 60..69:
                println 'D'
                break
            case 70..79:
                println 'C'
                break
            case 80..89:
                println 'B'
                break
            case 90..100:
                println 'A'
                break
            default:
                println "Invalid score!"
        }
    }
}

