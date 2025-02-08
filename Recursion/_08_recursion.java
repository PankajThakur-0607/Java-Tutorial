public class _08_recursion {

    public static void subSequence(int arr[], int index, StringBuilder seq) {
        if (index == arr.length) {
            System.out.println(seq);
            return;
        }

        seq.append(arr[index]);
        subSequence(arr, index + 1, seq);
        seq.deleteCharAt(seq.length() - 1);
        subSequence(arr, index + 1, seq);

    }

    public static void subSequence_V2(int arr[], int index, String seq) {
        if (index == arr.length) {
            System.out.println(seq);
            return;
        }

        seq += arr[index];
        subSequence_V2(arr, index + 1, seq);
        seq = seq.substring(0, seq.length() - 1);
        subSequence_V2(arr, index + 1, seq);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        // subSequence(arr, 0, new StringBuilder());
        subSequence_V2(arr, 0, "");
    }
}
