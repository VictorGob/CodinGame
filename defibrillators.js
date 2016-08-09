{
var lonU = readline(); //long user
var latU = readline(); //lat user
var N = parseInt(readline());
var defib=[];
var a,x,y,d;
lonU = lonU.replace(/,/g, '.');
latU = latU.replace(/,/g, '.');
lonU = parseFloat(lonU);
latU = parseFloat(latU);
var dist=[];
var distMin;
for (var i = 0; i < N; i++) {
    defib[i]= readline();
}
for (var i=0; i<defib.length; i++){
    defib[i]= defib[i].replace(/,/g, ".");// All , to .
    defib[i]= defib[i].replace(";;","; ;");// Create a black for the phone (in example only)
    defib[i]= defib[i].toString();
    defib[i]= defib[i].split(";");
    }
for (var i=0; i<defib.length; i++){
    a=defib[i];
    x=(lonU-parseFloat(a[4]))*Math.cos((parseFloat(a[5])-latU)/2);
    y=latU-parseFloat(a[5]);
    d=Math.sqrt(x*x+y*y)*6371;
    dist.push(d);//create an array of distance
}
distMin=dist[0];
var j=0;
for (var i=1; i<dist.length; i++){
    if(distMin>dist[i]){
        distMin=dist[i];
        j=i;// take the possition of the minimun distance
    }
}
print(defib[j][1]);//print the name of the closest defibrilator
}
