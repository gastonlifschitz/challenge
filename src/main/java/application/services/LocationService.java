package application.services;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

public class LocationService {
    public static double[] getLocation(double[][] positions, double[] distances){
        //Trilateration: https://es.wikipedia.org/wiki/Trilateraci%C3%B3n#:~:text=La%20trilateraci%C3%B3n%20es%20un%20m%C3%A9todo,forma%20an%C3%A1loga%20a%20la%20triangulaci%C3%B3n.
        //https://www.codota.com/code/java/classes/com.lemmingapex.trilateration.TrilaterationFunction
        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
        NonLinearLeastSquaresSolver nonLinearLeastSquaresSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());
        return  nonLinearLeastSquaresSolver.solve()
                .getPoint().toArray();
    }
}
