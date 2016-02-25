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
class closureExample3 {
	static void main(args) {
            def factorial = 1
            1.upto(5) {num -> factorial *= num}
            println "Factorial(5): ${factorial}"
        }
}

