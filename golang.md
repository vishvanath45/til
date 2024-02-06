go lang

* general purpose language
* not oops language, no concept of class
* struct are declared in heap

## Difference between object creation using new and manual writing.


TL;DR - new gives pointer to object, where as manual creation gives specific object

for ex

type ListNode struct {
val int
next *ListNode
}

var n1 = ListNode{0, nil}
var n2 = new(ListNode)
	
fmt.Println(reflect.TypeOf(n1))  // would be  main.ListNode
fmt.Println(reflect.TypeOf(n2))  // would be *main.ListNode
