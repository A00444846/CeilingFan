package ceilingFan;

import java.util.Scanner;

public class Fan {

	static class Direction {

		private static boolean isForward = true;

		static void changeDirection() {
			isForward = !isForward;
			System.out.printf("Dial direction is %s now.\n", isForward ? "Forward" : "Reverse");
		}
	}

	static class Speed {

		private static int speed = 0;

		static void changeSpeed() {
			if (Direction.isForward)
				speed++;
			else
				speed += 3;
			speed %= 4;

			if (Speed.speed == 0)
				System.out.printf("Fan is Off.\n");
			else
				System.out.printf("Fan Speed is changed to %s.\n", Speed.speed);
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {

			int pullCord;
			while (true) {
				System.out.println("1: Change Speed\n2: Change Direction\n(Enter any other number to exit)");
				System.out.print("which cord you want to pull(1 or 2): ");
				pullCord = scanner.nextInt();

				switch (pullCord) {
				case 1:
					Speed.changeSpeed();
					break;

				case 2:
					Direction.changeDirection();
					break;

				default:

					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

}
