var inputs = readline().split(' ');
var endx = parseInt(inputs[0]); // the X position of the light of power
var endy = parseInt(inputs[1]); // the Y position of the light of power
var x = parseInt(inputs[2]); // Thor's starting X position
var y = parseInt(inputs[3]); // Thor's starting Y position
var newx = x; // Thor's updated position 
var newy = y;
// game loop
while (true) {
    var remainingTurns = parseInt(readline()); // The remaining amount of turns Thor can move. Do not remove this line.
    var h=""; //char of horizontal movement
    var v=""; //char of vertical movement
    
    if (newx!=endx){ // if x and endx are equal, no need to move W nor E
        if (x>endx){
            h='W';
            newx= newx-1;} // update new X possition
            else{
                h='E';
                newx=newx+1} // update new X possition
        }
    if (newy!=endy){ // if y and endy are equal, no need to move N nor S
        if (y>endy){
            v='N';
            newy=newy-1; // update new Y possition
            }else{
                v='S';
                newy=newy+1;} // update new Y possition
        }
    print(v+h);
}

