var L = parseInt(readline());//width
var H = parseInt(readline());//height
var T = readline();
T=T.toUpperCase();
T=T.replace(/ /g,"");
var base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
var textRow=[];
var textPos=[];
var textOut="";
//var m=L;
var sym="";
//leemos el abecedario en símbolos
for (var i = 0; i <= H; i++) {
    var ROW = readline();
        textRow.push(ROW);
}
//creamos array con las posiciones de cada letra del texto a escribir
for (var i=0; i<T.length ; i++){
    var pos= base.search(T[i]);
    if(pos==-1){
        pos=26;}
    textPos.push(pos);
}
// creamos y rellenamos el string, linea a linea de texto
for (var i=0; i<H; i++){//escritura a cada linea
    for ( var j=0; j<L*textPos.length; j++){
        pos=j%L;
        sym=textPos[Math.floor(j/L)]*L+pos;
        textOut+=String(textRow[i][sym]);
        if(j==L*T.length-1){
                textOut+="\n";
                }
    }    
}
print(textOut);