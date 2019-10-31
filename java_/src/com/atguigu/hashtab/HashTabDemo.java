package com.atguigu.hashtab;

import java.util.Scanner;

public class HashTabDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Employee employee = new Employee(id, name);
                    hashTab.add(employee);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}

class HashTab {
    private EmployeeLinkedList[] EmployeeLinkedListArray;
    private int size; //表示有多少条链表

    public HashTab(int size) {
        this.size = size;
        EmployeeLinkedListArray = new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {
            EmployeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee employee) {
        int employeeLinkedListNO = hashFun(employee.id);
        EmployeeLinkedListArray[employeeLinkedListNO].add(employee);
    }

    public int hashFun(int id) {
        return id % size;
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            EmployeeLinkedListArray[i].list(i);
        }
    }

    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Employee emp = EmployeeLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }


}

class EmployeeLinkedList {
    private Employee head;

    public void add(Employee employee) {
        if (head == null) {
            head = employee;
            return;
        }

        Employee curEmployee = head;
        while (true) {
            if (curEmployee.next == null) break;
            curEmployee = curEmployee.next;
        }
        curEmployee.next = employee;
    }

    public void list(int no) {
        if (head == null) { //说明链表为空
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }

        System.out.print("第 " + (no + 1) + " 链表的信息为");
        Employee curEmployee = head; //辅助指针
        while (true) {
            System.out.printf(" => id=%d name=%s\t", curEmployee.id, curEmployee.name);
            if (curEmployee.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmployee = curEmployee.next; //后移，遍历
        }
        System.out.println();
    }

    public Employee findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Employee curEmp = head;
        while (true) {
            if (curEmp.id == id) break;
            //退出
            if (curEmp.next == null) {//说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//以后
        }

        return curEmp;
    }

}

class Employee {

    public int id;
    public String name;
    public Employee next; //next 默认为 null

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}