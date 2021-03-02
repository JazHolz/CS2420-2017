/******************************************************************************
 *  Partner Names:  Garret Rueckert   Laurel Miller   Jazmine Mehri Lavasani
 *  NetID:    
 *  Precept:  
 *    
 *
 *  Hours to complete assignment (optional): 11 hours
 *
 ******************************************************************************/

Programming Assignment 5: Kd-Trees


/******************************************************************************
 *  Describe the Node data type you used to implement the
 *  2d-tree data structure.
 *****************************************************************************/
	Node is a private class with the following fields: point <Point2D>, val <Value>,
rect <RectHV>, and 2 Nodes called left and right. The constructor takes a Point2D,
Value, and RectHV as arguments, and sets the respective fields to those values passed.
/******************************************************************************
 *  Describe your method for range search in a kd-tree.
 *****************************************************************************/
	The range method is comprised of two methods (one being a private helper method).
The public mtheod takes one RectHV (checking first that it is not null) and returns 
an Iterable<Point2D> if the points are inside the rectangle's bounds. A queue is created
internally for the Iterable<Point2D>, and is what is returned by the method.

	The private helper method takes a RectHV, Queue<Point2D>, and a Node as arguments 
and first checks if the node is null; it will stop if so. If the rectangle does not
the node's rectangle it also will stop. If the rectangle does contain the node.point,
it will enque the node's point onto the Queue (given from public range method) and then 
recursively call range on the left and right Nodes from the node passed. 

/******************************************************************************
 *  Describe your method for nearest neighbor search in a kd-tree.
 *****************************************************************************/
	Method nearest is similarly implemented with a public method and a private helper
method. The public method takes a Point2D for the argument, checks if it is null; then 
returns a Point2D that comes from the private method, which is called as nearest(p, root, root.point) 
inside the public method.

	The private helper method takes a Point2D (p), Node (node), and a Point2D (winningPoint)
for the arguments. If the node is null, the winningPoint is returned; if the distance
from the node's rectangle to the point p is greater than the winningPoint's distance to the
point p, it will also just return the winningPoint. If the point p's distance to the node's point
is less than the distance from the point p to winningPoint, winningPoint is set to the node's point.

	If the left node is not null, and the left node's (from the initial node) rectangle contains the
point p, we recursively call nearest on the left node and then the right node and setting winningPoint
to the correct nearest point. Similarly if the if-statement fails, it calls nearest on the right node 
then the left node, setting winningPoint correctly again. At the end, winningPoint is returned.	
/******************************************************************************
 *  How many nearest neighbor calculations can your brute-force
 *  implementation perform per second for input100K.txt (100,000 points)
 *  and input1M.txt (1 million points), where the query points are
 *  random points in the unit square? Show the math how you used to determine
 *  the operations per second. (Do not count the time to read in the points
 *  or to build the 2d-tree.)
 *
 *  Repeat the question but with the 2d-tree implementation.
 *****************************************************************************/

                       calls to nearest() per second
                     brute force               2d-tree
                     ---------------------------------
input100K.txt  
PointST:        		         KdTree: 
 Total time: 2.544 AvgPerSecond: 196.54	   Total time: 17.646 AvgPerSecond: 566700.67

input1M.txt 
PointST:                                 KdTree:
 Total time: 40.772 AvgPerSecond: 12.26     Total time: 34.647 AvgPerSecond: 288625.28


/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/


/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/

	Garret- PointST, readme, Node
	
	Jazmine- KdTreeST structure & most methods, Javadoc work 
	
	Laurel- test-client hook-up, Javadoc work, JUnit test fixes, and the nearest neighbor calculations.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on  how helpful the class meeting was and on how much you learned 
 * from doing the assignment, and whether you enjoyed doing it.
 *****************************************************************************/
