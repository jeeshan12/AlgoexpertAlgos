package bst;

public class ClosestValueBST {
  public static int findClosestValueInBst(BST tree, int target) {

    return findClosestValueInBst(tree, target, tree.value);

  }

  private static int findClosestValueInBst(BST tree, int target, int closest) {

    if (tree == null ) return closest;

    if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
      closest = tree.value;
    }

    if (target > tree.value) {
      return findClosestValueInBst(tree.right, target, closest);
    } else if (target < tree.value) {
      return findClosestValueInBst(tree.left, target, closest);
    } else {
      return closest;
    }

  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
