/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.basics

import groovy.transform.Canonical

/**
 *
 * @author asun
 */
class IOTest {
    
    static void main(args) {
        /**
         * print()          简单输出，不换行
         * println()        简单输出，换行
         * printf()         格式化输出
        */
        
        //#######################1. 转换格式#####################
//        printf('My name is Adrian\n', [])
//        def a = 3
//        def b =4
//        printf("The sum of %d and %d is %d\n", [a, b, a+b])   //'[',']'可省略
//        
//        //#####################2.字符串输出宽度和格式##############
//        printf('%s\n', "Hello world")
//        printf('%20s\n', "Hello world")
//        printf('%-20s\n', "Hello world")
        
        //####################3. 简单输入#####################
//        print "Please input your name:"
//        Console.reader()
//        println "Your name is ${name}"
        def p = new Person('allen', 33, 'girl')
        println p

    }
    
    @Canonical(excludes="name, sex")
    class Person {
       def name
        def age
        def sex
    }
    
    
}

