class Solution {
    public String simplifyPath(String path) {
        // Split by one or more slashes
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String directory : components) {
            // 1. If it's empty (from //) or a single dot (.), do nothing
            if (directory.isEmpty() || directory.equals(".")) {
                continue;
            }
            
            // 2. If it's "..", go up one level by popping the stack
            if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            // 3. Otherwise, it's a valid directory name
            else {
                stack.push(directory);
            }
        }

        // Build the final string
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        // Return "/" if the stack is empty, otherwise the built path
        return sb.length() == 0 ? "/" : sb.toString();
    }
}