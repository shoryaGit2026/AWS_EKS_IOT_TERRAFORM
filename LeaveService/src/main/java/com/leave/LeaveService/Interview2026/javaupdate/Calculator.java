package com.leave.LeaveService.Interview2026.javaupdate;

@FunctionalInterface
public interface Calculator {

    public void add(int a, int b);

    default public void printMethod()
    {
        System.out.println("Functional interface.....");
    }
}
