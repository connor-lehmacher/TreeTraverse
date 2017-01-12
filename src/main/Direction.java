package main;

public enum Direction {
	Up, Down, Left, Right, None;
	
	public Direction rotate() {
		if(this == Up) {
			return Right;
		}else
		if(this == Right) {
			return Down;
		}else
		if(this == Down) {
			return Left;
		}else {
			return Up;
		}
	}
}
