/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.closure

/**
 *
 * @author asun
 */
class closureExample4 {
    /**
     * 常用闭包
    */
       
    static void main(args) {
        //#######upto()##########
//        1.upto(5) {println it}
        
        //#######each ###########
//        [1,2,3,4].each{println it}

//        [1,2].eachWithIndex{num, index ->
//            println "Line: ${index}, Value: ${num}"
//        }
    
//        ["a":1, "b":2].each{println it}
//        ["a":1, "b":2].each{println "Key: ${it.key}, Value: ${it.value}"}
//        ["a":1, "b":2].each{key, value -> println "Key: ${key}, Value: ${value}"}
        
        //############# find(), findAll() ############
//        def map = ["a":18, "b":33, "c": 6]
//        def rst1 = map.find{el -> el.value > 10}
//        def rst2 = map.findAll{el -> el.value > 10}
//        println "Class: ${rst1.class}, Value: ${rst1}"
//        println "Class: ${rst2.class}, Value: ${rst2}"
//        assert (rst1 instanceof HashMap) == false
//        assert rst2 instanceof HashMap
        
        //####################### collect() #######################
//        def map = ["a":18, "b":33, "c": 6]
//        def list = map.collect{entry -> ++entry.value}
//        def olderList = map.collect{entry -> ++entry.value; return entry}
//        println "List: ${list}"
//        println "OlderList: ${olderList}"

        //##################any(), every() ##################
//        assert [3,9,8,20].any{it >10} == true
//        assert [3,9,8,20].every{it > 2} == true

        //#################矩阵 transpose() ###########
        def a = ['a','b']
        def b = [1,2]
        assert [a,b].transpose() == [['a',1],['b',2]]
        def result = [a,b].transpose().inject([:]) {s, l ->
            s + [(l[0]): l[1]]
        }
        assert result == ['a':1, 'b':2]
        
        //##################inject() #################
//        def result = (1..2).inject(3){sum, num -> sum + num }
//        assert result == 6
        
        
    }
}

