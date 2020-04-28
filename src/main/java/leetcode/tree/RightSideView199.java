package leetcode.tree;

import com.google.common.collect.Lists;

import java.util.List;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-22<p>
// 注释说明
// -------------------------------------------------------
public class RightSideView199 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        a1.right = a2;
        a2.left = a3;
        a2.right = a4;
        a3.left = a5;

        List<Integer> res = new RightSideView199().rightSideView(a1);
        System.out.println(res);

    }

    List<Integer> result = Lists.newArrayList();

    int nowHight = 0;

    public List<Integer> rightSideView(TreeNode root) {
        visit(root, 0);
        return result;
    }

    void visit(TreeNode node, int high) {
        int thisHight = high + 1;
        if (thisHight > nowHight) {
            result.add(node.val);
            nowHight = thisHight;
        }

        if (node.right != null) {
            visit(node.right, high + 1);
        }
        if (node.left != null) {
            visit(node.left, high + 1);
        }
    }

}
