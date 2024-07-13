import java.util.*;

public class survivedRobotsHealths {
    // Custom comparator to sort robots by position
    private static class RobotComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            robots.add(new int[]{i, positions[i], healths[i], directions.charAt(i) == 'L' ? 0 : 1});
        }

        // Sort robots by position
        robots.sort(new RobotComparator());

        Deque<int[]> stack = new ArrayDeque<>(); // Stack to manage robots moving right
        int[] finalHealths = new int[n]; // Array to store the final healths of robots

        for (int[] robot : robots) {
            if (robot[3] == 1) { // Robot is moving right
                stack.push(robot);
                finalHealths[robot[0]] = 0; // Initially assume the robot will be involved in a collision
            } else { // Robot is moving left
                while (!stack.isEmpty() && robot[2] > 0) {
                    int[] rightRobot = stack.pop();
                    if (rightRobot[2] > robot[2]) {
                        rightRobot[2] -= 1; // Reduce health of the right-moving robot by 1
                        stack.push(rightRobot); // Put the right-moving robot back on the stack
                        robot[2] = 0; // The left-moving robot is destroyed
                    } else if (rightRobot[2] < robot[2]) {
                        robot[2] -= 1; // Reduce health of the left-moving robot by 1
                        // The right-moving robot is destroyed, continue checking collisions for the left-moving robot
                    } else {
                        // Both robots have the same health and destroy each other
                        robot[2] = 0;
                    }
                }
                if (robot[2] > 0) {
                    finalHealths[robot[0]] = robot[2]; // The left-moving robot survives
                }
            }
        }

        // Remaining robots in stack are survivors
        while (!stack.isEmpty()) {
            int[] survivor = stack.pop();
            finalHealths[survivor[0]] = survivor[2];
        }

        // Prepare the result list
        List<Integer> result = new ArrayList<>();
        for (int health : finalHealths) {
            if (health > 0) {
                result.add(health);
            }
        }

        return result;
    }
}
