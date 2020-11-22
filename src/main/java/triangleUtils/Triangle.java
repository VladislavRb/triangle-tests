package triangleUtils;

import triangleException.WrongInputException;

public class Triangle {
    public boolean isNumeric(Object obj) {
        return obj instanceof Double || obj instanceof Integer;
    }

    public double getMax(double x, double y, double z) {
        if(z > x && z > y) {
            return z;
        }

        return Math.max(x, y);

    }

    public boolean isTriangle(Object ...args) throws WrongInputException {
        if(args.length != 3) {
            throw new WrongInputException("3 arguments should be passed");
        }

        for(Object arg: args) {
            if(!this.isNumeric(arg)) {
                throw new WrongInputException("Wrong type of one ore more arguments");
            }
        }

        double x = args[0] instanceof Double ? (Double) args[0] : (Integer) args[0];
        double y = args[1] instanceof Double ? (Double) args[1] : (Integer) args[1];
        double z = args[2] instanceof Double ? (Double) args[2] : (Integer) args[2];

        if(x == 0 || y == 0 || z == 0) {
            throw new WrongInputException("A side value can't be equal to 0");
        }

        if(x < 0 || y < 0 || z < 0) {
            throw new WrongInputException("A side value can't be negative");
        }

        return x + y > z && x + z > y && y + z > x;
    }
}

