package com.example.herokudemo.diioc;

public class MyFramework {
    public ITest init() {
        Manager m = new Manager(); // jdbc:demo
        ITest tc = new TestController(m);

        // reflection

        return tc;
    }
}
