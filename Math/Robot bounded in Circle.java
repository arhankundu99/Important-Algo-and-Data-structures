//https://leetcode.com/problems/robot-bounded-in-circle/

​class Solution {
    public boolean isRobotBounded(String instructions) {
        
        //now lets consider the initial position as (x, y)
        //let final position be (x + a, y + b) after following the instructions
        
        //CASE1: let final direction be north
        //if final position is not equal to (0, 0), return false because we will keep on
        //moving to the north if we keep on following the instructions.
        
        //if final position is (0, 0), return true
        
        //CASE2: let final direction be east
        //then after following the instructions again, the final position will be ((x + a) + b, (y + b) - a)
        //and the final direction will be south
        
        //after following the instructions again, the final position will be
        //((x + a + b) - a, (y + b - a) - b) = (x + b, y - a) 
        //and final direction will be west
        
        //after following the instructions again, the final position will be
        //((x + b) - b, (y - a) + a) = (x, y)
        //and final direction is north. 
        //Notice that we returned to our initial position and initial direction
        
        //CASE3: let final direction be west (Same case as final direction as east)
        
        //CASE4: let final direction be south
        //after following the instructions again, 
        //the final position will be ((x + a) - a, (y + b) - b) = (x, y)
        //and final direction will be north. We have returned to our initial position
        
        //From all the 4 cases, we can conclude that after following the instructions once
        //if the final direction is not north, return true
        //else if the final direction is north and final pos is (0, 0), return true
        //else return false
        
        
        int x = 0, y = 0, dir = 1; //dir = 1 for north, 2 for east, 3 for south and 4 for west
        
        for(int i = 0; i < instructions.length(); i++){
            char instruction = instructions.charAt(i);
            
            if(instruction == 'G'){
                if(dir == 1)y += 1;
                else if(dir == 2)x += 1;
                else if(dir == 3)y -= 1;
                else x -= 1;
            }
            else if(instruction == 'L'){
                if(dir == 1)dir = 4;
                else dir = dir - 1;
            }
            else{
                if(dir == 4)dir = 1;
                else dir = dir + 1;
            }
        }
        
        return (x == 0 && y == 0) || dir != 1;
    }
}
