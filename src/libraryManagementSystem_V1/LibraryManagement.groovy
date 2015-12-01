/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libraryManagementSystem_V1

/**
 *
 * @author asun
 */
class LibraryManagement {
    def library = ["java":["adrian","lizzy"], "groovy":["lucy"],"python":["lily","adrian","vickly"],"C++":[]]
    LibraryManagement(library){
        this.library = library
    }
    
    def displayLoadStock() {
        println "library stock:\n${this.library}"
    }
    
    def addBook(bookName) {
        this.library[bookName] = []
    }
    
    def removeBook(bookName) {
        this.library.remove(bookName)
    }
    
    def lendBook(bookName, borrower) {
        this.library[bookName] << borrower
    }
    
    def returnBook(bookName, returner) {
        this.library[bookName].remove(returner)
    }
    
    def getTotalAvaliableBooks() {
        return this.library.size()
    }
    
    def getTotalBookHasBorrowed(borrower) {
        def values = this.library.values.asList().flatten()
        return values.count(borrower)
    }
}

