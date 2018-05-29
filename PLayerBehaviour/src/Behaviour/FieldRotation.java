package Behaviour;

public class FieldRotation {

	int height = 6;
	int width = 7;
	int counter = 1;
	
	int board[][] = new int [height][width];
	
	
	
	
	public void printPlayerOnePOV() {
		
	for(int i=0;i<height; i++) {
			
		for(int j=0; j<width; j++) {
				
			board[i][j]=counter;
			counter ++;
			}
		
		
		}
	for(int k=0;k<height; k++) {
		
		for(int l=0; l<width; l++) {
			
			System.out.print(board[k][l] + " ");
		}
		System.out.println();
		
		}
	
	}
	public void printPlayerTwoPOV() {
		
		for(int i=height-1;i>=0; i--) {
			
			for(int j=width-1; j>=0; j--) {
				
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
			
		}
	}
	
	public static void main(String[]args) {
		
		FieldRotation field= new FieldRotation();
		field.printPlayerOnePOV();
		System.out.println();
		field.printPlayerTwoPOV();
	}
	
	
}
