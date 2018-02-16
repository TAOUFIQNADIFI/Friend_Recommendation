Overview:friend recommendation based on number of mutual  friends.

 “For user X, who is the best person to recommend as a friend?”  A simple way to state this question is, 
If non-friend Y is your friend's friend, then maybe Y should be your friend too. 
If person Y is the friend of many of your friends, then Y is an even better recommendation. 
The best friend recommendation is the person with whom you have the largest number of mutual friends. 
The following is an input example. The relationships between user and user can be understood easier in the graph.


0    1,2,3
1    0,2,3,4,5
2    0,1,4
3    0,1,4
4    1,2,3
5    1,6
6    5

In the graph, you can see user 0 is not friend of users 4 and 5, but user 0 and user 4 have mutual friends 1, 2, and 3; 
user 0 and user 5 have mutual friend 1.
As  result, we would like to recommend users 4 and 5 as friends of user 0.

==========================================================================

Data:
"blogCatalog.com" dataset .
 link:  http://socialcomputing.asu.edu/datasets/BlogCatalog
==========================================================================

Questions:
part 1: “For user X, what is the list of  person to recommend as a friend?
part 2 : what is the best friend based on the number of mutual friends?

==========================================================================


4. Algorithms, Data Structures, and Answer to your Question:
part 1:
creat a Map , the key is the person id and the value is number of common friends. 
for a person X get his friend list "a".
for every person in this get also his friend list "b".
add to the Map  person in the list "b" is not friend with X.
 and increment by 1 the value .
part 2:
add a fuction sortHashMapByValues to sort by value the Map of potential friends.

==========================================================================

5. Algorithm analysis:
All pairs of friends of a user would be O(|V|^2) since the most friends
one user has is all friends (|V|) and we’re considering all pairings of them.
if person A is highly selective in terms of friendship, and is a friend of yours, 
you are likely to have a lot in common with A's other friend. On the other hand,
 if person  B is indiscriminate and there is little reason to believe that you should be friendly 
with any particular one of B's other friends.

==========================================================================

6. Correctness verification (i.e. testing):

I used small files that I create using google sheets to test my code.
And I wrote a class "test"  to test the code.
the first result didn't match with the expected result.
after modifing the function that  "sortHashMapByValues" the result match the expected result for all files.

==========================================================================

 code overview 
Class 1 : Graph interface. 
this interface Contains four methods:addEdge(int a, int b) : Adds edge to the graph.addVertex(int a): Adds vertex to the graph.bestFriendsRec(int center, int num) return number of friends with most common friendsfriendsRec(int): return  all potential friend.
class 2  CapGraph() implement Graph interface:

CapGraph() constructor addEdge(int, int) Adds edge to the graph.addVertex(int)  Adds vertex to the graph.bestFriendsRec(int, int)   number of friends with most common friendsfriendsRec(int) all potential friend.getListOfVertices() graph list of vertices.getNeighbors(int) get list of friends.sortHashMapByValues(HashMap<Integer, Integer>) sort hashmap by value.
class 3 Graph loader.
graphLoader(String) constructor. LoadGraph() Transfer the data from the folder to the graph.
class 4 Test.
main(String[]) to test the code.






