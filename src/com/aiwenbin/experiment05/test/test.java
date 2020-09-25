package com.aiwenbin.experiment05.test;

import com.aiwenbin.experiment05.entity.College;
import com.aiwenbin.experiment05.entity.Student;
import com.aiwenbin.experiment05.entity.Teacher;
import com.aiwenbin.experiment05.resource.DatabaseUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        System.out.println(getCourseName(DatabaseUtils.getStudents(), 201001));
         printCollegeName(DatabaseUtils.getStudents(), 201001, 1002);
    }

    /**
     * 基于给定学生集合，学生编号，实现获取学生的导师的所在学院名称。
     * 任何一项不存在或失败，打印显式 未知学院
     *
     * @param students
     * @param sNumber
     * @return
     */
    private static String getCourseName(List<Student> students, int sNumber) {
        String[] res = new String[1];
        students.stream()
                .filter(student -> student.getNumber() == sNumber)
                .collect(Collectors.toList())
                .forEach(s -> {
                    res[0] = Optional.ofNullable(s)
                            .map(Student::getTeacher)
                            .map(Teacher::getCollege)
                            .map(College::getName)
                            .orElse("未知学院");
                });
        return res[0];
    }

    /**
     * 实现在给定学生集合中查询指定编号学生，如果学生导师编号为指定编号，打印显式导师所在学院名称。
     * 任何一项不存在或失败，打印显式 未知学院
     *
     * @param students
     * @param sNumber
     * @param tNumber
     */
    private static void printCollegeName(List<Student> students, int sNumber, int tNumber) {
        final String[] res = new String[1];
        students.stream()
                .filter(student -> student.getNumber() == sNumber)
                .collect(Collectors.toList())
                .forEach(s -> {
                    res[0] = Optional.ofNullable(s)
                            .map(Student::getTeacher)
                            .filter(teacher -> teacher.getNumber() == tNumber)
                            .map(Teacher::getCollege)
                            .map(College::getName)
                            .orElse("未知学院");
                });
        System.out.println(res[0]);
    }
}
