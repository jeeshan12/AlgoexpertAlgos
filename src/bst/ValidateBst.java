package bst;

public class ValidateBst {
  public static boolean validateBst(BST tree) {
    
    return validateBstHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean validateBstHelper(BST tree, int minValue, int maxValue) {

    if (tree == null) return true;

    if (tree.value < maxValue && tree.value >= minValue) return false;

    boolean leftSubtree = validateBstHelper(tree.left, minValue, tree.value);
    boolean rightSubtree = validateBstHelper(tree.right, tree.value, maxValue);

    return leftSubtree && rightSubtree;
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
