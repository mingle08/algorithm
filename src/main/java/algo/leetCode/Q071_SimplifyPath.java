package algo.leetCode;

import java.util.LinkedList;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 click to show corner cases.

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Q071_SimplifyPath {

    public static void main(String[] args){
        Q071_SimplifyPath solution = new Q071_SimplifyPath();
        
        String path = "/a/./b/../../c/";
        String res = solution.simplifyPath(path);
        System.out.println(res);
    }

    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        LinkedList<String> stack = new LinkedList<String>();
        String[] strs = path.split("/");
        for (String s:strs){
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.removeLast();
                }
            } else if(!s.equals("") && !s.equals(".")){
                stack.add(s);
            }
        }
        for (String s:stack){
            sb.append(s + "/");
        }
        if (!stack.isEmpty()){
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }


}
