/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Classes.BinaryTree;
import Classes.LinkedList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Variable declarations
        int[] testElements = {-500000, -400000,-300000,-200000,-100000,0,100000,200000,300000,400000,500000};
        int[] elements = new int[1000002];
        LinkedList ll = new LinkedList();
        LinkedList llord = new LinkedList();
        BinaryTree bt = new BinaryTree();
        BinaryTree btb = new BinaryTree();
        
        // Remove all text from the "output.csv" file so that new results can be recorded
        PopulateArray(elements);
        LimpaFicheiro();

        // Populates the Linked Lists and Binary Trees with the contents of the "elements" array
        for (int i = 0; i < elements.length; i++) {
            ll.addLast(elements[i]);
            llord.addOrd(elements[i]);
            bt.add(elements[i]);
            btb.add(elements[i]);
        }

        // Balances the binary tree using the DSW algorithm
        btb.balance();

        // Search Test
        EscreveLinha("\nSEARCH TEST\n");
        TestePesquisa(testElements, ll, llord, bt, btb);

        // Deletion Test
        EscreveLinha("\nDELETION TEST\n");
        TesteEliminacao(testElements, ll, llord, bt, btb);
    }

    // Performs the search test on the four data structures (Linked List, Ordered Linked List, Binary Tree, Balanced Binary Tree)
    private static void TestePesquisa(int[] testElements, LinkedList ll, LinkedList llord, BinaryTree bt, BinaryTree btb) {
        for (int i = 0; i < testElements.length; i++) {
            long startTime = System.nanoTime();
            long endTime;
            long duration;

            EscreveLinha("Element [" + testElements[i] + "] Linked List: " + ll.contains(testElements[i]));
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            EscreveLinha("Execution took " + duration + " nanoseconds.\n");

            startTime = System.nanoTime();
            EscreveLinha("Element [" + testElements[i] + "] Ordered Linked List: " + llord.contains(testElements[i]));
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            EscreveLinha("Execution took " + duration + " nanoseconds.\n");

            startTime = System.nanoTime();
            EscreveLinha("Element [" + testElements[i] + "] Binary Tree: " + bt.search(testElements[i]));
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            EscreveLinha("Execution took " + duration + " nanoseconds.\n");

            startTime = System.nanoTime();
            EscreveLinha("Element [" + testElements[i] + "] Balanced Binary Tree: " + btb.search(testElements[i]));
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            EscreveLinha("Execution took " + duration + " nanoseconds.\n");
        }
    }

    // Performs the deletion test on the four data structures (Linked List, Ordered Linked List, Binary Tree, Balanced Binary Tree)
    private static void TesteEliminacao(int[] testElements, LinkedList ll, LinkedList llord, BinaryTree bt, BinaryTree btb) {
        for (int i = 0; i < testElements.length; i++) {
            long startTime = System.nanoTime();
            long endTime;
            long duration;

            EscreveLinha("Element [" + testElements[i] + "] Linked List: " + ll.remove(testElements[i]));
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            EscreveLinha("Execution took " + duration + " nanoseconds.\n");

            startTime = System.nanoTime();
            EscreveLinha("Element [" + testElements[i] + "] Ordered Linked List: " + llord.remove(testElements[i]));
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            EscreveLinha("Execution took " + duration + " nanoseconds.\n");

            startTime = System.nanoTime();
            EscreveLinha("Element [" + testElements[i] + "] Binary Tree: " + bt.remove(testElements[i]));
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            EscreveLinha("Execution took " + duration + " nanoseconds.\n");

            startTime = System.nanoTime();
            EscreveLinha("Element [" + testElements[i] + "] Balanced Binary Tree: " + btb.remove(testElements[i]));
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            EscreveLinha("Execution took " + duration + " nanoseconds.\n");
        }
    }
    
    // Populates the "elements" array with the numbers from the "output.csv" file
    private static void PopulateArray(int[] elements) {
        File file = new File("C:\\Users\\Samuel Sampaio\\Desktop\\Luis2\\numeros.csv");
        Scanner input = null;
        int index = 0;
        try {
            input = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (input.hasNextInt()) {
            int n = input.nextInt();
            elements[index] = n;
            index++;
        }
        input.close();
    }

    // Writes the string "line" to the next available line in the "output.csv" file
    private static void EscreveLinha(String line) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\Samuel Sampaio\\Desktop\\Luis2\\output.csv", true);
            fileWriter.write(line + "\n"); // Write the line to the file
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Removes all text from the "output.csv" file
    private static void LimpaFicheiro() {
        try {
            FileWriter csvWriter = new FileWriter("C:\\Users\\Samuel Sampaio\\Desktop\\Luis2\\output.csv");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
