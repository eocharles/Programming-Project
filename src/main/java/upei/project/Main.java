//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package upei.project;

/**
 * The main class
 * Demonstrates basic functionality such as variable setting, retrieval, and a simple loop.
 */
public class Main {
    private int exampleVar = 0; // Example variable used for demonstration

    /**
     * Default constructor for the Main class.
     */
    public Main() {
        // Default constructor logic, if any
    }

    /**
     * Sets the value of the example variable.
     * @param inVal The value to set for exampleVar.
     */
    protected void setExampleVar(int inVal) {
        this.exampleVar = inVal; // Assigns the provided value to exampleVar
    }

    /**
     * Retrieves the value of the example variable.
     * @return The current value of exampleVar.
     */
    public int getExampleVar() {
        return this.exampleVar; // Returns the value of exampleVar
    }

    /**
     * The main method, serving as the entry point of the application.
     * Demonstrates a simple loop that prints numbers from 1 to 5.
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; ++i) {
            System.out.println("i = " + i);
        }
    }
}
