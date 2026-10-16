package org.example;

import java.util.ArrayList;
import java.util.List;

public class Homework {

    public boolean isEven(int n) {
        return n % 2 == 0;
    }


    public String checkAccess(int age) {
        return age >= 18 ? "Allowed" : "Denied";

    }


    public boolean isPositive(int n) {
        return n >= 0 ? true : false;
    }

    public String getGrade(int score) {
        String Grade;
        if (score >= 0 && score <= 20)
            Grade = "E";
        else if (score >= 21 && score <= 40)
            Grade = "D";
        else if (score >= 41 && score <= 60)
            Grade = "C";
        else if (score >= 61 && score <= 80)
            Grade = "B";
        else if (score >= 81 && score <= 100)
            Grade = "A";
        else Grade = "Не подходит под диапазон";
        return Grade;
    }

    public String blastOff(int start) {
        String countdown = "";
        for (int i = start; i > 0; i--) {
            countdown = countdown + i + " ";
            //countdown = countdown + " Поехали!";
        }
        return countdown + "Поехали!";
    }

    public int sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public boolean hasBug(String[] messages) {
        for (String string : messages) {
            if ("Bug".equals(string))
                return true;
        }
        return false;
    }

    public String getEvenInRange(int start, int end) {
        String evenInRange = "";
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                if (!evenInRange.isEmpty()) {
                    evenInRange = evenInRange + " ";
                }
                evenInRange = evenInRange + i;
            }
        }
        return evenInRange;
    }
    public int findMax(int[] arr) {
        int max = arr[0];
        for (int number : arr) {
            if (number > max)
                max = number;
        }
        return max;
    }
    public String[] reverse(String[] arr) {
        String[] newArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr.length - i - 1] = arr[i];
        }
        return newArr;
    }
    public int calcAverage(List<Integer> list) {
        int average = 0;
        for (int i = 0; i < list.size(); i++) {
            average = average + list.get(i);
        }
        average = average / list.size();
        return average;
    }

    public List<String> removeSpecificName(List<String> list, String nameToRemove) {
        List<String> filteredName = new ArrayList<>();
        for (String name : list) {
            if (!name.equals(nameToRemove)) {
                filteredName.add(name);
            }
        }
        return filteredName;
    }
}