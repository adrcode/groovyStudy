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
class closureExample5 {
    static void main(args) {
        /**
         * collect()高级范例
        */
       
        def doubles = {item -> 2 * item}
        def triples = {item -> 3 * item}
        def isEven = {item -> (item % 2) == 0}
        
        def test = new closureExample5()
        println test.demo(doubles, [1,2,3,4])
        println test.demo(triples, [1,2,3,4])
        println test.demo(isEven, [1,2,3,4])
    }
    def demo(closure, list) {
        list.collect(closure)
    }
}

