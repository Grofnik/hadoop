package org.example;

import Client.HdfsClient;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            HdfsClient client = new HdfsClient();
            System.out.print("Hello! You can type command below. If you need help, print 'help': ");
            List<String> comand;
            do {
                comand = List.of(in.nextLine().split(" "));
                switch (comand.get(0)) {
                    case "help":
                        System.out.println("Hey! I have next command:\nmkdir <namedir>\nput <namefile>\nget <namefile>/" +
                                "\nls\n ");
                    case "mkdir":
                        System.out.println((client.mkdir(comand)) ? "Ok" : "error: mkdir");
                        continue;
                    case "put":
                        System.out.println((client.put(comand)) ? "Ok" : "error: put");
                        continue;
                    case "get":
                        System.out.println((client.get(comand)) ? "Ok" : "error: get");
                        continue;
                    case "append":
                        List<String> filePath = List.of(comand.stream().skip(1).collect(Collectors.joining("/")).split("//"));
                        System.out.println((client.append(filePath.get(0),filePath.get(1))) ? "Ok" : "error: append");
                        continue;
                    case "delete":
                        System.out.println((client.delete(comand)) ? "Ok" : "v: delete");
                        continue;
                    case "ls":
                        System.out.println((client.ls()) ? "Ok" : "error: ls");
                        continue;
                    case "cd":
                        System.out.println((client.cd(comand)) ? "Ok" : "error: cd");
                        continue;
                    case "lls":
                        System.out.println((client.lls()) ? "Ok" : "error: lls");
                        continue;
                    case "lcd":
                        System.out.println((client.lcd(comand)) ? "Ok" : "error: lcd");
                        continue;
                    default:
                        System.out.println("Command not found");
                        ;
                }
            } while ((!comand.contains("exit")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
