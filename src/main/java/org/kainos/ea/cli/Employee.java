package org.kainos.ea.cli;

public class Employee {
    private int employeeId;
    private String name;
    private double salary;
    private double monthlySales;
    private float commissionRate;

    public Employee(int employeeId, String name, double salary) {
        setEmployeeId(employeeId);
        setName(name);
        setSalary(salary);
    }

    public double calcPay(String role) {
        if (role == "Software Engineer") {
            return getSalary()/12 + 1000;
        } else {
            return getSalary()/12;
        }

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(double monthlySales) {
        this.monthlySales = monthlySales;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }
}
