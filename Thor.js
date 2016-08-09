var inputs = readline().split(' ');
var endx = parseInt(inputs[0]); // the X position of the light of power
var endy = parseInt(inputs[1]); // the Y position of the light of power
var x = parseInt(inputs[2]); // Thor's starting X position
var y = parseInt(inputs[3]); // Thor's starting Y position
var newx = x;
var newy = y;
// game loop
while (true) {
    var remainingTurns = parseInt(readline()); // The remaining amount of turns Thor can move. Do not remove this line.
    var h="";
    var v="";
    
    if (newx!=endx){
        if (x>endx){
            h='W';
            newx= newx-1;}
            else{
                h='E';
                newx=newx+1}
        }
    if (newy!=endy){
        if (y>endy){
            v='N';
            newy=newy-1;
            }else{
                v='S';
                newy=newy+1;}
        }
        

    // A single line providing the move to be made: N NE E SE S SW W or NW
    print(v+h);
}

