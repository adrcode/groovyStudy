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
class StringExample1 {
    static void main(args) {
        println "string test".getClass().name
        
        //同java一样，String一旦实例化，其值不可改变
        def str1 = "Test"
        try{
            str1[1] = 'a'
        } catch(Exception e) {
            println e
        }
    }
}

