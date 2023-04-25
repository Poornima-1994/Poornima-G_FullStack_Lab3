package com.greatlearning.sumpair;

import java.util.HashSet;
import java.util.Set;

public class SumPair {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		root.insertData(20, root);
		root.insertData(60, root);
		root.insertData(10, root);
		root.insertData(30, root);
		root.insertData(50, root);
		root.insertData(70, root);
		int sum = 130;
		Set <Integer> data = new HashSet<Integer>();
		if(!findSumPair(root,sum,data)) {
			System.out.println("pair does not exists for given sum");
		}
	}

	/*
	 * In order traversal--
	 * if (remainder is already present in the set),then we print the pair
	 * (i.e) if processing 10 for a sum = 130, then check reminder (120) is present
	 * else add the element in the set.	
	 */
	private static boolean findSumPair(TreeNode root,int sum,Set<Integer> data) {
		//Base condition to come out of recursive.
		if (root == null) {
			return false;
		}
		//Process the left 
		if(findSumPair(root.left,sum,data)) {
			return true;
		}
		//Process the Root
		int remainder = sum - root.data;
		if(data.contains(remainder)) {
			System.out.println("The Pair("+root.data+","+remainder+")can form the given sum");
			return true;
		}else {
			data.add(root.data);
		}
	    //process the Right
		return findSumPair(root.right,sum,data);
	}
}
