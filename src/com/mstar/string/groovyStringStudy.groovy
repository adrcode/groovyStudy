/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.string

/**
 *
 * @author asun
 */
class groovyStringStudy {
    /**常用方法整理
    * String[] split()       拆分字符串
    * List tokenize()        拆分字符串
    * 
    */
       
    static void main(args) {
        //##############1. Compare the method split() and tokenize()################
        //1> The split() method returns a string [] instance and the tokenize() method returns a List instance
        assert "hello,world".split(',') instanceof String[]
        assert "hello,workd".tokenize(',') instanceof ArrayList
        
        //2> tokenize() ,which returns a List ,will ignore empty string (when a delimeter appears twice in  succession) 
        //where as split() keeps such string.
        assert ['he','','o brother'] == "hello brother".split('l')
        assert ['he', 'o brother'] == "hello brother".tokenize('l')
        
        //3> The tokenize() method uses each character of a String as delimeter where as split()  
        //takes the entire string as delimeter
        assert ['hel', ' brother'] == "hello brother".split('lo')
        assert ['he', ' br', 'ther'] == "hello brother".tokenize('lo')
        
        //4> The split()  can take regex as delimeter  where as  tokenize does not.
        String testString = 'hello world 123 herload'
        assert['hello world ',' herload'] == testString.split(/\d{3}/)
 
    }
}

