## Multi-threading and Concurrency Challenge
### Print In Order

### 

Suppose we have a class:    
  
```java
public class Foo {  
  public void first() { print("first"); }  
  public void second() { print("second"); }  
  public void third() { print("third"); }  
}
```

The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third().  

### Your task:
Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
If you'd like to maintain the spirit of the original coding challenge, make sure solutions are implemented in ***Foo.java*** only. 
However, this is an empty playground and you are welcome to use this as a boilerplate for whatever multi-threading and concurrency related things you'd like to do!

### Examples:
Example 1:  

Input: [1,2,3]  
Output: "firstsecondthird"  
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.  

Example 2:  

Input: [1,3,2]  
Output: "firstsecondthird"  
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.  

Example 3:  

Input: [1]  
Output: "first"  
Explanation: The input [1] means thread A calls first(). "first" is the correct output.

#### Assumptions:
An Input of [3] is not within the scope of the _current_ problem as stated, because it violates the "second() before first() and third() before second()" rule.
As a challenge, try to support edge cases like this.

Note:  

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.  

---   
**The original challenge prompt can be found on LeetCode.com under 'concurrency > print in order'*
