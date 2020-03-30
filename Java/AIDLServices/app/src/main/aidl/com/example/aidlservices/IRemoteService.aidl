// IRemoteService.aidl
package com.example.aidlservices;

// Declare any non-default types here with import statements

interface IRemoteService {

    int getPid();
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    double sum(double first, double second);
}
