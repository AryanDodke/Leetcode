class Solution {
    public int countSeniors(String[] details) {
        int count = 0;

        for (String detail : details) {
            // Extract the age part from the string
            String ageString = detail.substring(11, 13);
            int age = Integer.parseInt(ageString);

            // Check if the age is strictly greater than 60
            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}
