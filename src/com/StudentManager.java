package com;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import netscape.javascript.JSUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();

        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");

            Scanner input = new Scanner(System.in);
            String line = input.nextLine();

            switch (line) {
                case "1":
                    System.out.println("添加学生");
                    addStudents(array);
                    break;
                case "2":
                    System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
                    System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
                    System.out.println("查看所有学生");
                    findAllStudents(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);
            }
        }
    }

    public static void addStudents(ArrayList<Student> array){
        Scanner input = new Scanner(System.in);

        System.out.println("请输入学生学号：");
        String sid = input.nextLine();

        boolean flag;
        if(array.size()==0) {
            flag = false;
        }else{
            flag = true;
        }

        while(flag){
            for(int i=0;i<array.size();i++){
                Student s = array.get(i);
                if(s.getSid().equals(sid)){
                    System.out.println("学号已存在，请重新输入");
                    System.out.println("请输入学生学号：");
                    sid = input.nextLine();
                }
                else{
                    flag=false;
                }
            }
        }

        System.out.println("请输入学生姓名：");
        String name = input.nextLine();
        System.out.println("请输入学生年龄：");
        String age = input.nextLine();
        System.out.println("请输入学生居住地：");
        String address = input.nextLine();

        Student s = new Student(sid,name,age,address);

        array.add(s);
        System.out.println("添加学生成功");
    }

    public static void findAllStudents(ArrayList<Student> array){
        if(array.size() == 0){
            System.out.println("无信息，请先添加信息再查询");
            return;
        }
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"\t\t"+s.getAddress()+"\t");
        }
    }

    public static void deleteStudent(ArrayList<Student> array){
        Scanner input = new Scanner(System.in);

        System.out.println("请输入你要删除的学生的学号");
        String sid=input.nextLine();

        for (int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid)){
                array.remove(i);
                System.out.println("删除成功");
                break;
            }
        }

        System.out.println("无学生信息");
    }

    public static void updateStudent(ArrayList<Student> array){
        Scanner input = new Scanner(System.in);

        System.out.println("请输入你要修改的学生的学号：");
        String sid = input.nextLine();

        System.out.println("请输入学生姓名：");
        String name = input.nextLine();
        System.out.println("请输入学生年龄：");
        String age = input.nextLine();
        System.out.println("请输入学生居住地：");
        String address = input.nextLine();

        Student s = new Student(sid,name,age,address);

        for(int i=0;i<array.size();i++){
            Student student=array.get(i);
            if(student.getSid().equals(sid)){
                array.set(i,s);
                break;
            }
        }
        System.out.println("修改学生信息成功！");
    }
}
