public final class Random
{
    private static java.util.Random RANDOM = new java.util.Random();

    /**
     * Sets the starting seed value for this Random class.
     * This is the value used when calculating more random
     * numbers, and by seeding to a specific number you can
     * generate the same series of random number.
     * @param seed The long value to seed this too.
     */
    public static void seed(long seed)
    {
        RANDOM.setSeed( seed );
    }

    /**
     * @param maximum The maximum long to return (exclusive), cannot be less then 0.
     * @return A random long value from 0 to the maximum.
     */
    public static long random(long maximum)
    {
        return random(0l, maximum);
    }

    /**
     * @param minimum The minimun random number, inclusively.
     * @param maximum The maximum random number, exclusively.
     * @return A number greater or equal to minimum, less then maximum.
     */
    public static long random(long minimum, long maximum)
    {
        if(maximum-minimum != 0) {
            return (long) (RANDOM.nextDouble()*(maximum-minimum) + minimum);
        } else {
            return 0;
        }
    }

    /**
     * @param maximum The maximum double to return (exclusive), cannot be less then 0.
     * @return A random double value from 0 to the maximum.
     */
    public static double random(double maximum)
    {
        return random(0.0, maximum);
    }

    /**
     * @param minimum The minimun random number, inclusively.
     * @param maximum The maximum random number, exclusively.
     * @return A number greater or equal to minimum, less then maximum.
     */
    public static double random(double minimum, double maximum)
    {
        if(maximum-minimum != 0) {
            return RANDOM.nextDouble()*(maximum-minimum) + minimum;
        } else {
            return 0.0;
        }
    }

    /**
     * @param maximum The maximum float to return (exclusive), cannot be less then 0.
     * @return A random float value from 0 to the maximum.
     */
    public static float random(float maximum)
    {
        return random(0.0f, maximum);
    }

    /**
     * @param minimum The minimun random number, inclusively.
     * @param maximum The maximum random number, exclusively.
     * @return A number greater or equal to minimum, less then maximum.
     */
    public static float random(float minimum, float maximum)
    {
        if(maximum-minimum != 0) {
            return randomFloat()*(maximum-minimum) + minimum;
        } else {
            return 0;
        }
    }

    /**
     * @param maximum The maximum int to return (exclusive), cannot be less then 0.
     * @return A random integer value from 0 to the maximum.
     */
    public static int random(int maximum)
    {
        return RANDOM.nextInt( maximum );
    }

    /**
     * @param minimum The minimun random number, inclusively.
     * @param maximum The maximum random number, exclusively.
     * @return A number greater or equal to minimum, less then maximum.
     */
    public static int random(int minimum, int maximum)
    {
        if(maximum-minimum != 0) {
            return random(maximum-minimum) + minimum;
        } else {
            return 0;
        }
    }

    /**
     * Returns a boolean based on the given chance. The number of chances is
     * from 0 to chance.
     *
     * i.e. if you pass in 10 there is a 1 in 10 chance of returning true.
     *
     * If 0 is passed in then true is guaranteed to return.
     * @param chance The chance to return true, cannot be negative.
     * @return Randomly true or false where it is based on the given chance.
     */
    public static boolean randomBoolean(int chance)
    {
        if (chance < 0) {
            throw new IllegalArgumentException("The given chance must be greater, or equal, to 0.");
        }

        return random(0, chance) == 0;
    }

    /**
     * @return Randomly returns either a True or False.
     */
    public static final boolean randomBoolean()
    {
        return randomInt() > 0;
    }

    /**
     * @return A random float value.
     */
    public static final float randomFloat()
    {
        return RANDOM.nextFloat();
    }

    /**
     * @return A random double value between 0 and 1.
     */
    public static double randomDouble()
    {
        return RANDOM.nextDouble();
    }

    /**
     * @return A random integer value.
     */
    public static int randomInt()
    {
        return RANDOM.nextInt();
    }

    /**
     * @return A random long value.
     */
    public static double randomLong()
    {
        return RANDOM.nextLong();
    }

    /**
     * @return A random short value between Short.MIN_VALUE and Short.MAX_VALUE.
     */
    public static short randomShort()
    {
        return (short) random(Short.MIN_VALUE, Short.MAX_VALUE+1);
    }

    /**
     * @return A random byte value between Byte.MIN_VALUE and Byte.MAX_VALUE.
     */
    public static byte randomByte()
    {
        return (byte) random(Byte.MIN_VALUE, Byte.MAX_VALUE+1);
    }
    
    /**
     * This is for retreiving a random angle from 0 to 360 degrees, but as a
     * radian.
     * @return A random radian value between 0 and 2*Pi
     */
    public static float randomRadian()
    {
        return random( (float)Math.PI * 2 );
    }

    /**
     * The same as the other randomIndexes method, only it is from 0 to max.
     * @param max The upper value of the range to return.
     * @return A range of indexes from 0 (inclusive) to max (exclusive), all randomly jumbled around.
     */
    public static int[] randomIndexes(int max)
    {
        return randomIndexes( 0, max );
    }

    /**
     * Creates an array of integers from min to max, but all randomly moved
     * around.
     *
     * This is created for times when you want to randomly pick out the values
     * within a range, but only ever pick each index once. You can use the
     * values returned from this in order to do that.
     *
     * The range is from min (inclusive) to max (exclusive). So min is included
     * in the range returned, but not max.
     *
     * @param min The lower value of the random indexes to return.
     * @param max The upper value of the random indexes to return, cannot be less then min.
     * @return A range of indexes from min to max, all randomly moved about.
     */
    public static int[] randomIndexes(int min, int max)
    {
        if ( max < min ) {
            throw new IllegalArgumentException("Max cannot be less then min, given min: " + min + ", max: " + max);
        }

        final int size = max-min;
        final int[] ints = new int[size];

        // fill ints with the range of numbers
        for ( int i = 0; i < size; i++ ) {
            ints[i] = min+i;
        }

        // randomly swap indexes
        for ( int i = 0; i < size; i++ ) {
            final int j = Random.random(0, size);
            final int temp = ints[i];
            
            ints[i] = ints[j];
            ints[j] = temp;
        }
        
        return ints;
    }
    
    /**
     * This class has no constructor.
     */
    private Random() { }
}