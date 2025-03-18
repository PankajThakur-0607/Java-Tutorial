package MediumLevelProblems;

public class LC_3259_Max_EnergyBoost {

    static int n;

    public static long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        n = energyDrinkA.length;
        long maxEnergy1 = helper(energyDrinkA, energyDrinkB, 0, true);
        System.out.println(maxEnergy1);
        long maxEnergy2 = helper(energyDrinkA, energyDrinkB, 0, false);

        return Math.max(maxEnergy1, maxEnergy2);
    }

    private static long helper(int[] energyDrinkA, int[] energyDrinkB, int index, boolean isArray) {
        if (index == n) {
            return 0;
        }

        long maxEnergy = 0;
        if (isArray) {
            maxEnergy = energyDrinkA[index] + helper(energyDrinkA, energyDrinkB, index + 1, true);
            maxEnergy = Math.max(maxEnergy, helper(energyDrinkA, energyDrinkB, index + 1, false));
        } else {
            maxEnergy = energyDrinkB[index] + helper(energyDrinkA, energyDrinkB, index + 1, false);
            maxEnergy = Math.max(maxEnergy, helper(energyDrinkA, energyDrinkB, index + 1, true));
        }
        return maxEnergy;
    }

    public static void main(String[] args) {
        int[] energyDrinkA = { 1, 2, 5 };
        int[] energyDrinkB = { 4, 2, 1 };
        System.out.println(maxEnergyBoost(energyDrinkA, energyDrinkB));
    }
}
