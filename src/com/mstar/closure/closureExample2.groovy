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
class closureExample2 {
	static void main(args) {
            def clo = {name -> println "Hello ${name}"}
            new closureExample2().demo(clo)
            new closureExample2().demo clo

        }
        
        def demo(clo){
            def name = "Rose"
            clo.call("Leslie")
        }
}

