package MediumLevelProblems;

public class LC_3147_MaxEnergyInDungon {

    // O(n*n) && O(n)

    public static int getMaxEnergy(int energy[], int k, int index, int n) {
        if (index >= n) {
            return 0;
        }

        int currEnergy = energy[index] + getMaxEnergy(energy, k, index + k, n);

        return currEnergy;
    }


    public static int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int maximumEnergy = Integer.MIN_VALUE;
        for (int jump = 0; jump < n; jump++) {
            int currEnergy = energy[jump] + getMaxEnergy(energy, k, jump + k, n);
            maximumEnergy = Math.max(maximumEnergy, currEnergy);
        }
        return maximumEnergy;
    }

    
    public static void main(String[] args) {
        int energy[] = { -2, -3, -1 };
        int k = 2;

        System.out.println(maximumEnergy(energy, k));
    }
}
