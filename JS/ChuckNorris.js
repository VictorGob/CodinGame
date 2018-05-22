var M = readline();
var res="";
var code="";
var aux="";

// add al binary codeto 1 string
for (var i=0; i<M.length; i++){
    code=M.charCodeAt(i).toString(2);
    if(code.length<7){
        var zero="0";
        code=zero.concat(code);}
    res+=code;        
}
//function for translate to Chuck Norris Binary
function convertir(code){
    var a=code;
    var i=0;
    var auxa=[];
    var aux="";
    // "auxa" is an auxiliary array, where each group of same digits are show grouped
    // e.g. [1,0000,11]
    while (i<a.length){
        if(a[i]===a[i+1]){
            aux+=a[i];
            i++;
        }else{
            aux+=a[i];
            auxa.push(aux);
            aux="";            
            i++;
        }
    }
    //code for differentiating between zeros and ones
    aux="";
    for (var j=0; j<auxa.length; j++){
        a=auxa[j];
        a=a.split("");
        if(a[0]==="1"){
            aux+="0 ";
        }else{aux+="00 ";}
        // to fill the number of zeros or ones
        for (var k=0; k<a.length; k++){
            aux+="0";
        }
        aux+=" ";        
    }
    aux=aux.substr(0,aux.length-1);
    return aux;
}

res=convertir(res);      
    
print(res);
