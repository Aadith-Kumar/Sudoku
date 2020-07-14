class Aadi {

    public static void insert(int [][][] sud, int x, int y, int num){
        
        sud[x][y][0] = num;
        for ( int i = 0; i  < 9;i++){
            sud [x][i][num] = 1; // 1 -- means already used (not availible at this position
            sud [i][y][num] = 1;
            sud [x][y][i+1] =1 ;
        }
       
        int diagX =  3* (x/3) ; // using round down division to get the starting index of the sub box
        int diagY =  3* (y/3) ;
        for ( int i = diagX; i < diagX + 3; i ++){
            for (int j = diagY; j < diagY + 3; j++){

                sud[i][j][num] = 1;
            }
        } 

    }

    public static void printSudoku (int [][][] sud){
        for ( int i = 0; i < sud.length; i ++){
            for ( int k = 0; k  < sud[i].length; k ++){
                if(sud[i][k][0] == 0) System.out.print ( "  | ");
                else System.out.print ( sud[i][k][0] + " | ");
            }
            System.out.println();
            System.out.println("-----------------------------------");
        }
        
    }
    
    public static int[][][] createBlank(){
        int[][][] sud = new int [9][9][10];
        for ( int i = 0; i < sud.length; i ++){
            for ( int k = 0; k  < sud[i].length; k ++){
                for(int j = 0; j < sud[i][k].length; j++){
          
                    sud[i][k][j] =0;
                }
                
            }
            
        }
        return sud;
    }

    
    public static int[][][] main(String[] args){
      int[][][] sud = createBlank();
      insert(sud,2,2,3);
      printSudoku(sud);
      return sud;
        
    }
}
