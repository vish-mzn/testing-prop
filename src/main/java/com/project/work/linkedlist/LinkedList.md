# LINKED_LIST

>> A Linked_List is a linear data structure where elements (called nodes) are linked using pointers

>> unlike Arrays where elements are stored in contiguous memory locations

>> In Java, a linked list is part of the java.util package and implemented as LinkedList<E>.

✅ Java's LinkedList<E> Class
Java provides a built-in LinkedList class that implements:

*List* interface → so it's like an *ArrayList*

*Deque* interface → so it supports *queue* and *stack* operations



🔗 Key Concepts of a Linked List
Each node in a linked list contains:

Data: The value of the element.

Next (pointer): A reference to the next node.


Types:
Singly Linked List: Each node points to the next node.

Doubly Linked List: Each node points to both next and previous nodes.

Circular Linked List: The last node points back to the first node.




⚖️ LinkedList vs ArrayList

| Feature       | `LinkedList`						 |  `ArrayList`              		  |
| ------------- | ------------------------------------ | ---------------------------------- |
| Memory        | More (due to node pointers)          | Less                               |
| Access        | Slow (O(n))                          | Fast (O(1) for index-based access) |
| Insert/Delete | Fast at beginning/middle (O(1)/O(n)) | Slow (O(n) due to shifting)        |
| Search        | Slow (O(n))                          | Fast (O(1) for indexed access)     |



🔍 When to Use LinkedList
Use LinkedList if:

You have many insertions/deletions (especially at the beginning).

You don’t need frequent random access.


