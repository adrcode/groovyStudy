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
class SimpleClass01 {
    /**
     * simple.name     simple.getName()  simple.setName(object)
    */
    
    def name
    def age
    
    static void main(args) {
        def simple = new SimpleClass01(name: 'Emma', age: 19)
        
        println "Name: ${simple.name},  Age: ${simple.age}"
        printf("My name is %s, %d years old!\n", simple.getName(), simple.getAge())
    }
}

