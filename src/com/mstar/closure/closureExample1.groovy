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
class closureExample1 {
	static void main(args) {
            def clo1 = {println "Hello world"}
            def clo2 = {name -> println "Hello ${name}"}
            def clo3 = {println "Hello ${it}"}
            
            clo1.call()
            clo2.call("Peter")
            clo3.call("Leslie")
        }
}

