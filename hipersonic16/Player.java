//package hipersonic16;

import java.util.*;
import java.awt.Point;

class Mapa{
    String[][] map;
    int maxY;
    int maxX;
    int px;
    int py;

    public Mapa(String[][] map, int px, int py) {
        this.map = map;
        this.maxY = this.map.length;
        this.maxX = this.map[0].length;
        this.px = px;
        this.py = py;
    }
    public String[][] getMap() {
        return map;
    }
    public int valorMapa(int y, int x){
        try{
            int valor = Integer.parseInt(map[y][x]);
            return valor;
        }catch(NumberFormatException ex){
            return -2;        
        }
    }
    public void mapearCajas(){
        int i=0;
        int j=0;
        ondaExp(map);
        fow(map);
        System.err.println("maxDim y-x: "+maxY+" "+maxX);
        for(i=0; i<maxX; i++){
            for(j=0; j<maxY; j++){
                if(map[j][i].equals("-")){//cambiado a "-" por FOW
                    map[j][i] = String.valueOf(vecinos(j, i));
                }
            }
        }
    }
    public void ondaExp(String[][] mapa){
        for(int i=0; i<maxX; i++){
            for(int j=0; j<maxY; j++){
                if(map[j][i].contains("Q")){
                    for(int k=Math.max(0, j-2); k<=Math.min(maxY-1, j+2);k++){
                        if(!map[k][i].contains("Q")){
                            map[k][i]="q";
                        }
                    }
                    for(int m=Math.max(0, j-2); m<=Math.min(maxX-1, j+2);m++){
                        if(!map[j][m].contains("Q")){
                            map[j][m]="q";
                        }
                    }
                }
            }        
        }
    }
    public void fow(String[][] mapa){//fog of war- map fill
        // http://stackoverflow.com/questions/2783204/flood-fill-using-a-stack
        map[py][px]="-";
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(py, px));
            while(!queue.isEmpty()){
                Point p = queue.remove();
                int x = p.y;
                int y = p.x;
                if(map[y][x].equals("-")){
                    try{
                    if(map[y+1][x].equals(".")){
                        map[y+1][x]="-";
                        queue.add(new Point(y + 1, x));
                    }}catch(ArrayIndexOutOfBoundsException ex){}
                    try{
                    if(map[y-1][x].equals(".")){
                        map[y-1][x]="-";
                        queue.add(new Point(y - 1, x));
                    }}catch(ArrayIndexOutOfBoundsException ex){}
                    try{
                    if(map[y][x+1].equals(".")){
                        map[y][x+1]="-";
                        queue.add(new Point(y, x+1));
                    }}catch(ArrayIndexOutOfBoundsException ex){}
                    try{
                    if(map[y][x-1].equals(".")){
                        map[y][x-1]="-";
                        queue.add(new Point(y, x-1));
                    }}catch(ArrayIndexOutOfBoundsException ex){}
                    //System.err.println(queue.size());
                }
        }
        System.err.println("Mapeado fow");
        mostrar();
    }
    private int vecinos (int y, int x){
        int cantidad=0;
        int maxY = this.map.length;
        int maxX = this.map[0].length;
        ArrayList<String> listado = new ArrayList<>();
        for(int i=Math.max(x-2,0) ; i<=Math.min(x+2,maxX-1); i++ ){
            if(map[y][i].contains("B")){
                if(!listado.contains(String.valueOf(i+" "+y))){
                    listado.add(String.valueOf(i+" "+y));
                }
            }
        }
        for(int j=Math.max(y-2,0) ; j<=Math.min(y+2,maxY-1); j++ ){
            if(map[j][x].contains("B")){
                if(!listado.contains(String.valueOf(x+" "+j)))
                    listado.add(String.valueOf(x+" "+j));
            }
        }
        return listado.size();
    }
    public void mostrar(){
        for(int i=0; i<this.map.length; i++){
            System.err.println(Arrays.toString(this.map[i]));
        }
    }
    public Vector move(int rad){
        int max=0;
        int radio=rad;
        Vector destino=new Vector(px,py);
        do{
            for(int i=Math.max(0, px-radio); i<Math.min(maxX-1,px+radio); i++){
                for(int j=Math.max(0, py-radio); j<Math.min(maxY-1,py+radio); j++){
                    try{
                        int value = Integer.parseInt(map[j][i]);
                        if(value>max){
                            max=value;
                            destino = new Vector(i, j);
                        }
                    }catch(NumberFormatException nfe){
                    }finally{}
                }
            }
            radio++;
        }while(max==0 && radio<=Math.max(maxX, maxY));
        return destino;
    }
    public Vector dangerZone(){
        Vector destino=new Vector(px,py);
        int dist=55;
        if(map[py][px].contains("q") || map[py][px].contains("Q")){
            for(int i=Math.max(0, px); i<Math.min(maxX-1,px); i++){
                for(int j=Math.max(0, py); j<Math.min(maxY-1,py); j++){
                    int d=Math.abs(py-j)+Math.abs(px-i);
                    if(map[j][i].contains("-") && d<dist){
                        dist=d;
                        destino=new Vector(i,j);
                    }
                }
            }
            return destino;
        }else{
            return destino;
        }
    }
}
//Vector Class
class Vector {
    private int x;
    private int y;
    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
class Player {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        int myId = in.nextInt();
        in.nextLine();
        int px=0;// possition player
        int py=0;
        
        String[][] mapB = new String[height][];
        // game loop
        while (true) {
            for (int i = 0; i < height; i++) {
                String row = in.nextLine(); 
                // Replace "0" for B-ox
                String rowB = row.replace("1","B").replace("2","B");
                String[] rowA=rowB.replace("0", "B").split("");
                mapB[i]=rowA;
                //System.err.println(Arrays.toString(rowA));
            }
            int entities = in.nextInt();
            for (int i = 0; i < entities; i++) {
                int entityType = in.nextInt();
                int owner = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();
                int param1 = in.nextInt();
                int param2 = in.nextInt();
                // entity=1-> bomb; 2->item;
                if(entityType==0 && owner == myId){
                      px = x; py = y;
                      System.err.println("Posición "+px+" "+py);
                }
                if(entityType==1){
                    mapB[y][x]="Q";
                }
            }
            Mapa mapaBox = new Mapa(mapB, px, py);
            in.nextLine();
            mapaBox.mapearCajas();
            mapaBox.mostrar();
            Vector destino = mapaBox.move(3);
            System.err.println("Destino xy: "+destino.getX()+" "+destino.getY());
            String res = "MOVE";
            int valor = mapaBox.valorMapa(py, px);
            int valorDestino = mapaBox.valorMapa(destino.getY(), destino.getX());
            if((px==destino.getX() && py==destino.getY()) || ((valorDestino-1)==valor && valor>0)){
                res="BOMB";
                destino = mapaBox.dangerZone();
            }
            //MOVE or BOMB x y
            System.out.println(res+" "+destino.getX()+" "+destino.getY());
        }
    }
}
