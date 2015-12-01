/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

/**
 *
 * @author asun
 */
class LibraryManagement {
    static void main(args) {
        def library = ["emma":["java","groovy"],
            "adrian":["python"]
        ]    
        println "Total borrowers from library is: " + library.size()
        println "emma has borrowed ${library["emma"].size()} books"
        
    }
}

