package se283.lab.junit;

/**
 * A class that can compute the mean or standard deviation as integers.
 * 
 * @author: Anonymous
 */

public class Stats {

    private int[] _numbers;

    /**
     * Create a Stats object with a set of integers
     * 
     * @param intNumbers An array of integers, on which means or standard
     *                   deviations could be computed.
     */
    public Stats(int[] intNumbers) {
        _numbers = intNumbers;
    }

    /**
     * A private method to calculate mean of ints stored in numbers and return
     * the value as a double
     * 
     * @return The mean of the list of numbers that the Stats object maintains.
     */
    private double mean() {

        if (_numbers.length == 0) { 
            throw new RuntimeException("Empty input"); 
        }
        double sum = 0;

        for (int i = 0; i < _numbers.length; i++) {
            if (_numbers[i] < 0) { 
                throw new RuntimeException("Input should be non-negative integer"); 
            }
            sum = sum + _numbers[i];
        }

        return sum / _numbers.length;
    }

    /**
     * Return the rounded int value of mean
     */
    public int getMean() {
        return (int) (mean() + 0.5);
    }

    /**
     * Calculate standard deviation of ints stored in numbers and return the
     * rounded int value
     * 
     * @return The mean of the list of numbers that the Stats object maintains.
     */
    public int getStdDevn() {
    	double mean = mean();
    	double stdDevn = 0;
    	
    	for (int i = 0; i < _numbers.length; i++) {
    		stdDevn += Math.pow(_numbers[i] - mean, (double) 2);
    	}
    	
    	stdDevn /= _numbers.length;
    	stdDevn = Math.sqrt(stdDevn);
    	
    	return (int) (stdDevn+0.5);
    }
}
