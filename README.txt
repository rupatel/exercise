Approach:
1) The exercise state to find the shortest distance from start node to goal node in a chess board.
One option would be to use BFS to get the shortest distance from start node to goal node
However this would not be practical as the problem size increases since it end up exploring
nodes when are completely opposite direction of the goal node which is not good.
2) Other option is to use Best First search but it does not give us the optimal distance, though its fast.
3) I, thus choose A* since it best of both worlds: fast as Best First Search and gives us the optimal distance
as BFS.
4) I came up with following heuristics based on different Peice type:
1) Knight: Manhattan/3
since one step for knight is 3 manhattan block (1 in one direction and 2 in other),
I choose to divide by 3 since this would make sure not to over estimate the distance
to goal node (i.e admissible and consistent heuristic).
2) King: Manhattan/2
Similarly, one step for king is at worst is two manhattan blocks, and this heuristic would help us
not to overestimate the distance.
3) BISHOP:
I choose not to take any heuristic in this case since it seems that the goal node can be reached by
exploring two  levels down. So I will resort to BFS. It may be possible to mathematically find
admissible and consistent heuristic but BFS will do the trick.

Notice that the only case when we cannot reach goal node is in the case of BISHOP when
the color of goal node is opposite of the start node.
In case of the Knight and the King, this would never be the case since its intuitive to see that those pieces can
reach to any position in the board from anywhere!

I believe, heuristic, if used appropriately can drastically improve performance in search problems
and we end up exploring far less nodes compared to when we do not use them at all.
This implementation would be same as BFS if we choose our heuristic to be say, always 0.

Execution instruction:
Requirement: JDK installed System.
1) Unpack zip
2) cd to the directory where you unpack the zip.
3) cd chessSearch/target/classes
4) java com.apple.interview.exercise.chess.search.ChessSearch