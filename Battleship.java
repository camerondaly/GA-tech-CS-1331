import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("\n Welcome to Battleship! \n");
		int p1ShipsRemaining = 5;
		int p2ShipsRemaining = 5;

		// Initializes game boards and gets player' ship locations.
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
		String p1map[][] = initializeMap();
		for (int i = 1; i < p1map.length; i++) {
			getShipCoords(i, p1map, input);
		}
		printMap(p1map);
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
		System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
		String p2map[][] = initializeMap();
		for (int i = 1; i < p2map.length; i++) {
			getShipCoords(i, p2map, input);
		}
		printMap(p2map);
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}

		// Initializes representation of each player's target boards that they attack.
		String p1Targets[][] = initializeMap();
		String p2Targets[][] = initializeMap();
		String turn;

		// So long as both players have not had all ships sunk, each player takes turns making an attack.
		while ((p1ShipsRemaining > 0) && (p2ShipsRemaining > 0)) {
			turn = "Player 1";
			p2ShipsRemaining = getAttackCoords(turn, p2map, p1Targets, p2ShipsRemaining, input);
			printMap(p1Targets);
			if (p2ShipsRemaining == 0) {
				break;
			}
			turn = "Player 2";
			p1ShipsRemaining = getAttackCoords(turn, p1map, p2Targets, p1ShipsRemaining, input);
			printMap(p2Targets);
		}
		String winner = (p1ShipsRemaining == 0) ? "PLAYER 2" : "PLAYER 1";
		System.out.printf("%s WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS! \n\n\n Final boards: \n\n", winner);
		printMap(p1map);
		System.out.println();
		printMap(p2map);
		System.out.println();
	}

	public static int getAttackCoords(String playerNumber, String[][] otherPlayerMap, String[][] targetMap, int shipsRemaining, Scanner input) {
		System.out.printf("%s, enter hit row/column: \n", playerNumber);
		boolean valid = false;
		while (!valid) {
			int x;
			int y;
			if (input.hasNextInt()) {
				x = input.nextInt() + 1;
				if (input.hasNext()) {
					y = input.nextInt() + 1;
					if ((0 < x && x < targetMap.length) && (0 < y && y < targetMap[0].length)) {
						if ((otherPlayerMap[x][y] == "@ ") && (targetMap[x][y] == "- ")) {
							targetMap[x][y] = "X ";
							otherPlayerMap[x][y] = "X ";
							shipsRemaining -= 1;
							System.out.printf("%s HIT THE OTHER PLAYER'S SHIP! \n", playerNumber.toUpperCase());
							valid = true;
							continue;
						}
						if ((otherPlayerMap[x][y] == "- ") && (targetMap[x][y] == "- ")) {
							targetMap[x][y] = "O ";
							otherPlayerMap[x][y] = "O ";
							System.out.printf("%s MISSED! \n", playerNumber.toUpperCase());
							valid = true;
							continue;
						}
						if ((targetMap[x][y] == "X ") || (targetMap[x][y] == "O ")) {
							System.out.println("You already fired on this spot. Choose different coordinates.");
							continue;
						}
					}
				}
			}
			System.out.println("Invalid coordinates. Choose different coordinates:");
		}
		return shipsRemaining;
	}

	public static void getShipCoords(int shipnum, String[][] map, Scanner input) {
		System.out.printf("Enter ship %s location: \n", shipnum);
		boolean valid = false;
		while (!valid) {
			int x;
			int y;
			if (input.hasNextInt()) {
				x = input.nextInt() + 1;
				if (input.hasNext()) {
					y = input.nextInt() + 1;
					if ((0 < x && x < map.length) && (0 < y && y < map.length)) {
						if (map[x][y] != "@ ") {
							map[x][y] = "@ ";
							valid = true;
							return;
						}
					}
				}
			}
			System.out.println("Invalid coordinates. Choose different coordinates:");
		}
	}

	public static String[][] initializeMap() {
		String map[][] = new String[6][6];
		map[0][0] = "  ";
		for (int i = 1; i < 6; i++) {
			String number = Integer.toString(i - 1);
			map[0][i] = number + " ";
		}
		for (int j = 1; j < 6; j++) {
			String number = Integer.toString(j - 1);
			map[j][0] = number + " ";
		}
		for (int row = 1; row < 6; row++) {
			for (int col = 1; col < 6; col++) {
				map[row][col] = "- ";
			}
		}
		return map;
	}

	public static void printMap(String[][] map) {
		int rownum = map.length;
		int colnum = map[0].length;
		for (int r = 0; r < rownum; r++) {
			for (int c = 0; c < colnum; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

// Test cases:
// 0 0 1 1 2 2 3 3 4 4
// 0 0 0 1 0 2 0 3 0 4