**Checkpoint-one**
==============

Reader's Club
-------------


----------
**About**
========
The Reader's club consists of Members who are either Staff or Student. In the club any member can borrow a book, the only restrain is when two or more members wish to borrow the same book.
Based on the number of copies available the following rules is put into consideration.

 - If the borrowers are both staff, a staff that has an older registeration date will have higher precedence to the newer.
 - If the borrowers are both student, a student that has an older registeration date will have higher precedence to the newer.
 - A staff will have higher precedence over a student.


----------
**UML CLASS DIAGRAM**

![Uml class Diagram](https://github.com/andela-gkuti/Checkpoint-one/blob/master/uml.png?raw=true)


----------


**CLASSES**
=====

Member class
------------
This class serves as parent class for staff and student,  it sets the generic properties common to the child class.
Staff class
------------
This class inherit from the Member class and set some other attributes like salary, working hours etc.
Student class
------------
This class inherit from the Member class and set some other attributes like institution, subject of interest etc.
Book class
------------
This class sets book properties like title, author, isbn and copies available.
LibraryOperations class
------------
This class serves as a parent class for the Library and has methods for creating member, removing book, removing member, total member etc.
Library class
------------
This class inherit from the LibraryOperations class has method associated with library operations like creating member, removing book, removing member, total member etc. It set how books are borrowed and shows who borrowed them etc.
BookQueueComparator class
------------
This class defines how the borrower queue showed be sorted based on the member type and date of registration.


----------


**USAGE**
-----

Model constructors
------------------


**Member**

> Member staff = new Staff("Kayode Olowu", "1 boyega street, sogunle", 2, 45000, 9, "Accounting");
> Member student = new Student("Samuel Okonkwo", "37 calabar street, masha", 3, "Laspotech", "History", "Art");

**Book**

> Book book = new Book("Harry Porter", "978-0439139601", "JK Rolins", 2);


----------


 - create the member by instanciating a staff or student.
 - add the member to the library.

 

> library.registerMember(staff);

 - add a new book to the library.

> library.addBook(book);

----------

The Library methods
-------------------

> borrowBook(Book book, Member...members)

public method to borrow book from the library, it takes the book and the number of members as argument.

> library.getbookAndBorrowers(book);

public method to return list of borrowers of a particular book.

> library.isBookInLibrary(book2);

public method to check if a book is present in the library.


----------

**OTHER METHODS**
--------------------

> library.borrower(index);

return borrower at the particular position.

> getBorrowersList( );

return list of borrower.

> isBookInLibrary( book )

check if a book is in the library.

> AddBookList( ArrayList )

adds books to the library from a list

> AddMemberList( ArrayList )

adds members to the library from a list