package com.changingfond.jvmstaus;

public class JVMStatus {
  public static void main(String[] args) {
    Runtime runtime = Runtime.getRuntime();
    // the maximum amount of memory that the Java virtual machine
    // will attempt to use.
    System.out.println("max memory: " +
        runtime.maxMemory() / 1024 / 1024 / 1024 + " G");
    // the total amount of memory in the Java virtual machine.
    System.out.println("total memory: " +
        runtime.totalMemory() / 1024 / 1024 + " M");
    // the amount of free memory in the Java Virtual Machine.
    System.out.println("free memory: " +
        runtime.freeMemory() / 1024 / 1024 + " M");
    // the number of processors available to the Java virtual machine.
    System.out.println("available processors: " +
        runtime.availableProcessors());
    // runtime.gc = system.gc
    runtime.gc();
    System.gc();
  }
}
