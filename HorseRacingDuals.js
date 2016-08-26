var N = parseInt(readline()); //read the Number of horses
var horses=[];
for (var i = 0; i < N; i++) {
    var pi = parseInt(readline()); //each strength
    horses.push(pi);
}
// list of horses, sorted from low to high
horses.sort(function(a,b){
    return a -b}); 
var diff=[];
// differences between each horse
for (var i=1; i<horses.length; i++){
    diff.push(horses[i]-horses[i-1]);
    }
// list of differences, sorted from low to high
diff.sort(function(a,b){
    return a -b});
//print the 1st one in DIFF array
print(diff[0]);

