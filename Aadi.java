class Aadi {

	public static void insert(int [][][] sud, int x, int y, int num){
		for ( int i = 0; i  < 9, i++){
			sud [x][i][num] = 1; // 1 -- means already used (not availible at this position
			sud [i][y][num] = 1;
		}
		int diagX =  3* (x/3) ; // using round down division to get the starting index of the sub box
		int diagY =  3* (y/3) ;
		for ( int i = diagX; i < diagX + 3; i ++){
			for (int j = diagY; j < diagY + 3; j++){

				sud[i][j][num] = 1;
			}
		} 

	}



}
