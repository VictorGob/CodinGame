var road = parseInt(readline()); // the length of the road before the gap.
var gap = parseInt(readline()); // the length of the gap.
var platform = parseInt(readline()); // the length of the landing platform.
var j = false; // jump?
// game loop
while (true) {
    var speed = parseInt(readline()); // the motorbike's speed.
    var x = parseInt(readline()); // the position on the road of the motorbike.
    var res="WAIT"; // option by default
    if (gap>speed-1){res="SPEED";}//speed must be gap+1
    if (gap+1<speed){res="SLOW";}
    if (x==road-1 && j===false){res="JUMP";j=true;}//condition for only 1 jump
    if (x>(road-1+gap)){res="SLOW";}//once landed (road-1+gap), SLOW

    print(res);
}
