class PaintFill {

	static enum Color {
		Red, Blue, Green
	}

	static boolean paintFill(Color [][] screen, int x, int y, Color oldColor, Color newColor) {
		if( x < 0 || x >= screen[0].length ||
				y < 0 || y >= screen.length)
			return false;
		if(screen[y][x] == oldColor) {
			screen[y][x] = newColor;
			paintFill(screen, x-1, y , oldColor, newColor);
			paintFill(screen, x+1, y , oldColor, newColor);
			paintFill(screen, x, y+1 , oldColor, newColor);
			paintFill(screen, x, y-1 , oldColor, newColor);
		}
		return true;
	}

	static boolean paintFill(Color [][] screen, int x, int y, Color newColor) {
		if(screen[y][x] == newColor)
			return false;
		else
			return paintFill(screen,x,y,screen[y][x],newColor);
	}

	public static void main(String[] args) {

		Color [][] screen = {{Color.Red, Color.Blue, Color.Green},
							 {Color.Red, Color.Red, Color.Red},
							 {Color.Green, Color.Blue, Color.Red}
							};

		System.out.println(paintFill(screen, 1,1, Color.Blue));
		
	}
}